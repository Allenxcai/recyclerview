package com.imooc.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.imooc.recyclerview.adapter.ChatAdapter;
import com.imooc.recyclerview.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatGridActivity extends Activity implements View.OnClickListener{
    private List list;
    private List<Chat> resList=new ArrayList<Chat>();
    private Button send_btn,rece_btn,delete;
    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView=findViewById(R.id.recycleView);
        send_btn=findViewById(R.id.sendBtn);
        rece_btn=findViewById(R.id.receBtn);
        delete=findViewById(R.id.delete);
        send_btn.setOnClickListener(this);
        rece_btn.setOnClickListener(this);
        delete.setOnClickListener(this);
        //设置layoutManager
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
       //设置数据源
        initData();
        adapter=new ChatAdapter(this,resList);
        recyclerView.setAdapter(adapter);
        /**
         * 设置RecyclerView item动画
         */
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        for(int i=0;i<6;i++){
            Chat chat=new Chat();
            chat.setType(0);
            chat.setContent("发送方：你好");
            resList.add(chat);
            Chat chat2=new Chat();
            chat2.setType(1);
            chat2.setContent("接收方：你好!");
            resList.add(chat2);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendBtn:
            {
                Chat chat = new Chat();
                chat.setContent("插入：发送");
                chat.setType(0);
                resList.add(1, chat);
                adapter.notifyItemInserted(1);
                break;
            }
            case R.id.receBtn:
            {
                Chat chat = new Chat();
                chat.setContent("插入：接收");
                chat.setType(1);
                resList.add(1, chat);
                adapter.notifyItemInserted(1);
                break;
            }
            case R.id.delete:
            {
                resList.remove(resList.size()-2);
                adapter.notifyItemRemoved(resList.size()-2);
                break;
            }
        }
    }
}
