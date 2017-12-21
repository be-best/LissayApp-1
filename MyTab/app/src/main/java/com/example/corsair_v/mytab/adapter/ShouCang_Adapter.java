package com.example.corsair_v.mytab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsair_v.mytab.R;
import com.example.corsair_v.mytab.classpg.ShouCangLieBiao;

import java.util.List;

/**
 * Created by 45度炸 on 2017/12/21.
 */

//public class ShouCang_Adapter {
//}
public class ShouCang_Adapter extends android.widget.BaseAdapter {
    private List<com.example.corsair_v.mytab.classpg.ShouCangLieBiao> ShouCangLieBiao;
    // 固定写法，用于接收activity传递的值
    private Context context;

    public ShouCang_Adapter(Context context,List<ShouCangLieBiao>ShouCangLieBiao){
        this.context = context;
        this.ShouCangLieBiao = ShouCangLieBiao;
    }
    @Override
    public int getCount() {
        return ShouCangLieBiao.size();
    }

    @Override
    public Object getItem(int position) {
        return ShouCangLieBiao.get(position);
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
        View myView = LayoutInflater.from(context).inflate(R.layout.shoucang_item, null);
        TextView shoucang = (TextView) myView.findViewById(R.id.shoucang);
//        TextView text= (TextView) myView.findViewById(R.id.text);
        shoucang.setText(ShouCangLieBiao.get(position).getDiaryText());
//        text.setText(tab_1.get(position).getDiaryDate());

//        TextView diaryTitle = (TextView) myView.findViewById(R.id.diaryTitle);
//        TextView diaryDate = (TextView) myView.findViewById(R.id.diaryDate);
//        TextView diaryEmotion = (TextView) myView.findViewById(R.id.diaryEmotion);
//        diaryTitle.setText(diary.get(position).getDiaryTitle());
//        diaryDate.setText(diary.get(position).getDiaryDate());
//        diaryEmotion.setText(diary.get(position).getEmotion());
        return myView;
    }
}

