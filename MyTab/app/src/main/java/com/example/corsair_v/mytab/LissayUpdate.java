package com.example.corsair_v.mytab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LissayUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lissay_update);
    }
    //返回关于听说界面
    public void LissayUpdateBack(View v)
    {
        //Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
        //startActivity(intent);
        LissayUpdate.this.finish();
    }
}
