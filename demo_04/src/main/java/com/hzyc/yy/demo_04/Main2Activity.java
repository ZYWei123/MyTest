package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        spinner = (Spinner) findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,getList());
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object value = spinner.getSelectedItem();
                Toast.makeText(Main2Activity.this, ""+value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       /* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

       /* toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toggleButton.getTextOn()
            }
        });*/
    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("黑龙江省");
        list.add("吉林省");
        list.add("辽宁省");

        return list;
    }

    public void check(View view){

        //复选框 选中状态
        boolean bol = ((CheckBox)view).isChecked();
        int id = view.getId();
        switch (id){
            case R.id.lq :
                if(bol){
                    Toast.makeText(Main2Activity.this, "爱好是篮球", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zq :
                if(bol){
                    Toast.makeText(Main2Activity.this, "爱好是篮球", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pq :
                if(bol){
                    Toast.makeText(Main2Activity.this, "爱好是篮球", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ppq :
                if(bol){
                    Toast.makeText(Main2Activity.this, "爱好是篮球", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
