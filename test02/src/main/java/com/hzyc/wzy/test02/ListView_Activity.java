package com.hzyc.wzy.test02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListView_Activity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter());
    }

    public List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 0;i<5;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",R.drawable.image1);
            map.put("name","商品"+i);
            map.put("price",i+"元");
            map.put("rating",i);
            map.put("phone","小米");
            list.add(map);
        }
        return list;
    }

    public class MyAdapter extends BaseAdapter{

        List<Map<String,Object>> list;

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
            View view;
            if(convertView == null){
                view = LayoutInflater.from(ListView_Activity.this).inflate(R.layout.image_text,null);
            }else{
                view = convertView;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView price = (TextView) view.findViewById(R.id.price);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            TextView phone = (TextView) view.findViewById(R.id.textView);

            imageView.setImageResource(Integer.parseInt(getList().get(position).get("image").toString()) );
            name.setText( getList().get(position).get("name").toString());
            price.setText(getList().get(position).get("price").toString());
            ratingBar.setRating( Integer.parseInt(getList().get(position).get("rating").toString()));
            phone.setText(getList().get(position).get("phone").toString());
            return view;
        }
    }
}
