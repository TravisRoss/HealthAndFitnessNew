package com.example.healthandfitnessnew;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GoalsTest {

    //test the activity
    @Rule
    public ActivityTestRule<GoalsActivity> gActivityTestRule = new ActivityTestRule<>(GoalsActivity.class);

    //reference the main activity
    private GoalsActivity gActivity = null;

    //called before test case is executed
    @Before
    public void setUp() throws Exception {
        gActivity = gActivityTestRule.getActivity();
    }

    @Test
    public void testStartUp() {
        //try to find a view. if view is found, the activity has launched successfully
        View view = gActivity.findViewById(R.id.txtSteps);

        //if view is found to be not null, the activity has launched successfully
        assertNotNull(view);
    }

    //called after test case is executed
    @After
    public void tearDown() throws Exception {
        gActivity = null;
    }
}