package com.hzyc.yy.demo_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView); //使用的activity_main
        listView.setAdapter(new MyAdapter());
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

    class MyAdapter extends BaseAdapter{

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
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.image_text_two,null);
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
}
