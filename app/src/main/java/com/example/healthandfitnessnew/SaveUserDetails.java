package com.example.healthandfitnessnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveUserDetails extends AppCompatActivity {

    private EditText editTextName, editTextPhoneNo, editTextAge, editTextHeight, editTextWeight;
    private Button saveBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_user_details);

        //connect with all xml elements in activity_save_user_details.xml
        editTextName = findViewById(R.id.nameInput);
        editTextPhoneNo = findViewById(R.id.phoneInput);
        editTextAge = findViewById(R.id.ageInput);
        editTextHeight = findViewById(R.id.heightInput);
        editTextWeight = findViewById(R.id.weightInput);
        saveBtn = findViewById(R.id.saveButton);

        //save data to Firebase when save button is tapped
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get instance
                rootNode = FirebaseDatabase.getInstance();
                //define reference to call.
                reference = rootNode.getReference("users");

                //get values from the text fields
                final String userName = editTextName.getText().toString().trim();
                final String userPhone = editTextPhoneNo.getText().toString().trim();
                //put gender here
                String userAge = editTextAge.getText().toString().trim();
                final String userHeight = editTextHeight.getText().toString().trim();
                String userWeight = editTextWeight.getText().toString().trim();


                //validate user input
                if (userName.length() == 0) {
                    editTextName.setError("Please enter your name");
                    return;
                } else if (userPhone.length() == 0) {
                    editTextPhoneNo.setError("Please enter your phone number");
                    return;
                } else if (userAge.length() == 0) {
                    editTextAge.setError("Please enter your age");
                    return;
                } else if (userHeight.length() == 0) {
                    editTextHeight.setError("Please enter your height");
                    return;
                } else if (userWeight.length() == 0) {
                    editTextWeight.setError("Please enter your weight ");
                    return;
                }

                UserHelperClass helperClass = new UserHelperClass(userName, userPhone, userAge, userHeight, userWeight);

                reference.child(userPhone).setValue(helperClass);
                Toast.makeText(getApplicationContext(),"Data saved successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

} //end class
