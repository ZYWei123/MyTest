package com.hzyc.wzy.test04;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.PopupMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static com.hzyc.wzy.test04.R.id.open4;

public class Main3Activity extends AppCompatActivity {
    private Button open;
    private Button open2;
    private Button open3;
    private Button open4;
    private Button open5;
    private Button open6;

    private DialogInterface.OnClickListener di = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1:
                    Toast.makeText(Main3Activity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(Main3Activity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        open = (Button) findViewById(R.id.open);
        open2 = (Button) findViewById(R.id.open2);
        open3 = (Button) findViewById(R.id.open3);
        open4 = (Button) findViewById(R.id.open4);
        open5 = (Button) findViewById(R.id.open5);
        open6 = (Button) findViewById(R.id.open6);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Main3Activity.this,v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_one,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.save:
                                Toast.makeText(Main3Activity.this,"保存",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.delete:
                                Toast.makeText(Main3Activity.this,"删除",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.update:
                                Toast.makeText(Main3Activity.this,"更新",Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        open2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setTitle("问卷调查")
                        .setIcon(R.drawable.image1)
                        .setPositiveButton("Y",di)
                        .setNegativeButton("N",di)
                        .show();

            }
        });
        open3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this,R.style.MyCommonDialog);
                builder.setTitle("问卷调查")
                        .setIcon(R.drawable.image1)
                        .setPositiveButton("Y",di)
                        .setNegativeButton("N",di)
                        .show();

            }
        });
        open4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setTitle("问卷调查")
                        .setIcon(R.drawable.image1)
                        .setPositiveButton("Y",di)
                        .setNegativeButton("N",di);

                AlertDialog dialog = builder.create();
                dialog.show();
                Window dialogWindow = dialog.getWindow();
                WindowManager m = dialogWindow.getWindowManager();
                Display d = m.getDefaultDisplay();//获取屏幕宽和高
                WindowManager.LayoutParams layout = dialogWindow.getAttributes();//获得dialog属性
                layout.width = (int) (d.getWidth() * 0.6);
                layout.height = (int) (d.getHeight() * 0.4);
                layout.alpha = 0.5f;
                layout.gravity = Gravity.BOTTOM;
                dialogWindow.setAttributes(layout);
            }


        });
        open5.setOnClickListener(new View.OnClickListener() {

            //Java时间操作  时间的 +-  法
            //SFZ 8-19号 丢失sfz  挂失  打印临时身份证  1个月   8-19 之后的一个月 是几号
            //日历类
            //Calendar aa = Calendar.getInstance();
            // aa.add("8-19","30")
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(Main3Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String sj = year + "-" +monthOfYear+1+ "-" + dayOfMonth;
                        Toast.makeText(Main3Activity.this, sj, Toast.LENGTH_SHORT).show();
                    }
                },year,month,day);

                dpd.show();
            }
        });

        open6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog time = new TimePickerDialog(Main3Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                },Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                time.show();
            }
        });
    }

}
