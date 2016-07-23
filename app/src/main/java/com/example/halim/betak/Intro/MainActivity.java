package com.example.halim.betak.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.halim.betak.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button CreatB = (Button) findViewById(R.id.button);
        Button SignB = (Button) findViewById(R.id.button2);

        CreatB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this,CreateActivity.class);
                startActivity(i);
            }
        });

        SignB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j;
                j = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(j);
            }
        });
    }


}
