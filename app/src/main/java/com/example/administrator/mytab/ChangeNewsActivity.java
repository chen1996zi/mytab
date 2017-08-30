package com.example.administrator.mytab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ChangeNewsActivity extends AppCompatActivity {
    private  Toolbar toolbar;
    private DrawerLayout myDrawLayout;
    private NavigationView navView;
    private FloatingActionButton my_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_news);
        toolbar= (Toolbar) findViewById(R.id.newsToolBar);
        myDrawLayout= (DrawerLayout) findViewById(R.id.draw_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        my_fab= (FloatingActionButton) findViewById(R.id.my_fab);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_);
        }
        navView.setCheckedItem(R.id.nav_all);
        Intent intent =getIntent();
        int id = intent.getExtras().getInt("NewID");
        String title = intent.getExtras().getString("NewsTitle");
        Toast.makeText(ChangeNewsActivity.this,"id: "+id+", "+title,Toast.LENGTH_LONG).show();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                myDrawLayout.closeDrawers();
                return true;
            }
        });
        my_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"wifi连接错误,是否切换至移动网络",Snackbar.LENGTH_LONG).setAction("确认切换",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ChangeNewsActivity.this,"已切换",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                myDrawLayout.openDrawer(GravityCompat.START);
            break;
            default:break;
        }
        return true;
    }
}
