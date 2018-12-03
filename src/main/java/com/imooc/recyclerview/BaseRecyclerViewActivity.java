package com.imooc.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imooc.recyclerview.adapter.MyAdapter;
import com.imooc.recyclerview.model.ImageData;
import com.imooc.recyclerview.utils.JsonUtil;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseRecyclerViewActivity extends Activity {
    private List resList=new ArrayList(  );
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycle);
        //初始化
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycleView);
       //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        //请求数据源
        requestData();
        //设置适配器
        adapter=new MyAdapter(this,resList);
        recyclerView.setAdapter(adapter);
    }

    private void requestData() {
        OkHttpClient mOkHttpClient=new OkHttpClient();
        Request.Builder requestBuilder=new Request.Builder().url("http://www.imooc.com/api/teacher?type=2&page=1");
        Request request =requestBuilder.build();
        Call mcall=mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res=response.body().string();
                ImageData imageData=(ImageData) JsonUtil.fromJson(res,ImageData.class);
                List<ImageData.DataBean> data=imageData.getData();
                for(int i=0;i<data.size();i++){
                    ImageData.DataBean dataBean=data.get(i);
                    String picBig=dataBean.getPicSmall();
                    resList.add(picBig);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
