package com.imooc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.imooc.recyclerview.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridActivity extends AppCompatActivity {
    private List list;
    private List<Integer>resList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //设置layoutManager
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //设置数据源
        initData();
        ImageAdapter imageAdapter=new ImageAdapter(this,resList);
        recyclerView.setAdapter(imageAdapter);
        //设置间距
        SpacesItemDecoration spacesItemDecoration=new SpacesItemDecoration(10);
        recyclerView.addItemDecoration(spacesItemDecoration);
    }

    private void initData() {
        for(int i=0;i<6;i++){
            resList.add(R.drawable.example1);
            resList.add(R.drawable.example2);
            resList.add(R.drawable.example3);
        }
    }
}
