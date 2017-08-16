package com.jmf.addsubutilstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jmf.addsubutils.AddSubUtils;
import com.jmf.addsubutilstest.bean.AddSubBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewActivity extends AppCompatActivity {
    private ListView mListView;

    private int[] bookImages = {R.drawable.book_1, R.drawable.book_2, R.drawable.book_3, R.drawable.book_4,
            R.drawable.book_5, R.drawable.book_6, R.drawable.book_7, R.drawable.book_8, R.drawable.book_9
            , R.drawable.book_10, R.drawable.book_11};

    private String[] bookNames = {"Android开发艺术探索", "Android第一行代码", "深入理解Android内核设计思想 第2版",
            "Android 源码设计模式解析与实战", "Android群英传", "Android开发进阶 从小工到专家", "Android系统源代码情景分析(修订版)",
            "疯狂Android讲义", "腾讯Android自动化测试实战", "React Native入门与实战", "看见"};

    private List<AddSubBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initData();

        mListView = (ListView) findViewById(R.id.activity_list_view);
        mListView.setAdapter(new MyAdapter());
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

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(ListViewActivity.this, R.layout.listview_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            AddSubBean dataBean = mList.get(position);
            holder.tv_item.setText(dataBean.getName());
            Glide.with(ListViewActivity.this).load(dataBean.getImageId()).into(holder.iv_item);

            holder.list_item_utils
                    .setStep(1)
                    .setBuyMax(30)
                    .setPosition(position)
                    .setCurrentNumber(dataBean.getValue())
                    .setInventory(50)
                    .setOnWarnListener(new AddSubUtils.OnWarnListener() {
                        @Override
                        public void onWarningForInventory(int inventory) {
                            Toast.makeText(ListViewActivity.this, "不能超过当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMax(int max) {
                            Toast.makeText(ListViewActivity.this, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMin(int min) {
                            Toast.makeText(ListViewActivity.this, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnChangeValueListener(new AddSubUtils.OnChangeValueListener() {
                        @Override
                        public void onChangeValue(int value,int position) {
                            setValue(position,value);
                        }
                    });
            return convertView;
        }
    }

    private void setValue(final int position, int inputValue) {
        mList.get(position).setValue(inputValue);
    }

    static class ViewHolder {
        ImageView iv_item;
        AddSubUtils list_item_utils;
        TextView tv_item;

        ViewHolder(View view) {
            iv_item = (ImageView) view.findViewById(R.id.iv_item);
            tv_item = (TextView) view.findViewById(R.id.tv_item);
            list_item_utils = (AddSubUtils) view.findViewById(R.id.list_item_utils);
        }
    }
}
