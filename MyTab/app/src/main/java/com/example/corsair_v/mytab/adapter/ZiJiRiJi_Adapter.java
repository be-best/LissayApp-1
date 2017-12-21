package com.example.corsair_v.mytab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsair_v.mytab.R;
import com.example.corsair_v.mytab.classpg.ZiJiDiary;

import java.util.List;

/**
 * Created by 45度炸 on 2017/12/21.
 */
//
//public class ZiJiRiJi_Adapter {
//}
public class ZiJiRiJi_Adapter extends android.widget.BaseAdapter {
    private List<ZiJiDiary> ZiJiDiary;
    // 固定写法，用于接收activity传递的值
    private Context context;

    public ZiJiRiJi_Adapter(Context context,List<ZiJiDiary> ZiJiDiary){
        this.context = context;
        this.ZiJiDiary = ZiJiDiary;
    }
    @Override
    public int getCount() {
        return ZiJiDiary.size();
    }

    @Override
    public Object getItem(int position) {
        return ZiJiDiary.get(position);
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
        View myView = LayoutInflater.from(context).inflate(R.layout.zijiriji_item, null);
        TextView date1 = (TextView) myView.findViewById(R.id.date1);
        TextView text1= (TextView) myView.findViewById(R.id.text1);
        date1.setText(ZiJiDiary.get(position).getDiaryText());
        text1.setText(ZiJiDiary.get(position).getDiaryDate());

//        TextView diaryTitle = (TextView) myView.findViewById(R.id.diaryTitle);
//        TextView diaryDate = (TextView) myView.findViewById(R.id.diaryDate);
//        TextView diaryEmotion = (TextView) myView.findViewById(R.id.diaryEmotion);
//        diaryTitle.setText(diary.get(position).getDiaryTitle());
//        diaryDate.setText(diary.get(position).getDiaryDate());
//        diaryEmotion.setText(diary.get(position).getEmotion());
        return myView;
    }
}

