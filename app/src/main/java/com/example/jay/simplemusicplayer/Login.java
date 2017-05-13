package com.example.jay.simplemusicplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jay on 2017/5/13.
 */

public class Login extends AppCompatActivity {

    private Button login, create;
    private EditText account, password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button) findViewById(R.id.loginbtn);
        create = (Button) findViewById(R.id.create);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
    }
}
