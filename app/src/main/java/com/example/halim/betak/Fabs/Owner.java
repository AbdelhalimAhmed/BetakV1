package com.example.halim.betak.Fabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.halim.betak.R;
import com.example.halim.betak.Views.CustomOnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Fragment {

    private Spinner spinner1, spinner2, spinner3, spinner4,spinner5;
    private Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_owner,container,false);

        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        spinner3 = (Spinner) v.findViewById(R.id.spinner3);
        spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        spinner4 = (Spinner) v.findViewById(R.id.spinner4);
        spinner5 = (Spinner) v.findViewById(R.id.spinner5);
        addItemsOnSpinner2();
        addItemsOnSpinner3();
        addItemsOnSpinner4();
        addItemsOnSpinner5();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        return v;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    // add items into spinner dynamically
    public void addItemsOnSpinner2() {


        List<String> list = new ArrayList<String>();
        list.add(" Number of rooms");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }



    public void addItemsOnSpinner3() {


        List<String> list = new ArrayList<String>();
        list.add("Money");
        list.add("<=500");
        list.add("<=1000");
        list.add("<=1500");
        list.add("<=2000");
        list.add(">2000");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }


    public void addItemsOnSpinner4() {


        List<String> list = new ArrayList<String>();
        list.add("Multi tenant");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter);
    }



    public void addItemsOnSpinner5() {


        List<String> list = new ArrayList<String>();
        list.add("Cateogries");
        list.add("room");
        list.add("flat");
        list.add("villa");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(dataAdapter);
    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {


        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem())+
                                "\nSpinner 3 : " + String.valueOf(spinner3.getSelectedItem())+
                                "\nSpinner 4 : " + String.valueOf(spinner4.getSelectedItem())+
                                "\nSpinner 5 : " + String.valueOf(spinner5.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

}
