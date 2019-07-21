package com.example.flag;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class FlagAdapter extends ArrayAdapter<Flag> {
    ArrayList<Flag> flags = new ArrayList<Flag>();
    Activity activity;

    public FlagAdapter(Activity activity, ArrayList<Flag> flags) {
        super(activity, R.layout.flag_list_item, flags);
        this.flags = flags;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FlagViewHolder flagViewHolder=null;
        Flag flag = flags.get(position);
        View itemView = convertView;
        if (itemView == null) {  //
            flagViewHolder = new FlagViewHolder();   //화면 재활용 객체
            itemView = activity.getLayoutInflater().inflate(R.layout.flag_list_item, parent, false);
            flagViewHolder.imageView = (ImageView)itemView.findViewById(R.id.flagImage);
            flagViewHolder.flagKorName = (TextView) itemView.findViewById(R.id.flagKorName);
            flagViewHolder.flagCode = (TextView) itemView.findViewById(R.id.flagCode);
            flagViewHolder.flagEngName = (TextView) itemView.findViewById(R.id.flagEngName);
            flagViewHolder.flagShortName = (TextView) itemView.findViewById(R.id.flagShortName);
            itemView.setTag(flagViewHolder);
        }else{
            flagViewHolder = (FlagViewHolder) itemView.getTag();
        }
        //재활용을 이용하여 화면에 데이터를 입력한다.
        flagViewHolder.imageView.setImageResource(flag.getRid());
        flagViewHolder.flagKorName.setText(flag.getFlagKorName());
        flagViewHolder.flagCode.setText(flag.getFlagCode());
        flagViewHolder.flagEngName.setText(flag.getFlagEngName());
        flagViewHolder.flagShortName.setText(flag.getFlagShortName());

        return itemView;
    }

}

class FlagViewHolder{
    public ImageView imageView;
    public TextView flagKorName;
    public TextView flagCode;
    public TextView flagEngName;
    public TextView flagShortName;
}