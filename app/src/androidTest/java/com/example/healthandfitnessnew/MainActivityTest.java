package com.example.healthandfitnessnew;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.google.firebase.auth.UserInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {

    //test the activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    //reference the main activity
    private MainActivity mActivity = null;

    //called before test case is executed
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testStartUp() {
        //try to find a view. if view is found, the activity has launched successfully
        View view = mActivity.findViewById(R.id.btnGoals);

        //if view is found to be not null, the activity has launched successfully
        assertNotNull(view);
    }

    //called after test case is executed
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}