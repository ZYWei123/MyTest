package com.hzyc.yy.demo_03;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText setValue;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setValue = (EditText) findViewById(R.id.setValue);
        back = (Button) findViewById(R.id.back);

        Intent intent = getIntent();
        //get取值
      /*  String name = intent.getStringExtra("name");
        int num = intent.getIntExtra("age",0);*/
        //0用来判断取值是否成功
       /* if(num == 0){

        }*/
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        int num = bundle.getInt("age");
        setValue.setText(name+"@@"+num);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回跳  并且传值
                String backValue = setValue.getText().toString().trim();
                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra("back",backValue);

                //回跳
                setResult(400,intent1);
                finish();//关闭
            }
        });
    }
}
