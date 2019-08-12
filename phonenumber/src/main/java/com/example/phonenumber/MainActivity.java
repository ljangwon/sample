package com.example.phonenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelecomManager telManager = (TelecomManager) getSystemService(TELECOM_SERVICE);

        if( telManager !=null ) {

            phoneNumber = telManager.getLine1Number(null);

            if( phoneNumber == null) {
                phoneNumber = "8210";
            }

        } else { phoneNumber = "8210";}

        if(phoneNumber !=null && phoneNumber.startsWith("+82")) {
            phoneNumber = phoneNumber.replace("+82", "0");

            Log.d("READ_SMS : ", String.valueOf((checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)));
            Log.d("READ_PHONE_NUMBERS : ", String.valueOf((checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED)));
            Log.d("READ_PHONE_STATE : ", String.valueOf((checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)));
        }
    }
}
