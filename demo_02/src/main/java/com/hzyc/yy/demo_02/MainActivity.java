package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    //TextView
    //添加控件两种办法
    //1.xml直接绘制  有一些控件不能直接使用
    //2.可以在activity类中  通过代码去绘制XML
    //页面根控件 ID  找到这个根控件 可以把自己new控件的添加进去 才会显示
    //缺点 布局效果无法掌控  控件在哪不一定 查看效果必须运行程序
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.rl1);

        Button button = new Button(MainActivity.this);
        //赋属性

        button.setText("按钮");
        button.setTextSize(30);

        //单例模式
      /*  button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        //button.setOnClickListener(this);

        relativeLayout.addView(button);


    }

    //@Override
   /* public void onClick(View v) {
        //事件的公共函数
    }*/


    public void check(View view){

    }
}
