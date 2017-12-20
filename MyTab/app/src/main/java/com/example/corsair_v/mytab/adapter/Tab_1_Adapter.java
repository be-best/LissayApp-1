package com.example.corsair_v.mytab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsair_v.mytab.R;
import com.example.corsair_v.mytab.classpg.Diary;

import java.util.List;

//import com.zws.team_project.R;

/**
 * Created by 45度炸 on 2017/12/19.
 */

/**
 *listview适配器
 */
//public class tab_1_Adapter {
//}

public class Tab_1_Adapter extends android.widget.BaseAdapter {
    private List<Diary> tab_1;
    // 固定写法，用于接收activity传递的值
    private Context context;

    public Tab_1_Adapter(Context context,List<Diary> tab_1){
        this.context = context;
        this.tab_1 = tab_1;
    }
    @Override
    public int getCount() {
        return tab_1.size();
    }

    @Override
    public Object getItem(int position) {
        return tab_1.get(position);
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
        View myView = LayoutInflater.from(context).inflate(R.layout.tab_1_item, null);
        TextView date = (TextView) myView.findViewById(R.id.date);
        TextView text= (TextView) myView.findViewById(R.id.text);
        date.setText(tab_1.get(position).getDiaryText());
        text.setText(tab_1.get(position).getDiaryDate());

//        TextView diaryTitle = (TextView) myView.findViewById(R.id.diaryTitle);
//        TextView diaryDate = (TextView) myView.findViewById(R.id.diaryDate);
//        TextView diaryEmotion = (TextView) myView.findViewById(R.id.diaryEmotion);
//        diaryTitle.setText(diary.get(position).getDiaryTitle());
//        diaryDate.setText(diary.get(position).getDiaryDate());
//        diaryEmotion.setText(diary.get(position).getEmotion());
        return myView;
    }
}
