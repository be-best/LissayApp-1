package com.example.corsair_v.mytab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.corsair_v.mytab.adapter.MainViewAdapter;
import com.example.corsair_v.mytab.listener.OnTabSelectedListener;
import com.example.corsair_v.mytab.widget.Tab;
import com.example.corsair_v.mytab.widget.TabContainerView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id. mainLayout, new HomeFragment());
        }

        TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_container);
        MainViewAdapter mainViewAdapter=new MainViewAdapter(getSupportFragmentManager(),
                new Fragment[] {new HomeFragment(), new CollectFragment(),new AddFragment(), new StarFragment(),new UserFragment()});
        tabContainerView.setAdapter(mainViewAdapter);
        tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {

            }
        });
    }

    //跳转到添加收藏自定义分类界面
    public void tianjia(View v) {
        Intent intent = new Intent(MainActivity.this, ShouCang.class);
        startActivity(intent);
    }
//    public void re_Logout(View v)
//    {
//        Intent intent = new Intent(MainActivity.this,FirstLogin.class);
//        startActivity(intent);
//    }
}
