package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        open = (Button) findViewById(R.id.open);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出菜单比较简单
                PopupMenu popupMenu = new PopupMenu(Main2Activity.this,v);
                //菜单文件
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_one,popupMenu.getMenu());
                //弹出的东西  show
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case  R.id.save :
                                Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                                return true;
                            case  R.id.update :
                                Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                                return true;
                            case  R.id.delete :
                                Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
            }
        });
    }
}
