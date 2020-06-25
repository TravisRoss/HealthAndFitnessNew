package com.example.healthandfitnessnew;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ExerciseGuide extends AppCompatActivity {
Button btn;
VideoView videov;
MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_guide);

        btn = findViewById(R.id.button);
        videov = findViewById(R.id.videoView);
        mediaC = new MediaController(this);

        /*Button btnHomeFromHistory = findViewById(R.id.btnHomeFromHistory);
        btnHomeFromHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToHomePage();
            }
        });*/

    }

    public void playVideo(View v){
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.curl);
        videov.setVideoURI(uri);
        videov.requestFocus();
        videov.start();
        mediaC.setAnchorView(videov);
    }

    /*public void playVideo(View v){
        String bicepVideo = "android.resource://com.example.healthandfitnessnew" + R.raw.curl;
        Uri uri = Uri.parse(bicepVideo);
        videov.setVideoURI(uri);
        videov.start();
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
    }*/

    /*public void returnToHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

}
