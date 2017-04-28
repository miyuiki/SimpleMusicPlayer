package com.example.jay.simplemusicplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jay on 2017/4/28.
 */

public class Second extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        Button tohome = (Button) findViewById(R.id.home);
        tohome.setOnClickListener(toHomeListener);
    }
    private Button.OnClickListener toHomeListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
