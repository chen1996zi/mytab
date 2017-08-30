package com.example.administrator.mytab.change.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.administrator.mytab.R;

/**
 * Created by Administrator on 2017/7/21.
 */
public class MassChageFragment extends Fragment {
    private Spinner mass_changeSpinner;
    final  String[] massChange={"社团动态","社团最新动态1","社团最新动态2"};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_mass,null);
        mass_changeSpinner= (Spinner) view.findViewById(R.id.change_mass_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,massChange);
        mass_changeSpinner.setAdapter(adapter);
        return view;
    }
}
