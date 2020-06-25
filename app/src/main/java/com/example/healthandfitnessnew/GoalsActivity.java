package com.example.healthandfitnessnew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GoalsActivity extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        //connect with all xml elements in activity_goals.xml
        final EditText stepGoal = findViewById(R.id.etSteps);
        final EditText calorieGoal = findViewById(R.id.etCalories);
        Button setGoal = findViewById(R.id.btnSetGoal);
        Button btnHomeFromGoals = findViewById(R.id.btnHomeFromGoals);



        //save data to Firebase when save button is tapped
        setGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate step goal and calorie goal
                if (stepGoal.getText().toString().length() == 0) {
                    stepGoal.setError("Set Steps Goal");
                    return;
                } else if (calorieGoal.getText().toString().length() == 0) {
                    calorieGoal.setError("Set Calorie Goal!");
                    return;
                }

                //get instance
                rootNode = FirebaseDatabase.getInstance();
                //define reference to call.
                reference = rootNode.getReference("users");

                //get values from the text fields
                final String steps = stepGoal.getText().toString().trim();
                final String calories = calorieGoal.getText().toString().trim();

                reference.child("Step goal").setValue(steps);
                reference.child("Calorie goal").setValue(calories);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        //on click listener to return home
        btnHomeFromGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToHomePage();
            }
        });

    }// end onCreate

    public void returnToHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}//end class
