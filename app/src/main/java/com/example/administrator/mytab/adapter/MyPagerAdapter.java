package com.example.administrator.mytab.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
public class MyPagerAdapter extends PagerAdapter {
    private  List<View> list;
    public MyPagerAdapter(List<View> list){
        super();
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View child = list.get(position%list.size());
        Log.d("childIndex",position%list.size()+"");
        if(child.getParent()!=null){
            container.removeView(child);
        }
        container.addView(child);
        return  list.get(position%list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%list.size()));
    }
}
