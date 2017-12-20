package com.example.corsair_v.mytab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutLissay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_lissay);
    }
    //返回到个人设置界面
    public void AboutLissayBack(View v)
    {
        //Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
        //startActivity(intent);
        AboutLissay.this.finish();
    }
//跳转到最新版本界面
    public void update(View v) {
        Intent intent = new Intent(AboutLissay.this, LissayUpdate.class);
        startActivity(intent);
    }
}
