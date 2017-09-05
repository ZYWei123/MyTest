package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivityTwo extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity_two);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(MenuActivityTwo.this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(arrayAdapter);

        //需要注册
        //注册listView上
        //默认注册到长单击事件上
        registerForContextMenu(listView);
    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("黑龙江省");
        list.add("吉林省");
        list.add("辽宁省");

        return list;
    }

    //1.创建
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //填充菜单文件
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_one,menu);
    }

    //2选择

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  R.id.save :
                Toast.makeText(MenuActivityTwo.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.update :
                Toast.makeText(MenuActivityTwo.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete :
                Toast.makeText(MenuActivityTwo.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
