package com.example.android.grade4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.grade4.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* onClick listener to open English Videos list */
        TextView openEnglishList =(TextView) findViewById(R.id.english);
        openEnglishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,EnglishActivity.class);
                startActivity(i);
            }
        });

        /* onClick listener to open math's Videos  list */
        TextView openMathList = (TextView) findViewById(R.id.math);
        openMathList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MathActivity.class);
                startActivity(i);

            }
        });
        /* onClick listener to open Science  list */
        TextView openScienceList =(TextView)findViewById(R.id.science);
        openScienceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScienceActivity.class);
                startActivity(i);
            }
        });
        /* onClick listener to open social's videos  list */
        TextView openSocialList =(TextView)findViewById(R.id.social);
        openSocialList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SocialActivity.class);
                startActivity(i);
            }
        });
    }
}
