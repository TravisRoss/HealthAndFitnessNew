package com.example.healthandfitnessnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StepsActivity extends AppCompatActivity {

    private TextView textView;
    private double MagnitudePrevious = 0;
    private Integer stepCount = 0;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        textView = findViewById(R.id.stepsTV);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //access sensor from our access manager
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener stepDetector = new SensorEventListener() {
            @Override
            //change default passing variable to sensorEvent
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null){
                    float x_acceleration = sensorEvent.values[0];
                    float y_acceleration = sensorEvent.values[1];
                    float z_acceleration = sensorEvent.values[2];

                    //create a manager
                    double Magnitude = Math.sqrt(x_acceleration*x_acceleration + y_acceleration*y_acceleration + z_acceleration*z_acceleration);
                    double MagnitudeDelta = Magnitude - MagnitudePrevious;
                    MagnitudePrevious = Magnitude;

                    //get instance
                    rootNode = FirebaseDatabase.getInstance();
                    //define reference to call.
                    reference = rootNode.getReference("users");

                    //get values from the text fields
                    final String steps = textView.getText().toString().trim();

                    if(MagnitudeDelta > 6){
                        stepCount++;
                        reference.child("Steps").setValue(steps);
                    }
                    textView.setText(stepCount.toString());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        //register the listener to the sensor
        sensorManager.registerListener(stepDetector, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /*code so that the number doesn't reset to 1 each time.
    It will save the step count from the last time time it was used and add to it.*/
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //clear any old data
        editor.clear();
        editor.putInt("StepCount", stepCount);
        editor.apply();
    }

    //app is stopped or terminated
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //clear any old data
        editor.clear();
        editor.putInt("StepCount", stepCount);
        editor.apply();

    } // end onStop

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        stepCount = sharedPreferences.getInt("StepCount", 0);
    } // end onResume
} //end class