package com.hzyc.wzy.test04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private ImageView shouye;
    private ImageView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView); //使用的activity_main
        listView.setAdapter(new MyAdapter());

        menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        shouye = (ImageView) findViewById(R.id.shouye);
        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra("key2","从购物车回到首页");
                setResult(400,intent1);
                finish();
            }
        });

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        Toast.makeText(Main2Activity.this,value,Toast.LENGTH_LONG).show();

        registerForContextMenu(listView);
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
                view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.image_text,null);
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
                Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.update :
                Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete :
                Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
