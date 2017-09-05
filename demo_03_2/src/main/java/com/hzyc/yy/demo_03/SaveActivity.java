package com.hzyc.yy.demo_03;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {

    private EditText save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        save = (EditText) findViewById(R.id.save);



        //基本现场保护
        //savedInstanceState.putString("value",value);

        //创建文件 如果文件已经存在了 == 获取文件
        SharedPreferences sp = getSharedPreferences("data",0);
        String value = sp.getString("value","nothing");

        if(!"nothing".equals(value)){
            save.setText(value);
        }

    }

    //程序即将被销毁的时候调用
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String value = save.getText().toString().trim();
        boolean bol = false;
        if(!value.equals("")){
            //保护的数据永久存储下来 使用数据存储方案
            //数据存储到手机的XML中
            SharedPreferences sp = getSharedPreferences("data",0);
            //创建到手机中
            //查看这个文件 虚拟机可以 真机不可以（没有root）
            //得到这个文件的编辑权限
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("value",value);
            bol = editor.commit();
            Toast.makeText(SaveActivity.this, "保护的状态="+bol, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SaveActivity.this, "保护的状态="+bol, Toast.LENGTH_SHORT).show();
        }

    }
}
