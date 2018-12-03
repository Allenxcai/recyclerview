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
import com.imooc.recyclerview.model.Chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter  {
    /**
     * 填充数据
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       Chat chat=list.get(position);
        String content=chat.getContent();
        /**
         * 发送方
         */
        if(chat.getType()==0){
            SendViewHolder sendViewHolder=(SendViewHolder)holder;
            sendViewHolder.tvSend.setText(content);
        }
        /**
         * 接收方
         */
        else{
            ReceiveViewHolder receiveViewHolder=(ReceiveViewHolder)holder;
            receiveViewHolder.tvReceive.setText(content);
        }
    }

    /**
     * 创建发送方的ViewHolder
     */
    public class  SendViewHolder extends RecyclerView.ViewHolder{
        TextView  tvSend;
        public SendViewHolder(View itemView) {
            super(itemView);
            /**
             * 初始化控件
             */
            tvSend=itemView.findViewById(R.id.tv_show);
        }
    }
    /**
     * 创建接收方的ViewHolder
     */
    public class  ReceiveViewHolder extends RecyclerView.ViewHolder{
        TextView  tvReceive;
        public ReceiveViewHolder(View itemView) {
            super(itemView);
            /**
            * 初始化控件
             */
            tvReceive=itemView.findViewById(R.id.tv_show);
        }
    }
    private List<Chat> list;//要显示的数据
    private Context context;//创建视图时需要


    public ChatAdapter(Context context, List<Chat> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 创建视图
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * 发送方
         */
      if(viewType==0){
            View sendView= LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
            SendViewHolder sendViewHolder=new SendViewHolder(sendView);
            return sendViewHolder;
      }
       /**
        * 接收方
        */
      else{
          View receiveView= LayoutInflater.from(context).inflate(R.layout.main_item2,parent,false);
          ReceiveViewHolder receiveViewHolder =new ReceiveViewHolder(receiveView);
          return receiveViewHolder;
      }
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
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }
}
