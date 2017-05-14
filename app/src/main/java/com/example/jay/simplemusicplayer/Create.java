package com.example.jay.simplemusicplayer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jay on 2017/5/14.
 */

public class Create extends AppCompatActivity {
    private EditText new_account, new_password;
    private Button enter, reset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        new_account = (EditText) findViewById(R.id.new_account);
        new_password = (EditText) findViewById(R.id.new_password);
        enter = (Button) findViewById(R.id.check);
        reset = (Button) findViewById(R.id.reset);

        enter.setOnClickListener(enterListener);
        reset.setOnClickListener(resetListener);
    }
    private Button.OnClickListener enterListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            String newa = new_account.getText().toString();
            String newp = new_password.getText().toString();
            SharedPreferences sp = getSharedPreferences("profile",MODE_PRIVATE );
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("Account",newa);
            editor.putString("Password",newp);
            editor.commit();
            finish();
        }
    };
    private Button.OnClickListener resetListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            SharedPreferences sp = getSharedPreferences("profile",MODE_PRIVATE);
            sp.edit()
                    .clear()
                    .commit();
            Toast t = Toast.makeText(Create.this, "帳號已重設完成", Toast.LENGTH_LONG);
            t.show();
            finish();
        }
    };
}
