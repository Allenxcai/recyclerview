package com.imooc.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.imooc.recyclerview.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MainViewHolder>{
    private List<String> list;//要显示的数据
    private Context context;//创建视图时需要


    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //创建视图
       View view = LayoutInflater.from(context).inflate(R.layout.simple_item,parent,false);
       //实例化MainViewHolder----传View过去
        MainViewHolder holder=new MainViewHolder(view);
        return holder;
    }
    /**
    * 初始化控件
    */
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MainViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
    /**
     * 填充数据
     */
    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        String url=list.get(position);
        Glide.with(context).load(url).into(holder.imageView);
    }

    /**
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return list.size();
    }


}
