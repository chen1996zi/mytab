package com.example.administrator.mytab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mytab.R;
import com.example.administrator.mytab.bean.UserMessage;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/7/23.
 */
public class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.ViewHolder> {
    private List<UserMessage> messageList;
    private Context mContext;
    public AdviceAdapter(List<UserMessage> messgeList){
        this.messageList=messgeList;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImage;
        TextView textUser,textAdvice;
        public ViewHolder(View itemView) {
            super(itemView);
            circleImage= (CircleImageView) itemView.findViewById(R.id.circleImage);
            textUser= (TextView) itemView.findViewById(R.id.username);
            textAdvice= (TextView) itemView.findViewById(R.id.user_advice);

        }
    }
    @Override
    public AdviceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advice_list_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        mContext=parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(AdviceAdapter.ViewHolder holder, int position) {
        UserMessage message=messageList.get(position);
        Glide.with(mContext).load(message.getImage()).into(holder.circleImage);
        holder.textUser.setText(message.getUsername());
        holder.textAdvice.setText(message.getUerAdvice());

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
