package com.example.administrator.mytab;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mytab.adapter.FragmentAdapter;
import com.example.administrator.mytab.modelfragment.ChangeFragment;
import com.example.administrator.mytab.modelfragment.FindFragment;
import com.example.administrator.mytab.modelfragment.FriendsFragment;
import com.example.administrator.mytab.modelfragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.mytab.R.color.selectedColor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , ViewPager.OnPageChangeListener , AdapterView.OnItemSelectedListener{
    private ImageView tabChange,tabFriends,tabFind,tabMe;
    private TextView  textChange,textFriends,textFind,textMe;
    private AppCompatSpinner titleSpinner;
    private ArrayAdapter<String> schoolNameAdapter;

    private  ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList;
    private int offset=0;
    private int currentIndex=0;
    private int leftMagrin=0;
    private int screenWidth=0;
    private int scrren_minute;
    private LinearLayout.LayoutParams lp;
    final int focusColor=Color.rgb(240,101,7);
    final int defaultColor=Color.rgb(255,255,255);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        init();
    }

    private void init() {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth=dm.widthPixels;
        tabChange= (ImageView) findViewById(R.id.tab_change);
        tabFriends= (ImageView) findViewById(R.id.tab_friends);
        tabFind= (ImageView) findViewById(R.id.tab_find);
        tabMe= (ImageView) findViewById(R.id.tab_me);
        textChange= (TextView) findViewById(R.id.text_change);
        textFriends= (TextView) findViewById(R.id.text_friends);
        textFind= (TextView) findViewById(R.id.text_find);
        textMe= (TextView) findViewById(R.id.text_me);
        titleSpinner= (AppCompatSpinner) findViewById(R.id.my_title_spinner);
        tabChange.setOnClickListener(this);
        tabFind.setOnClickListener(this);
        tabFriends.setOnClickListener(this);
        tabMe.setOnClickListener(this);
        titleSpinner.setOnItemSelectedListener(this);
        //初始化spinner
        initSpinner();
        //初始化Viewpager
        initViewPager();
    }

    private void initSpinner() {
        //获取学校名称数据(网络获取)
      List<String> schoolnames=  initCollegeData();
        schoolNameAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,schoolnames);
        titleSpinner.setAdapter(schoolNameAdapter);

    }

    private List<String> initCollegeData() {
       List<String> schoolnames=new ArrayList<>();
//        {,"广东水利电力职业技术学院","惠州学院","闽南职业技术学院","河源技术学院","暨南大学(潮州师范分院)","韩山师范学院"};
        schoolnames.add("武汉长江大学");
        schoolnames.add("惠州学院");
        schoolnames.add("闽南职业技术学院");
        schoolnames.add("河源技术学院");
        schoolnames.add("暨南大学(潮州师范分院)");
        schoolnames.add("韩山师范学院");
        schoolnames.add("武汉长江大学");
        schoolnames.add("惠州学院");
        schoolnames.add("闽南职业技术学院");
        schoolnames.add("河源技术学院");
        schoolnames.add("暨南大学(潮州师范分院)");
        schoolnames.add("韩山师范学院");
        schoolnames.add("武汉长江大学");
        schoolnames.add("惠州学院");
        schoolnames.add("闽南职业技术学院");
        schoolnames.add("河源技术学院");
        schoolnames.add("暨南大学(潮州师范分院)");
        schoolnames.add("韩山师范学院");
        schoolnames.add("武汉长江大学");
        schoolnames.add("惠州学院");
        schoolnames.add("闽南职业技术学院");
        schoolnames.add("河源技术学院");
        schoolnames.add("暨南大学(潮州师范分院)");
        schoolnames.add("韩山师范学院");
        schoolnames.add("武汉长江大学");
        schoolnames.add("惠州学院");
        schoolnames.add("闽南职业技术学院");
        schoolnames.add("河源技术学院");
        schoolnames.add("暨南大学(潮州师范分院)");
        schoolnames.add("韩山师范学院");
        return schoolnames;
    }
    //设置布局等信息包括碎片以及适配器
    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.myViewpager);
        fragmentArrayList=new ArrayList<>();
        Fragment fragment = new ChangeFragment();
        fragmentArrayList.add(fragment);
        fragment=new FriendsFragment();
        fragmentArrayList.add(fragment);
        fragment=new FindFragment();
        fragmentArrayList.add(fragment);
        fragment=new MeFragment();
        fragmentArrayList.add(fragment);
        FragmentAdapter pageAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentArrayList);
        viewPager.setAdapter(pageAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        getTabcurrentFocus(id,focusColor,defaultColor);
    }

    private void getTabcurrentFocus(int id, int focusColor, int defaultColor) {
        switch (id){
            case R.id.tab_change:
                tabChange.setImageResource(R.drawable.tab_change_selected);
                textChange.setTextColor(focusColor);

                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_friends:
                tabFriends.setImageResource(R.drawable.tab_friends_selected);
                textFriends.setTextColor(focusColor);

                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_find:
                tabFind.setImageResource(R.drawable.tab_find_selected);
                textFind.setTextColor(focusColor);

                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_me:
                tabMe.setImageResource(R.drawable.tab_me_selected);
                textMe.setTextColor(focusColor);


                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
         getPagerFocus(position,focusColor,defaultColor);
         currentIndex=position;
    }

    private void getPagerFocus(int position,int focusColor,int defaultColor) {
        switch (position){
            case 0:
                tabChange.setImageResource(R.drawable.tab_change_selected);
                textChange.setTextColor(focusColor);

                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                break;
            case 1:
                tabFriends.setImageResource(R.drawable.tab_friends_selected);
                textFriends.setTextColor(focusColor);

                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                break;
            case 2:
                tabFind.setImageResource(R.drawable.tab_find_selected);
                textFind.setTextColor(focusColor);

                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                tabMe.setImageResource(R.drawable.tab_me);
                textMe.setTextColor(defaultColor);
                break;
            case 3:
                tabMe.setImageResource(R.drawable.tab_me_selected);
                textMe.setTextColor(focusColor);


                tabChange.setImageResource(R.drawable.tab_change);
                textChange.setTextColor(defaultColor);
                tabFind.setImageResource(R.drawable.tab_find);
                textFind.setTextColor(defaultColor);
                tabFriends.setImageResource(R.drawable.tab_friends);
                textFriends.setTextColor(defaultColor);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
