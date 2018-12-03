package com.imooc.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
        button6= (Button) findViewById(R.id.button6);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.button1:
                intent=new Intent(this,BaseRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent=new Intent(this,StaggeredGridActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent=new Intent(this,SplitLineRecyActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent=new Intent(this,ChatGridActivity.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent=new Intent(this,ClickGridActivity.class);
                startActivity(intent);
                break;
            case R.id.button6:
                intent=new Intent(this,RefeshRecycleActivity.class);
                startActivity(intent);
                break;

        }
    }
}
