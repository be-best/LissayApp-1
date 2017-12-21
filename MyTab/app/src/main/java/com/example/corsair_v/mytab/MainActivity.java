package com.example.corsair_v.mytab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.corsair_v.mytab.adapter.MainViewAdapter;
import com.example.corsair_v.mytab.adapter.ShouCang_Adapter;
import com.example.corsair_v.mytab.adapter.Tab_1_Adapter;
import com.example.corsair_v.mytab.adapter.ZiJiRiJi_Adapter;
import com.example.corsair_v.mytab.classpg.Diary;
import com.example.corsair_v.mytab.classpg.ShouCangLieBiao;
import com.example.corsair_v.mytab.classpg.ZiJiDiary;
import com.example.corsair_v.mytab.listener.OnTabSelectedListener;
import com.example.corsair_v.mytab.widget.Tab;
import com.example.corsair_v.mytab.widget.TabContainerView;
import com.seprojects.lissayappserver.CTweet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Diary> diary;
    private List<ShouCangLieBiao> shoucang;
    private List<ZiJiDiary> zijiriji;
    public static Diary onediary;
    public static ShouCangLieBiao oneshoucang;
    public static ZiJiDiary onezijiriji;
    private CTweet tweet;
    private Bitmap tweetBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);
        tweet = new CTweet();
        getTweet();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id. mainLayout, new HomeFragment());
        }

        TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_container);
        MainViewAdapter mainViewAdapter=new MainViewAdapter(getSupportFragmentManager(),
                new Fragment[] {new HomeFragment(), new CollectFragment(), new StarFragment(),new UserFragment()});
//        new AddFragment(),
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

    public void newdiary(View v) {
        Intent intent = new Intent(MainActivity.this, NewDiary.class);
        startActivity(intent);
    }
//    public void re_Logout(View v)
//    {
//        Intent intent = new Intent(MainActivity.this,FirstLogin.class);
//        startActivity(intent);
//    }

    public void set(){
        ListView diaryListView = (ListView) findViewById(R.id.diaryListView);
        diaryListView.setAdapter(new Tab_1_Adapter(MainActivity.this, diary));
        // Tab_1的ListView监听
        diaryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 监听内容
                onediary = diary.get(position);
                Intent intent = new Intent(MainActivity.this,XianShiRiJi.class);
                startActivity(intent);
            }
        });
    }

    public void set2(){
        ListView shoucangListView = (ListView) findViewById(R.id.shoucangListView);
        shoucangListView.setAdapter(new ShouCang_Adapter(MainActivity.this, shoucang));
        // Main里面自定义收藏列表的ListView监听
        shoucangListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 监听内容
                oneshoucang = shoucang.get(position);
                Intent intent = new Intent(MainActivity.this,ShouCangRiJi111.class);
                startActivity(intent);
            }
        });
    }

    public void set3(){
        ListView reminderListView = (ListView) findViewById(R.id.zjrijiListView);
        reminderListView.setAdapter(new ZiJiRiJi_Adapter(MainActivity.this, zijiriji));
        // 自己日记的ListView监听
        reminderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 监听内容
                onezijiriji = zijiriji.get(position);
                Intent intent = new Intent(MainActivity.this,ZiJiRiJiShow.class);
                startActivity(intent);
            }
        });
    }

    public void getTweet() {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                        CUser cu = new CUser();
//                        str = "";
//                        str = cu.login(id.getText().toString(), password.getText().toString(), "123564");
//                        if (str == null) {
                tweet.CheckTweet();
                URL url = null;
                try {
                    url = new URL(tweet.getPic());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream is = null;
                try {
                    is = url.openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //从InputStream流中解析出图片
                tweetBitmap = BitmapFactory.decodeStream(is);
                //  imageview.setImageBitmap(bitmap);
                //发送消息，通知UI组件显示图片
                //关闭输入流
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
//                        } else {
//                            Message message = new Message();
//                            message.what = 2;
//                            handler.sendMessage(message);
//                        }
            }
        }).start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: { // 显示每日一推
                    ImageView tweetImage = (ImageView)findViewById(R.id.tweetImage);
                    TextView tweetText = (TextView)findViewById(R.id.tweetText);
                    tweetImage.setImageBitmap(tweetBitmap);
                    tweetText.setText(tweet.getContent());
                    break;
                }
                default:
                    break;
            }
        }
    };

    public Bitmap returnBitMap(String url){
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
