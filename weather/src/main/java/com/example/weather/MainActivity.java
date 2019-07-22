package com.example.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList<Weather> data = new ArrayList<>();
       // for(int i=0 ; i<30 ; i++) {
       //     data.add("data"+i);
       // }

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        data.add( new Weather( "수원", "29", "맑음") );
        data.add( new Weather( "서울", "22", "비") );
        data.add( new Weather( "안양", "23", "구름") );
        data.add( new Weather( "부산", "27", "눈") );
        data.add( new Weather( "인천", "28", "폭설") );
        data.add( new Weather( "대구", "25", "비") );



        MyFirstAdapter adapter = new MyFirstAdapter(data);

        listView.setAdapter( adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position+" 번째 아이템", Toast.LENGTH_LONG);
            }
        });
    }
}
