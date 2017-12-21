package com.example.corsair_v.mytab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BianJiXiuGai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bian_ji_xiu_gai);
    }
    public void bianji(View v)
    {
        //Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
        //startActivity(intent);
        BianJiXiuGai.this.finish();
    }
}
