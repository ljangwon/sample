package com.example.flag;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Flag> flags ;

    TextView name;
    ImageView bigFlag;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle( "국가 국기");

        name = findViewById(R.id.flagKorName);
        bigFlag = findViewById(R.id.bigFlag);
        list = findViewById(R.id.flagList);

        flags = readFlags();

        ArrayAdapter<Flag> adapter = new FlagsAdapter(this,flags);

        list.setAdapter( adapter);

    }
    private ArrayList<Flag> readFlags() {
        ArrayList<Flag> flags = new ArrayList<>();
        flags.clear();
        flags.add(new Flag("Ghana", "GH", "288", "가나", R.drawable.gh));
        flags.add(new Flag("Gabon", "GA", "266", "가봉", R.drawable.ga));
        flags.add(new Flag("Guyana", "GY", "328", "가이아나", R.drawable.gy));
        flags.add(new Flag("Gambia", "GM", "270", "감비아", R.drawable.gm));
        flags.add(new Flag("Guernsey", "GG", "831", "건지 섬", R.drawable.gg));
        flags.add(new Flag("France", "GP", "312", "과들루프", R.drawable.gp));
        flags.add(new Flag("Guatemala", "GT", "320", "과테말라", R.drawable.gt));
        flags.add(new Flag("Guam", "GU", "316", "괌", R.drawable.gu));
        flags.add(new Flag("Grenada", "GD", "308", "그레나다", R.drawable.gd));
        flags.add(new Flag("Greece", "GR", "300", "그리스", R.drawable.gr));
        flags.add(new Flag("Greenland", "GL", "304", "그린란드", R.drawable.gl));
        flags.add(new Flag("Guinea", "GN", "324", "기니", R.drawable.gn));
        flags.add(new Flag("Guinea-Bissau", "GW", "624", "기니비사우", R.drawable.gw));
        flags.add(new Flag("Namibia", "NA", "516", "나미비아", R.drawable.na));
        flags.add(new Flag("Nauru", "NR", "520", "나우루", R.drawable.nr));
        flags.add(new Flag("Nigeria", "NG", "566", "나이지리아", R.drawable.ng));
        flags.add(new Flag("Antarctica", "AQ", "010", "남극", R.drawable.aq));
        flags.add(new Flag("South Sudan", "SS", "728", "남수단", R.drawable.ss));
        flags.add(new Flag("South Africa", "ZA", "710", "남아프리카 공화국", R.drawable.za));
        flags.add(new Flag("Netherlands", "NL", "528", "네덜란드", R.drawable.nl));
        flags.add(new Flag("Netherlands Antilles (1986-2010)", "AN", "530", "네덜란드령 안틸레스", R.drawable.an));
        flags.add(new Flag("Nepal", "NP", "524", "네팔", R.drawable.np));
        flags.add(new Flag("Norway", "NO", "578", "노르웨이", R.drawable.no));
        flags.add(new Flag("Norfolk Island", "NF", "574", "노퍽 섬", R.drawable.nf));
        flags.add(new Flag("France", "NC", "540", "누벨칼레도니", R.drawable.nc));
        flags.add(new Flag("New Zealand", "NZ", "554", "뉴질랜드", R.drawable.nz));
        flags.add(new Flag("Niue", "NU", "570", "니우에", R.drawable.nu));
        flags.add(new Flag("Niger", "NE", "562", "니제르", R.drawable.ne));
        flags.add(new Flag("Nicaragua", "NI", "558", "니카라과", R.drawable.ni));
        flags.add(new Flag("South Korea", "KR", "410", "대한민국", R.drawable.kr));
        return flags;
    }
}
