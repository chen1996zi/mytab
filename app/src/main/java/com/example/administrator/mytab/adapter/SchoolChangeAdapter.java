package com.example.administrator.mytab.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mytab.ChangeNewsActivity;
import com.example.administrator.mytab.MyApplication;
import com.example.administrator.mytab.R;
import com.example.administrator.mytab.bean.ChangeNews;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public class SchoolChangeAdapter extends RecyclerView.Adapter<SchoolChangeAdapter.ViewHolder>{
    private List<ChangeNews> schoolChangeNews;
    private int newsID;
    public void setNewsID(int id){
        this.newsID=id;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View newsViews;
        ImageView newsImg1,newsImg2,newsImg3;
        TextView newsTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            newsViews=itemView;
            newsImg1= (ImageView) itemView.findViewById(R.id.change_img_1);
            newsImg2= (ImageView) itemView.findViewById(R.id.change_img_2);
            newsImg3= (ImageView) itemView.findViewById(R.id.change_img_3);
            newsTitle= (TextView) itemView.findViewById(R.id.change_title_text);
        }
    }

    public SchoolChangeAdapter(List<ChangeNews> changeNews){
        schoolChangeNews=changeNews;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.change_item,parent,false);
        final ViewHolder holder= new ViewHolder(view);
        holder.newsViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String title=   holder.newsTitle.getText().toString();
            int id= getNewsID();
                Intent intent= new Intent();
                intent.setAction("changenews.intent.action.NewsDetialActivity");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putInt("NewsID",id);
                bundle.putString("NewsTitle",title);
                intent.putExtras(bundle);
                MyApplication.getContext().startActivity(intent);
            }
        });
        LinearLayout itemLayout= (LinearLayout) view.findViewById(R.id.item_layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChangeNews news=schoolChangeNews.get(position);
        holder.newsTitle.setText(news.getNewsTitle());
        holder.newsImg1.setImageResource(news.getNewsImg1());
        holder.newsImg2.setImageResource(news.getNewsImg2());
        holder.newsImg3.setImageResource(news.getNewsImg3());
        setNewsID(news.getId());
    }

    @Override
    public int getItemCount() {
        return schoolChangeNews.size();
    }
    public int getNewsID(){
        return this.newsID;
    }
}
