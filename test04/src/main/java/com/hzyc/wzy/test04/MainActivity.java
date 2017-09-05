package com.hzyc.wzy.test04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ImageView car;
    private EditText save;
    private ActionMode actionMode;
    private ImageView menu;

    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_one,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.save:
                    Toast.makeText(MainActivity.this,"保存",Toast.LENGTH_LONG).show();
                    break;
                case R.id.delete:
                    Toast.makeText(MainActivity.this,"删除",Toast.LENGTH_LONG).show();
                    break;
                case R.id.update:
                    Toast.makeText(MainActivity.this,"更新",Toast.LENGTH_LONG).show();
                    break;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView); //使用的activity_main
        listView.setAdapter(new MyAdapter());
        save = (EditText) findViewById(R.id.save);
        menu = (ImageView) findViewById(R.id.menu);


        car = (ImageView) findViewById(R.id.car);
        car.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("key","由主页跳转到购物车");
                startActivityForResult(intent,200);
            }
        });

        menu.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });



        SharedPreferences sp = getSharedPreferences("data",0);
        String value = sp.getString("value","nothing");

        if(!"nothing".equals(value)){
            save.setText(value);
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(actionMode != null){
                    return  false;
                }
                actionMode = MainActivity.this.startSupportActionMode(callback);
                return true;
            }
        });


    }

    //程序即将被销毁的时候调用
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String value2 = save.getText().toString().trim();
        boolean bol = false;
        if(!value2.equals("")){
            //保护的数据永久存储下来 使用数据存储方案
            //数据存储到手机的XML中
            SharedPreferences sp = getSharedPreferences("data",0);
            //创建到手机中
            //查看这个文件 虚拟机可以 真机不可以（没有root）
            //得到这个文件的编辑权限
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("value",value2);
            bol = editor.commit();
            Toast.makeText(MainActivity.this, "保护的状态="+bol, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "保护的状态="+bol, Toast.LENGTH_SHORT).show();
        }
    }


        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200 && resultCode == 400){
            String value = data.getStringExtra("key2");
            Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG);
        }
    }

    //提供数据
    public List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1;i<=16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("name","数据"+i);
            map.put("price","价格="+i);
            map.put("beizhu","小米手机");
            map.put("rating",i%5);
            list.add(map);
        }
        return list;
    }
    //提供适配器
    //得到控件 == image_text_two.xml
    //把数据放到控件中
    //把效果适配到listView

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getList().size();
        }
        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view; //代表的是一个布局文件 文件  可以通过findViewById获取view中的控件
            if(convertView == null){
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.image_text,null);
            }else{
                view = convertView;
            }

            ImageView imageView = (ImageView) view.findViewById(R.id.photo);
            TextView textView1 = (TextView) view.findViewById(R.id.name);
            TextView textView2 = (TextView) view.findViewById(R.id.price);
            TextView textView3 = (TextView) view.findViewById(R.id.beizhu);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

            imageView.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            textView1.setText(getList().get(position).get("name").toString());
            textView2.setText(getList().get(position).get("price").toString());
            textView3.setText(getList().get(position).get("beizhu").toString());
            ratingBar.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));

            return view;
        }
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
                Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.update :
                Toast.makeText(MainActivity.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete :
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
