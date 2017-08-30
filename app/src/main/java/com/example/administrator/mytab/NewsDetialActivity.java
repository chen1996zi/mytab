package com.example.administrator.mytab;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.mytab.adapter.AdviceAdapter;
import com.example.administrator.mytab.bean.UserMessage;

import java.util.ArrayList;

public class NewsDetialActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView  adviceRecyclerview;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detial);
        toolbar= (Toolbar) findViewById(R.id.new_detial_toolbar);
        adviceRecyclerview= (RecyclerView) findViewById(R.id.adviceList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adviceRecyclerview.setLayoutManager(layoutManager);
        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<UserMessage> messgeList= getAdvices();
        AdviceAdapter adapter= new AdviceAdapter(messgeList);
        adviceRecyclerview.setAdapter(adapter);
    }

    private ArrayList<UserMessage> getAdvices() {
        ArrayList<UserMessage> usermessgeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserMessage messge=new UserMessage(R.drawable.animal1,"评论用户"+i+1, "你妈炸锅了");
            usermessgeList.add(messge);
        }
        return  usermessgeList;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            break;
        }
        return true;
    }
}
