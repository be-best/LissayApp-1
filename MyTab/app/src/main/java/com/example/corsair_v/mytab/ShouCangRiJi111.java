package com.example.corsair_v.mytab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.corsair_v.mytab.adapter.ShouCangRiJi_Adapter;
import com.example.corsair_v.mytab.classpg.ShouCangRiJi;

import java.util.List;

public class ShouCangRiJi111 extends AppCompatActivity {
    private List<ShouCangRiJi> shoucangriji;
    public static ShouCangRiJi oneshoucangriji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_cang_ri_ji);
    }

    public void set(){
        ListView rijixsListView = (ListView) findViewById(R.id.rijixsListView);
        rijixsListView.setAdapter(new ShouCangRiJi_Adapter(ShouCangRiJi111.this, shoucangriji));
        // 日记收藏里面的ListView监听
       rijixsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 监听内容
                oneshoucangriji = shoucangriji.get(position);
                Intent intent = new Intent(ShouCangRiJi111.this,XianShiRiJi.class);
                startActivity(intent);
            }
        });
    }
}
