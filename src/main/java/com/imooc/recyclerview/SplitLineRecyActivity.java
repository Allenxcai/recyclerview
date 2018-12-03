package com.imooc.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.imooc.recyclerview.adapter.ImageAdapter;
import com.imooc.recyclerview.adapter.SplitAdapter;

import java.util.ArrayList;
import java.util.List;

public class SplitLineRecyActivity extends AppCompatActivity {
    private List list;
    private List<String>resList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //设置layoutManager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置数据源
        initData();
       //设置Adapter
        SplitAdapter splitAdapter=new SplitAdapter(this,resList);
        recyclerView.setAdapter(splitAdapter);

        //设置分割线
        RecycleViewDivider recyclerViewDivider=new RecycleViewDivider(this,LinearLayoutManager.HORIZONTAL,5,127);
        recyclerView.addItemDecoration(recyclerViewDivider);
    }

    private void initData() {
        for(int i=0;i<30;i++){
            resList.add("慕课网"+i);
        }
    }
}
