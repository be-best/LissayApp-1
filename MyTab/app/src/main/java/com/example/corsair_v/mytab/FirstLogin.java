package com.example.corsair_v.mytab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstLogin extends AppCompatActivity implements View.OnClickListener {

    private Button login_Button;
    private Button forget_Button;
    private Button appleId_Button;
    private EditText id;
    private EditText password;
    private String str;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    Intent i = new Intent(FirstLogin.this, MainActivity.class);
                    startActivity(i);
                    break;
                }
                case 2: {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(FirstLogin.this);
                    dialog.setTitle("提示：");
                    dialog.setMessage(str);
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);
        login_Button = (Button) findViewById(R.id.login_Button);
        login_Button.setOnClickListener(this);
        forget_Button = (Button) findViewById(R.id.forgetPsw_Button);
        forget_Button.setOnClickListener(this);
        appleId_Button = (Button) findViewById(R.id.appleId_Button);
        appleId_Button.setOnClickListener(this);
        id = (EditText) findViewById(R.id.idUser);
        password = (EditText) findViewById(R.id.pswUser);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_Button: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        CUser cu = new CUser();
//                        str = "";
//                        str = cu.login(id.getText().toString(), password.getText().toString(), "123564");
//                        if (str == null) {
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
                break;
            }
            case R.id.forgetPsw_Button: {
                Intent i2 = new Intent(FirstLogin.this, FirstForget.class
                );
                startActivity(i2);
                break;
            }
            case R.id.appleId_Button: {
                Intent i3 = new Intent(FirstLogin.this, FirstRegister.class);
                startActivity(i3);
                break;
            }
            default:
                break;
        }
    }
}
