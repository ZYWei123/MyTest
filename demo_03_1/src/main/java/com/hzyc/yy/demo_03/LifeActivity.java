package com.hzyc.yy.demo_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeActivity extends AppCompatActivity {

    private Button button;
    @Override
    //1
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.i("message","onCreate");
        button = (Button) findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(LifeActivity.this,MainActivity.class);
                startActivity(intent); //开始跳转
            }
        });
    }

    //2
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("message","onStart");
    }

    //3 页面即将显示
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("message","onResume");
    }

    //4
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("message","onPause");
    }

    //5
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("message","onStop");
    }

    //6
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("message","onDestroy");
    }

    //7

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("message","onRestart");
    }
}
