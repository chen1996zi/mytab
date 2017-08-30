package com.example.administrator.mytab.change.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.mytab.R;
import com.example.administrator.mytab.adapter.SchoolChangeAdapter;
import com.example.administrator.mytab.bean.ChangeNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public class SchoolChageFragment extends Fragment {
    private Spinner school_changeSpinner;
    private RecyclerView newsRecyclerView;
    private int NewsType;
    private List<ChangeNews> changeNews=new ArrayList<>();
    private RecyclerView schoolChangeRecyclerview;
    private SchoolChangeAdapter schoolChangeadpter;
    final  String[] schoolChanges={"全部","求助","交易","招新"};
    final int All_TYPE=1;
    final int HELP_TYPE=2;
    final int SALE_TYPE=3;
    final int ENROLL_TYPE=4;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_school,null);
        school_changeSpinner= (Spinner) view.findViewById(R.id.change_school_spinner);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,schoolChanges);
        school_changeSpinner.setAdapter(adapter);
        newsRecyclerView= (RecyclerView) view.findViewById(R.id.recycler_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        newsRecyclerView.setLayoutManager(layoutManager);
        school_changeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        NewsType=All_TYPE;
                        break;
                    case 1:
                       NewsType=HELP_TYPE;
                        break;
                    case 2:
                        NewsType=SALE_TYPE;
                        break;
                    case 3:
                        NewsType=ENROLL_TYPE;
                        break;

                }
                changeNews=initChangeNews(NewsType);
                schoolChangeadpter=new SchoolChangeAdapter(changeNews);
                newsRecyclerView.setAdapter(schoolChangeadpter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private List<ChangeNews> initChangeNews(int type) {
        //消息获取从后台此次模拟数据
       List<ChangeNews> changeNewsList =new ArrayList<>();

        switch (type){
            case All_TYPE:
                for(int i=0;i<10;i++){
                    ChangeNews news=new ChangeNews(1,"所有资讯",R.drawable.animal3,R.drawable.star_2,R.drawable.star_5);
                    changeNewsList.add(news);
                }
                break;
            case HELP_TYPE:
                for(int i=0;i<10;i++){
                    ChangeNews news=new ChangeNews(2,"求助资讯",R.drawable.animal2,R.drawable.star_1,R.drawable.star_12);
                    changeNewsList.add(news);
                }
                break;
            case SALE_TYPE:
                for(int i=0;i<10;i++){
                    ChangeNews news=new ChangeNews(3,"交易资讯",R.drawable.animal2,R.drawable.star_5,R.drawable.star_2);
                    changeNewsList.add(news);
                }
                break;
            case ENROLL_TYPE:
                for(int i=0;i<10;i++){
                    ChangeNews news=new ChangeNews(4,"招新资讯",R.drawable.animal10,R.drawable.star_7,R.drawable.star_2);
                    changeNewsList.add(news);
                }
                break;
        }
        return  changeNewsList;
    }


}
