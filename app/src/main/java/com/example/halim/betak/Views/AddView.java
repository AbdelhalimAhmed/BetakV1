package com.example.halim.betak.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.halim.betak.R;

public class AddView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        ImageView imageView = (ImageView) findViewById(R.id.add_view);
        Intent intent = this.getIntent();
        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)){
            int src = intent.getIntExtra(Intent.EXTRA_TEXT,1);
            imageView.setImageResource(src);
        }
    }
}
