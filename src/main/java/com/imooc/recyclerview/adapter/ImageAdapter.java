package com.imooc.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.imooc.recyclerview.R;

import java.util.List;
import java.util.Random;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MainViewHolder>{

    private Context context;//创建视图时需要
    private List<Integer> resList;//要显示的数据

    public ImageAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.resList = list;
    }

    /**
     * 创建视图
     */
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //创建视图
       View view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
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
        holder.imageView.setBackgroundResource(resList.get(position));
        //实例化Random对象
        Random random=new Random();
        int height=random.nextInt(1000);
        holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height));

    }

    /**
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return resList.size();
    }


}
