package com.example.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter extends BaseAdapter {

    private final List<Weather> mData;
    private Map<String, Integer> mWeatherImageMap;

    public MyFirstAdapter(List<Weather> mData) {

        this.mData = mData;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음", R.drawable.sunny);
        mWeatherImageMap.put("폭설", R.drawable.blizzard);
        mWeatherImageMap.put("구름", R.drawable.cloudy);
        mWeatherImageMap.put("비", R.drawable.rainy);
        mWeatherImageMap.put("눈", R.drawable.snow);

    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);

        ImageView weatherImage = convertView.findViewById(R.id.weather_image);
        TextView cityText = convertView.findViewById(R.id.city_text);
        TextView tempText = convertView.findViewById(R.id.temp_text);

        Weather weather = mData.get(position);

        cityText.setText( weather.getCity());
        tempText.setText( weather.getTemp());
        weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));

        return convertView;


    }
}
