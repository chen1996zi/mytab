package com.example.administrator.mytab.modelfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mytab.R;

/**
 * Created by Administrator on 2017/7/19.
 */
public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.from(getContext()).inflate(R.layout.me_fragment,null);
        return view;
    }
}
