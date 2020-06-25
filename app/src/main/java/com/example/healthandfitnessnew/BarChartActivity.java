package com.example.healthandfitnessnew;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BarChartActivity extends AppCompatActivity {
    BarChart barChart;
    private DatabaseReference databaseReference;
    float jan = 0;
    float feb = 0;
    float mar = 0;
    float apr = 0;
    float may = 0;
    float jun = 0;
    float jul = 0;
    float aug = 0;
    float sep = 0;
    float oct = 0;
    float nov = 0;
    float dec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        // Write a message to the database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDbRef = mDatabase.getReference("Steps");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child("monthCounts");
        barChart = findViewById(R.id.bargraph);
        getCountFromDBandThenPopulate();
    }

    // populate the bar chart
    private void populateBarChart() {

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, jan));
        barEntries.add(new BarEntry(1, feb));
        barEntries.add(new BarEntry(2, mar));
        barEntries.add(new BarEntry(3, apr));
        barEntries.add(new BarEntry(4, may));
        barEntries.add(new BarEntry(5, jun));
        barEntries.add(new BarEntry(6, jul));
        barEntries.add(new BarEntry(7, aug));
        barEntries.add(new BarEntry(8, sep));
        barEntries.add(new BarEntry(9, oct));
        barEntries.add(new BarEntry(10, nov));
        barEntries.add(new BarEntry(11, dec));
        BarDataSet dataSet = new BarDataSet(barEntries, "# of steps");
        BarData barData = new BarData(dataSet);

        // sets the months on the x axis
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        List<String> xAxisValues = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        barChart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));

        // puts the data on the chart
        barChart.setData(barData);

        // customization options
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getAxisLeft().setAxisMinValue(0);
    }

    // gets the step counts from firebase and then finally calling the populateBarChart method in the final if/else statement
    private void getCountFromDBandThenPopulate() {
        databaseReference.child("JanCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    jan = dataSnapshot.getChildrenCount();
                } else {
                    jan = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("FebCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    feb = dataSnapshot.getChildrenCount();
                } else {
                    feb = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("MarCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    mar = dataSnapshot.getChildrenCount();
                } else {
                    mar = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("AprCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    apr = dataSnapshot.getChildrenCount();
                } else {
                    apr = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("MayCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    may = dataSnapshot.getChildrenCount();
                } else {
                    may = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("JunCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    jun = dataSnapshot.getChildrenCount();
                } else {
                    jun = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("JulCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    jul = dataSnapshot.getChildrenCount();
                } else {
                    jul = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("AugCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    aug = dataSnapshot.getChildrenCount();
                } else {
                    aug = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("SepCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    sep = dataSnapshot.getChildrenCount();
                } else {
                    sep = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("OctCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    oct = dataSnapshot.getChildrenCount();
                } else {
                    oct = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("NovCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    nov = dataSnapshot.getChildrenCount();
                } else {
                    nov = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        databaseReference.child("DecCount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    dec = dataSnapshot.getChildrenCount();
                    populateBarChart();
                } else {
                    dec = 0;
                    populateBarChart();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}