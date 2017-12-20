package com.example.corsair_v.mytab;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by chengxi on 17/4/26.
 */
public class UserFragment extends Fragment {

    private View view;
    private TextView setting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(view == null){
            view = inflater.inflate(R.layout.fragment_tab_5  ,container ,false);
            setting =(TextView) view.findViewById(R.id.tv_btn_settings);//进入setting界面
            setting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(getActivity(),UserSetting.class);
                           startActivity(intent);
                    }
                });
            }
        return view;
    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        if(view == null){
//            view = inflater.inflate(R.layout.fragment_tab_5,container ,false);
//            setting =(TextView) view.findViewById(R.id.tv_btn_memorialday);//进入setting界面
//            setting.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(getActivity(),Help.class);
//                    startActivity(intent);
//                }
//            });
//        }
//        return view;
//    }
}



//    FragmentManager fm = getActivity().
//
//    @Override
//btn = (Button)view.findViewById(R.id.abc);
//        btn.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        getFragmentManager()
//        .beginTransaction()
//        .addToBackStack(null)
//        .replace(R.id.mainLayout , new HomeFragment())
//        .commit();
//        }
//        });