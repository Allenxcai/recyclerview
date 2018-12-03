package com.imooc.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.imooc.recyclerview.adapter.ImageAdapter;
import com.imooc.recyclerview.adapter.ImageClickAdapter;
import com.imooc.recyclerview.adapter.SplitAdapter;
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

public class ClickGridActivity extends Activity {
    private List list;
    private List<String>resList=new ArrayList();
    private ImageClickAdapter imageClickAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //设置layoutManager
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //设置数据源
        requestData();
        imageClickAdapter=new ImageClickAdapter(this,resList);
        recyclerView.setAdapter(imageClickAdapter);
        //设置间距
        imageClickAdapter.setOnItemClickListener(new ImageClickAdapter.OnItemClickListener(){

            @Override
            public void OnItemClickListener(int itemPosition) {
                Toast.makeText(ClickGridActivity.this,"点击="+itemPosition,Toast.LENGTH_LONG).show();
            }
        });
        imageClickAdapter.setOnItemLongClickListener(new ImageClickAdapter.OnItemLongClickListener(){

            @Override
            public void OnItemLongClickListener(int itemPosition) {
                Toast.makeText(ClickGridActivity.this,"长按="+itemPosition,Toast.LENGTH_LONG).show();
            }
        });

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
                imageClickAdapter.notifyDataSetChanged();
            }
        });
    }
}
