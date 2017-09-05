package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    ///排版 ctrl+alt +l
    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;
    /* private int [] data = {R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
             R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
             R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
             R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
             R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
             R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1};
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.listView);

        //简单的文本适配器
        arrayAdapter = new ArrayAdapter<String>(Main3Activity.this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(arrayAdapter);
    }

    public List<String> getList() {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i <= 16; i++) {
            list.add("数据" + i);
        }
        return list;
    }

   /* class MyAdapter extends BaseAdapter {
        //1  需要适配的数据总数
        @Override
        public int getCount() {
            return getList().size();
        }

        //2  position 适配器 自动加的标识从0开始 通用的
        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }

        //3 返回当前节点的ID
        @Override
        public long getItemId(int position) {
            return position;
        }

        //4 适配会根据总数调用这个方法  100个数调用100次
        //每调用一次 适配器都要取出一个数据 创建一个控件   数据放到控件中    控件放到gridview中
        //采用缓存机制   第一次的时候imageView 会new 第二次以后 直接使用原来的
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                //第一次使用这个方法
                //Activity.this == context
                textView = new TextView(Main3Activity.this);
                textView.setPadding(10, 10, 10, 10);
                textView.setTextSize(20);
            } else {
                textView = (TextView) convertView;
            }
            //把数据放到控件中
            textView.setText(getList().get(position));
            return textView;
        }
    }*/
}
