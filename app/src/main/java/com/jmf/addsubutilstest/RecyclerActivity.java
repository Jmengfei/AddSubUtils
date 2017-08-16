package com.jmf.addsubutilstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jmf.addsubutilstest.bean.AddSubBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter  adapter ;
    private List<AddSubBean> mList = new ArrayList<>();

    private int[] bookImages = {R.drawable.book_1, R.drawable.book_2, R.drawable.book_3, R.drawable.book_4,
            R.drawable.book_5, R.drawable.book_6, R.drawable.book_7, R.drawable.book_8, R.drawable.book_9
            , R.drawable.book_10, R.drawable.book_11};

    private String[] bookNames = {"Android开发艺术探索", "Android第一行代码", "深入理解Android内核设计思想 第2版",
            "Android 源码设计模式解析与实战", "Android群英传", "Android开发进阶 从小工到专家", "Android系统源代码情景分析(修订版)",
            "疯狂Android讲义", "腾讯Android自动化测试实战", "React Native入门与实战", "看见"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_recycler);
        adapter = new MyRecyclerAdapter(RecyclerActivity.this,mList);
        mRecyclerView.setAdapter(adapter);
        //设置线性布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        mList.add(new AddSubBean(bookNames[0], getBookValue(), bookImages[0]));
        mList.add(new AddSubBean(bookNames[1], getBookValue(), bookImages[1]));
        mList.add(new AddSubBean(bookNames[2], getBookValue(), bookImages[2]));
        mList.add(new AddSubBean(bookNames[3], getBookValue(), bookImages[3]));
        mList.add(new AddSubBean(bookNames[4], getBookValue(), bookImages[4]));
        mList.add(new AddSubBean(bookNames[5], getBookValue(), bookImages[5]));
        mList.add(new AddSubBean(bookNames[6], getBookValue(), bookImages[6]));
        mList.add(new AddSubBean(bookNames[7], getBookValue(), bookImages[7]));
        mList.add(new AddSubBean(bookNames[8], getBookValue(), bookImages[8]));
        mList.add(new AddSubBean(bookNames[9], getBookValue(), bookImages[9]));
        mList.add(new AddSubBean(bookNames[10], getBookValue(), bookImages[10]));
    }

    private int getBookValue() {
        Random random = new Random();
        int bookValue = random.nextInt(10);
        return 1;
    }

}
