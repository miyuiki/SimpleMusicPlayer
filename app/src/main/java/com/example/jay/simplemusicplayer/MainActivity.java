package com.example.jay.simplemusicplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView songNum;
    private Button toPage2;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private Button clean,delete;
    private Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songNum = (TextView) findViewById(R.id.textView2);
        toPage2 = (Button) findViewById(R.id.button14);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b0 = (Button) findViewById(R.id.button0);
        clean = (Button) findViewById(R.id.button10);
        delete = (Button) findViewById(R.id.button12);
        list = (Button) findViewById(R.id.button13);

        toPage2.setOnClickListener(toPage2Listener);
        b1.setOnClickListener(numberListener);
        b2.setOnClickListener(numberListener);
        b3.setOnClickListener(numberListener);
        b4.setOnClickListener(numberListener);
        b5.setOnClickListener(numberListener);
        b6.setOnClickListener(numberListener);
        b7.setOnClickListener(numberListener);
        b8.setOnClickListener(numberListener);
        b9.setOnClickListener(numberListener);
        b0.setOnClickListener(numberListener);
        clean.setOnClickListener(cleanListener);
        delete.setOnClickListener(deleteListener);
        list.setOnClickListener(listListener);
    }
    private Button.OnClickListener toPage2Listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            String str = songNum.getText().toString();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Second.class);

            if (str.equals("請輸入歌曲號碼") || str.equals("")){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("警告")
                        .setMessage("請輸入歌曲號碼")
                        .setPositiveButton("朕知道了", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {}
                                })
                        .show();
            }
            else if(Integer.parseInt(str) > 5 || Integer.parseInt(str) < 1){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("警告")
                        .setMessage("沒有這首歌哦")
                        .setPositiveButton("朕知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
            else{
                Bundle bundle = new Bundle();
                bundle.putString("NUMBER", str);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private Button.OnClickListener numberListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            String str = songNum.getText().toString();
            if (str.equals("請輸入歌曲號碼")){
                songNum.setText("");
                str = "";
                Button btn = (Button) findViewById(view.getId());
                songNum.setText(str + btn.getText());
            }
            else{
                Button btn = (Button) findViewById(view.getId());
                songNum.setText(str + btn.getText());
            }
        }
    };

    private Button.OnClickListener cleanListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            songNum.setText("");
        }
    };

    private Button.OnClickListener deleteListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            String str = songNum.getText().toString();
            if (!str.equals(""))
                songNum.setText(str.substring(0,str.length()-1));
        }
    };

    private Button.OnClickListener listListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("歌曲清單")
                    .setMessage("01.編織星空的人\n02.旅行的意義\n03.面對明日的勇氣\n04.初恋\n05.ヒカリヘ")
                    .setPositiveButton("朕知道了", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {}
                            })
                    .show();
        }
    };
}
