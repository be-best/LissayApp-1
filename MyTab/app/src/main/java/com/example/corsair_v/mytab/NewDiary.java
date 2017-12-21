package com.example.corsair_v.mytab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diary);
    }
    public void newdiary(View v)
    {
        //Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
        //startActivity(intent);
        NewDiary.this.finish();
    }


}
