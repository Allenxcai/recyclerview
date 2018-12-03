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



public class ImageClickAdapter extends RecyclerView.Adapter<ImageClickAdapter.MainViewHolder>{

    private Context context;//创建视图时需要
    private List<String> resList;//要显示的数据

    public ImageClickAdapter(Context context, List<String> list) {
        this.context = context;
        this.resList = list;
    }
    public static OnItemClickListener onItemClickListener;
    public OnItemLongClickListener onItemLongClickListener;

    /**
     * 点击事件的接口
     */
    public interface OnItemClickListener{
        public abstract void OnItemClickListener(int itemPosition);

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    /**
     * 常按事件的接口
     */
    public interface OnItemLongClickListener{
        public abstract void OnItemLongClickListener(int itemPosition);

    }
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
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
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        Glide.with(context).load(resList.get(position)).into(holder.imageView);

        //实例化Random对象
        Random random=new Random();
        int height=random.nextInt(1000);
        holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnItemClickListener(position);
            }
        });
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                onItemLongClickListener.OnItemLongClickListener(position);
                return true;
            }
        });
    }

    /**
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return resList.size();
    }


}
