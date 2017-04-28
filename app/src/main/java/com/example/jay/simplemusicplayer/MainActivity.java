package com.example.jay.simplemusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button topage2 = (Button) findViewById(R.id.button14);
        topage2.setOnClickListener(topage2Listener);
    }
    private Button.OnClickListener topage2Listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Second.class);
            startActivity(intent);
        }
    };
}
