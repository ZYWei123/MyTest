package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private CheckBox lq, yy, js, lx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lq = (CheckBox) findViewById(R.id.lq);
        yy = (CheckBox) findViewById(R.id.yy);
        js = (CheckBox) findViewById(R.id.js);
        lx = (CheckBox) findViewById(R.id.lx);

      /*  lq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的爱好是篮球", Toast.LENGTH_SHORT).show();
            }
        });

        yy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的爱好是篮球", Toast.LENGTH_SHORT).show();
            }
        });

        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的爱好是篮球", Toast.LENGTH_SHORT).show();
            }
        });

        lx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的爱好是篮球", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void check(View view) {
        //怎么判断谁点击了这个事件
        int id = view.getId();
        Log.i("输出信息", "@@@@@" + id);
        Log.i("输出信息", "@@@@@" + R.id.lq);
        String str = "";
        switch (id) {
            case R.id.lq:
                str += "篮球";
                break;
            case R.id.yy:
                str += "游泳";
                break;
            case R.id.js:
                str += "健身";
                break;
            case R.id.lx:
                str += "旅行";
                break;
        }
        Toast.makeText(Main2Activity.this, "我的爱好是="+str, Toast.LENGTH_SHORT).show();
    }
}
