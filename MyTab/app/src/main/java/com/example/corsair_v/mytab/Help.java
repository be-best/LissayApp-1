package com.example.corsair_v.mytab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    //返回
    public void help(View v)
    {
        //Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
        //startActivity(intent);
        Help.this.finish();
    }
}
