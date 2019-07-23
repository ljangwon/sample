package com.example.loginexam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mEmailEditText;
    private CheckBox mSaveCheckBox;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEditText = findViewById(R.id.email_edit);
        mSaveCheckBox = findViewById(R.id.save_check);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean isChecked = mPreferences.getBoolean("save", false);
        mSaveCheckBox.setChecked(isChecked);
        if(isChecked) {
            String email = mPreferences.getString("email", "");
            mEmailEditText.setText(email);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences.Editor  editor = mPreferences.edit();

        editor.putBoolean("save", mSaveCheckBox.isChecked());
        editor.putString("email", mEmailEditText.getText().toString());
        editor.apply();
    }

    public void onImageClicked(View view) {
    }

    public void onButtonClicked(View view) {
    }
}
