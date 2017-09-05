package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity_one);
    }

    //默认自动注册 自动显示
    //激活了默认菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //显示什么菜单文件呢？
        MenuInflater menuInflater = getMenuInflater();
        //填充菜单文件
        menuInflater.inflate(R.menu.menu_one,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //选择处理

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  R.id.save :
                Toast.makeText(MenuActivityOne.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.update :
                Toast.makeText(MenuActivityOne.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete :
                Toast.makeText(MenuActivityOne.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
