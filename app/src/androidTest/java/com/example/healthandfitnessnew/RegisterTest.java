package com.example.healthandfitnessnew;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RegisterTest {

    //test the activity
    @Rule
    public ActivityTestRule<RegisterActivity> rActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    //reference the main activity
    private RegisterActivity rActivity = null;

    //called before test case is executed
    @Before
    public void setUp() throws Exception {
        rActivity = rActivityTestRule.getActivity();
    }

    @Test
    public void testStartUp() {
        //try to find a view. if view is found, the activity has launched successfully
        View view = rActivity.findViewById(R.id.editText);

        //if view is found to be not null, the activity has launched successfully
        assertNotNull(view);
    }

    //called after test case is executed
    @After
    public void tearDown() throws Exception {
        rActivity = null;
    }
}