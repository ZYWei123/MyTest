package com.hzyc.yy.demo_05;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {

    private Button openOne,openTwo,openThree,openFour;
    private String [] data = {"长春","吉林","四平"};

    private DialogInterface.OnClickListener di = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1:
                    Toast.makeText(Main3Activity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(Main3Activity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(Main3Activity.this, "一般"+which, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        openOne = (Button) findViewById(R.id.openOne);
        openTwo = (Button) findViewById(R.id.openTwo);
        openThree = (Button) findViewById(R.id.openThree);
        openFour = (Button) findViewById(R.id.openFour);

        openOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设计模式
                //Java的设计模式  建造者模式  对象.方法.方法.方法.方法
                //java的适配器模式
                //单例模式
                //原型模式
                //工厂模式
                //23种设计模式（比较重要的模式  学习一遍）
                //修改显示效果  1.修改主题  style
                //2.修改代码 在控件显示之后 用代码控制效果
              /*  AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this,R.style.MyCommonDialog);
                builder.setTitle("问卷调查")
                        .setIcon(R.drawable.image1)
                        .setMessage("您喜欢看NBA吗?")
                        .setPositiveButton("不喜欢", di)
                        .setNegativeButton("喜欢", di)
                        .setNeutralButton("一般", di)
                        .show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setTitle("问卷调查")
                        .setIcon(R.drawable.image1)
                        .setMessage("您喜欢看NBA吗?")
                        .setPositiveButton("不喜欢", di)
                        .setNegativeButton("喜欢", di)
                        .setNeutralButton("一般", di);

                AlertDialog dialog = builder.create();
                dialog.show();
                //2.修改代码 在控件显示之后 用代码控制效果
                Window dialogWindow = dialog.getWindow();
                WindowManager m = dialogWindow.getWindowManager();
                Display d = m.getDefaultDisplay();//获取屏幕宽和高
                WindowManager.LayoutParams layout = dialogWindow.getAttributes();//获得dialog属性
                layout.width = (int) (d.getWidth() * 0.6);
                layout.height = (int) (d.getHeight() * 0.4);
                layout.alpha = 0.5f;
                layout.gravity = Gravity.BOTTOM;
                dialogWindow.setAttributes(layout);


                //3重绘制  == 使用特殊的工具类（原声控件不好看  我自己重新画一个）
            }
        });

        openTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                /*builder.setTitle("你喜欢哪个城市")
                        .setIcon(R.drawable.image1)
                        .setItems(data, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main3Activity.this, ""+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/

             /*   builder.setTitle("你喜欢哪个城市")
                        .setIcon(R.drawable.image1)
                        .setView(R.layout.activity_main2)
                        .show();*/

               /* builder.setTitle("你喜欢哪个城市")
                        .setIcon(R.drawable.image1)
                       .setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(Main3Activity.this, ""+which, Toast.LENGTH_SHORT).show();
                           }
                       })
                        .show();*/

                builder.setTitle("你喜欢哪个城市")
                        .setIcon(R.drawable.image1)
                        .setMultiChoiceItems(data, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(Main3Activity.this, ""+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        openThree.setOnClickListener(new View.OnClickListener() {

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

        openFour.setOnClickListener(new View.OnClickListener() {
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
