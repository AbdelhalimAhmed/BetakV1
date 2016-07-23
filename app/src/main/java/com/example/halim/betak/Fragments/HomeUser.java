package com.example.halim.betak.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.halim.betak.Views.AddView;
import com.example.halim.betak.Views.GridAdapter;
import com.example.halim.betak.Intro.MainActivity;
import com.example.halim.betak.R;


public class HomeUser extends Fragment {

    //private GridView mGridView;
    //private GridAdapter mGridAdapter;
    //GridItems[]gridItems = {};
    //private Activity activity;

    public Integer[] mThumbIds= {
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,
            R.drawable.sample1,


    };



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Refresh:
               // Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);
                return true;
            case R.id.SignOut:
                //Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Setting:
                //Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_user,container,false);


        GridView gridView = (GridView) v.findViewById(R.id.gridview);
        gridView.setAdapter(new GridAdapter(getActivity(),mThumbIds));
        //mGridView = (GridView) v.findViewById(R.id.grid_view);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),AddView.class);
                intent.putExtra(Intent.EXTRA_TEXT,mThumbIds[position]);
                startActivity(intent);
            }
        });

        return v;
    }

   // @Override
   /* public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(activity != null){
            mGridAdapter = new GridAdapter(activity, gridItems);
            if(mGridView != null){
                mGridView.setAdapter(mGridAdapter);

            }
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onGridItemClick((GridView)parent, view, position, id);
                }
            });
        }
    }
    public void onGridItemClick(GridView g, View view, int position, long id ){
        Toast.makeText(activity, "Position Clicked: " + position + "& Text is : " + gridItems[position].title, Toast.LENGTH_LONG).show();
    }*/
}
