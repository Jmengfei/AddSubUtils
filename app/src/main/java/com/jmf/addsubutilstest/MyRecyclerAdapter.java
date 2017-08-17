package com.jmf.addsubutilstest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jmf.addsubutils.AddSubUtils;
import com.jmf.addsubutilstest.bean.AddSubBean;

import java.util.List;

import static com.jmf.addsubutilstest.R.id.recycler_item_utils;
import static com.jmf.addsubutilstest.R.id.recycler_iv_item;

/**
 * Created by 贾梦飞 on 2017/8/14 18:17.
 * QQ:821176301
 * 微信：j821176301
 * desc：
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<AddSubBean> mList;
    private Context mContext ;
    private LayoutInflater inflater;
    public MyRecyclerAdapter(Context context, List<AddSubBean> mList) {
        this.mContext = context;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.initData(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_item;
        AddSubUtils list_item_utils;
        TextView tv_item;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_item = (ImageView)itemView.findViewById(recycler_iv_item);
            tv_item = (TextView) itemView.findViewById(R.id.recycler_tv_item);
            list_item_utils = (AddSubUtils) itemView.findViewById(recycler_item_utils);
        }

        public void initData(int position) {
            tv_item.setText(mList.get(position).getName());
            Glide.with(mContext).load(mList.get(position).getImageId()).into(iv_item);
            list_item_utils.setStep(2)
                    .setPosition(position)
                    .setCurrentNumber(mList.get(position).getValue())
                    .setBuyMax(50)
                    .setInventory(36)
                    .setOnWarnListener(new AddSubUtils.OnWarnListener() {
                        @Override
                        public void onWarningForInventory(int inventory) {
                            Toast.makeText(mContext, "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMax(int max) {
                            Toast.makeText(mContext, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMin(int min) {
                            Toast.makeText(mContext, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnChangeValueListener(new AddSubUtils.OnChangeValueListener() {
                        @Override
                        public void onChangeValue(int value, int position) {
                            setValue(position,value);
                        }
                    });
        }
    }

    private void setValue(int position, int value) {
        mList.get(position).setValue(value);
    }
}
