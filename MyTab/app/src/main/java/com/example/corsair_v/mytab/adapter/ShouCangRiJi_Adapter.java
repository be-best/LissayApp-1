package com.example.corsair_v.mytab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsair_v.mytab.R;
import com.example.corsair_v.mytab.classpg.ShouCangRiJi;

import java.util.List;

/**
 * Created by 45度炸 on 2017/12/21.
 */

public class ShouCangRiJi_Adapter extends android.widget.BaseAdapter {
    private List<com.example.corsair_v.mytab.classpg.ShouCangRiJi> ShouCangRiJi;
    // 固定写法，用于接收activity传递的值
    private Context context;

    public ShouCangRiJi_Adapter(Context context,List<ShouCangRiJi> ShouCangRiJi){
        this.context = context;
        this.ShouCangRiJi = ShouCangRiJi;
    }
    @Override
    public int getCount() {
        return ShouCangRiJi.size();
    }

    @Override
    public Object getItem(int position) {
        return ShouCangRiJi.get(position);
    }
//    public Object getItem(int position) {
//        return tab_1.get(position);
//    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = LayoutInflater.from(context).inflate(R.layout.shoucangriji_item, null);
        TextView date2 = (TextView) myView.findViewById(R.id.date2);
        TextView text2= (TextView) myView.findViewById(R.id.text2);
        date2.setText(ShouCangRiJi.get(position).getDiaryText());
        text2.setText(ShouCangRiJi.get(position).getDiaryDate());

//        TextView diaryTitle = (TextView) myView.findViewById(R.id.diaryTitle);
//        TextView diaryDate = (TextView) myView.findViewById(R.id.diaryDate);
//        TextView diaryEmotion = (TextView) myView.findViewById(R.id.diaryEmotion);
//        diaryTitle.setText(diary.get(position).getDiaryTitle());
//        diaryDate.setText(diary.get(position).getDiaryDate());
//        diaryEmotion.setText(diary.get(position).getEmotion());
        return myView;
    }
}
