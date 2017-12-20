package com.example.corsair_v.mytab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UserSetting extends AppCompatActivity {

    private TextView logout;
    private View view;
    private TextView setting;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_tab_5_setting);
//
//        logout = (TextView) findViewById(R.id.re_Logout);
////**
//// *返回到原来碎片
//// **
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_5_setting);

        logout = (TextView) findViewById(R.id.back);

//        //返回到原来碎片
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //退出到登录界面
    public void re_Logout(View v) {
        Intent intent = new Intent(UserSetting.this, FirstLogin.class);
        startActivity(intent);
    }
    //跳转到帮助和反馈
    public void help(View v) {
        Intent intent = new Intent(UserSetting.this, Help.class);
        startActivity(intent);
    }
    //跳转到关于听说
    public void guanyutingshuo(View v) {
        Intent intent = new Intent(UserSetting.this, AboutLissay.class);
        startActivity(intent);
    }

//
//public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//    if(view == null){
//        view = inflater.inflate(R.layout.fragment_tab_5_setting,container ,false);
//        setting =(TextView) view.findViewById(R.id.help);//进入setting界面
//        setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UserSetting.this,Help.class);
//                startActivity(intent);
//            }
//        });
//    }
//    return view;
//}

}

