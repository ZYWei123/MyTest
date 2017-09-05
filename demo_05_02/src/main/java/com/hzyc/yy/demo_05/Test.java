package com.hzyc.yy.demo_05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-08-19.
 */
public class Test {

    //原型模式
    public Test(){
        //初始化数据
    }

    //单例模式
    static  {
        //初始化数据
    }

    public void method(){

        //获取系统时间
        Date date = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd hh-mm-ss");
        String sj1 = sp.format(date);

        String sj2 = new SimpleDateFormat("YYYY-MM-dd hh-mm-ss").format(new Date());

        //初始化数据
        Test test1 = new Test();
        Test test2 = new Test();
        Test test3 = new Test();
        Test test4 = new Test();
        Test test5 = new Test();


    }
}
