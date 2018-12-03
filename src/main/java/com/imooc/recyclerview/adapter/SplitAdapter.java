package com.imooc.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imooc.recyclerview.R;

import java.util.List;



public class SplitAdapter extends RecyclerView.Adapter<SplitAdapter.MainViewHolder>{
    private List<String> list;//要显示的数据
    private Context context;//创建视图时需要


    public SplitAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //创建视图
       View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
       //实例化MainViewHolder----传View过去
        MainViewHolder holder=new MainViewHolder(view);
        return holder;
    }
    /**
    * 初始化控件
    */
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MainViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(android.R.id.text1);
        }
    }
    /**
     * 填充数据
     */
    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    /**
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return list.size();
    }


}
