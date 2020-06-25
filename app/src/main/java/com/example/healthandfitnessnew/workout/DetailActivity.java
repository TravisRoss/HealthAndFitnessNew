package com.example.healthandfitnessnew.workout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthandfitnessnew.R;

public class DetailActivity extends AppCompatActivity {

    private TextView title;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title_tv);
        info = findViewById(R.id.info_tv);

        Bundle extra = getIntent().getExtras();
        //if there isn't anything in it
        if(extra != null){
            String t = extra.getString("EXTRA_TITLE");
            String i = extra.getString("EXTRA_INFO");

            title.setText(t);
            info.setText(i);
        }
    }
}
