package com.imooc.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.recyclerview.adapter.SplitAdapter;

import java.util.ArrayList;
import java.util.List;

public class RefeshRecycleActivity extends AppCompatActivity {
    private List<String>list=new ArrayList();
    private SplitAdapter adapter;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //设置layoutManager
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        //设置数据源
        addData();
       //设置Adapter
        adapter=new SplitAdapter(RefeshRecycleActivity.this,list);
        recyclerView.setAdapter(adapter);
        mySwipeRefreshLayout= (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
       // mySwipeRefreshLayout.setColorSchemeResources( android.R.color.holo_blue_bright, android.R.color.holo_green_light,  android.R.color.holo_orange_light, android.R.color.holo_red_light );
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                //刷新动画开始后回调到此方法
                addData();
                adapter.notifyDataSetChanged();
                mySwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void addData() {
        for(int i=0;i<30;i++){
            list.add("慕课网"+i);
        }
    }
}
