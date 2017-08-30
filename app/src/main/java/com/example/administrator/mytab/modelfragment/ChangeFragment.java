package com.example.administrator.mytab.modelfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.administrator.mytab.R;
import com.example.administrator.mytab.change.fragment.FriendsChageFragment;
import com.example.administrator.mytab.change.fragment.MassChageFragment;
import com.example.administrator.mytab.change.fragment.SchoolChageFragment;

/**
 * Created by Administrator on 2017/7/19.
 */
public class ChangeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout schoolChangeTab,massChangeTab,friendsChangeTab;
    private int index=1;
    private FragmentManager fragmentManager;
    private  Fragment schoolChangeFragment,massChangeFragment,friendsChangeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.from(getContext()).inflate(R.layout.change_fragment,null);
        fragmentManager=getActivity().getSupportFragmentManager();
//        school_changeSpinner= (Spinner) view.findViewById(R.id.change_school_spinner);
//        mass_changeSpinner= (Spinner) view.findViewById(R.id.change_mass_spinner);
//        fritends_changeSpinner= (Spinner) view.findViewById(R.id.change_friends_spinner);
//        school_changeSpinner.setOnItemSelectedListener(this);
//        fritends_changeSpinner.setOnItemSelectedListener(this);
//        mass_changeSpinner.setOnItemSelectedListener(this);
      //  initSpinnerContent();
        init(view);
        return view;
    }

    private void init(View view) {
        schoolChangeTab= (LinearLayout) view.findViewById(R.id.school_change_layout);
        massChangeTab= (LinearLayout) view.findViewById(R.id.mass_change_layout);
        friendsChangeTab= (LinearLayout) view.findViewById(R.id.friends_change_layout);
        schoolChangeTab.setOnClickListener(this);
        massChangeTab.setOnClickListener(this);
        friendsChangeTab.setOnClickListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        schoolChangeFragment = new SchoolChageFragment();
        transaction.replace(R.id.content_layout,schoolChangeFragment);
        transaction.commit();
    }

    private void replaceFragment(Fragment newFragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(!newFragment.isAdded()){
            transaction.replace(R.id.content_layout,newFragment);
            transaction.commit();
        }else{
            transaction.show(newFragment);
        }
    }

    private void clearStatus(){
        if(index==1){
            schoolChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabBackground));
        }else if(index==2){
            massChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabBackground));
        }else if(index==3){
            friendsChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabBackground));
        }
    }



    @Override
    public void onClick(View v) {
        clearStatus();
        switch (v.getId()){
            case R.id.school_change_layout:
                if(schoolChangeFragment==null){
                    schoolChangeFragment=new SchoolChageFragment();
                }
                replaceFragment(schoolChangeFragment);
                schoolChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabselected));
                index=1;
                break;
            case R.id.mass_change_layout:
                if(massChangeFragment==null){
                    massChangeFragment=new MassChageFragment();
                }
                replaceFragment(massChangeFragment);
                massChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabselected));
                index=2;
                break;
            case R.id.friends_change_layout:
                if(friendsChangeFragment==null){
                    friendsChangeFragment=new FriendsChageFragment();
                }
                replaceFragment(friendsChangeFragment);
                friendsChangeTab.setBackgroundColor(getResources().getColor(R.color.colorTabselected));
                index=3;
                break;
        }
    }
}
