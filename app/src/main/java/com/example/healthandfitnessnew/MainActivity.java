package com.example.healthandfitnessnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthandfitnessnew.workout.WorkoutActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define the buttons
        Button btnGoals, btnUserInfo, btnSteps, btnWorkouts, btnBarChart;

        //reference the buttons
        btnGoals = findViewById(R.id.btnGoals);
        btnUserInfo = findViewById(R.id.btnUserInfo);
        btnSteps = findViewById(R.id.btnSteps);
        btnWorkouts = findViewById(R.id.btnWorkout);
        btnBarChart = findViewById(R.id.btnStepsGraph);

        //set on click listeners for the buttons
        btnGoals.setOnClickListener(this);
        btnUserInfo.setOnClickListener(this);
        btnSteps.setOnClickListener(this);
        btnWorkouts.setOnClickListener(this);
        btnBarChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGoals:
                //launch Goals page
                openGoalsActivity();
                break;
            case R.id.btnUserInfo:
                //launch progress page
                openSaveUserDetails();
                break;
            case R.id.btnSteps:
                //launch steps page
                openStepsActivity();
                break;
            case R.id.btnWorkout:
                //launch deadline page
                openWorkoutsActivity();
                break;
            case R.id.btnStepsGraph:
                //launch deadline page
                openBarChartActivity();
                break;
        }

    }

    public void openGoalsActivity(){
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }

    public void openSaveUserDetails(){
        Intent intent = new Intent(this, SaveUserDetails.class);
        startActivity(intent);
    }

    public void openStepsActivity(){
        Intent intent = new Intent(this, StepsActivity.class);
        startActivity(intent);
    }

    public void openWorkoutsActivity(){
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    public void openBarChartActivity(){
        Intent intent = new Intent(this, BarChartActivity.class);
        startActivity(intent);
    }
}
