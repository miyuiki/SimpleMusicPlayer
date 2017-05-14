package com.example.jay.simplemusicplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jay on 2017/5/13.
 */

public class Login extends AppCompatActivity {

    private Button login, create;
    private EditText account, password;
    private SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button) findViewById(R.id.loginbtn);
        create = (Button) findViewById(R.id.create);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(loginListener);
        create.setOnClickListener(createListener);
    }
    private Button.OnClickListener loginListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            sp = getSharedPreferences("profile",MODE_PRIVATE);
            String created_account = sp.getString("Account","unknown");
            String creaded_password = sp.getString("Password","unknown");
            String a = account.getText().toString();
            String p = password.getText().toString();
            if (creaded_password.equals("unknown") || created_account.equals("unknown")){
                new AlertDialog.Builder(Login.this)
                        .setTitle("警告")
                        .setMessage("請先建立帳號")
                        .setPositiveButton("朕知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
            else if(!a.equals(created_account) || !p.equals(creaded_password)){
                new AlertDialog.Builder(Login.this)
                        .setTitle("警告")
                        .setMessage("帳號或密碼有誤")
                        .setPositiveButton("朕知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
            else{
                Intent intent = new Intent();
                intent.setClass(Login.this,MainActivity.class);
                startActivity(intent);
            }
        }
    };
    private Button.OnClickListener createListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Login.this,Create.class);
            startActivity(intent);
        }
    };
}
