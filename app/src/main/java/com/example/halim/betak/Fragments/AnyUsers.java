package com.example.halim.betak.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.halim.betak.Fabs.InsertUnit;
import com.example.halim.betak.Intro.LoginActivity;
import com.example.halim.betak.R;
import com.example.halim.betak.Fabs.SearchUnit;

public class AnyUsers extends ActionBarActivity{
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_any_users);




        Fragment f1 = new HomeUser();
        Fragment f2 = new InterestedUser();
        Fragment f3 = new MessageUser();
        Fragment [] fragments = {f1,f2,f3};

        TabsAdapterUser tabsAdapterUser = new TabsAdapterUser(getSupportFragmentManager(),fragments);
        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(tabsAdapterUser);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }
        };
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Interested").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Message").setTabListener(tabListener));


        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        /*FloatingActionButton InsertButton = (FloatingActionButton) findViewById(R.id.fab_insert);
        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(AnyUsers.this,InsertUnit.class);
                startActivity(i);

            }
        });*/



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Refresh:
                // Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();

                return true;
            case R.id.SignOut:
                //Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                Intent i = new Intent(AnyUsers.this,LoginActivity.class);
                startActivity(i);
                return true;
            case R.id.Setting:
                //Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Insert(View view){
        Intent i;
        i = new Intent(AnyUsers.this,InsertUnit.class);
        startActivity(i);

    }
    public void Search(View view){
        Intent ii;
        ii = new Intent(AnyUsers.this,SearchUnit.class);
        startActivity(ii);

    }
}
