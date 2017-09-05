package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    //actionMode菜单
    private ActionMode actionMode;

    //实现内部类
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
                case  R.id.save :
                    Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case  R.id.update :
                    Toast.makeText(MainActivity.this, "更新", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case  R.id.delete :
                    Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
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

        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(arrayAdapter);
        //actionMode模式  上下文一种（升级模式）
        //registerForContextMenu(listView);

        //也需要注册
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //注册显示actionMode
                if(actionMode != null){
                    return false;
                }
                actionMode = MainActivity.this.startActionMode(callback);
                return true;
            }
        });
    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("黑龙江省");
        list.add("吉林省");
        list.add("辽宁省");

        return list;
    }

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_one,menu);
    }*/
}
