package com.example.healthandfitnessnew.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthandfitnessnew.R;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private ArrayList<Workout> infoList;
    private Adapter adapter;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        lv = findViewById(R.id.lv);

        infoList = DataHelper.loadWorkout(this);
        titleList = new ArrayList<>();
        for(int i = 0; i <infoList.size(); i++){
            String str = infoList.get(i).getTitle();
            titleList.add(str);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);
        lv.setAdapter((ListAdapter) adapter);

        lv.setOnItemClickListener(this);


    }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(this, DetailActivity.class);
            String title = infoList.get(position).getTitle();
            String info = infoList.get(position).getInfo();

            intent.putExtra("EXTRA_TITLE", title);
            intent.putExtra("EXTRA_INFO", info);

            startActivity(intent);
        }
}


