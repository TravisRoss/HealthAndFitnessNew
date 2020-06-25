package com.example.healthandfitnessnew;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StepsTest {

    //test the activity
    @Rule
    public ActivityTestRule<StepsActivity> sActivityTestRule = new ActivityTestRule<>(StepsActivity.class);

    //reference the main activity
    private StepsActivity sActivity = null;

    //called before test case is executed
    @Before
    public void setUp() throws Exception {
        sActivity = sActivityTestRule.getActivity();
    }

    @Test
    public void testStartUp() {
        //try to find a view. if view is found, the activity has launched successfully
        View view = sActivity.findViewById(R.id.stepsTV);

        //if view is found to be not null, the activity has launched successfully
        assertNotNull(view);
    }

    //called after test case is executed
    @After
    public void tearDown() throws Exception {
        sActivity = null;
    }
}