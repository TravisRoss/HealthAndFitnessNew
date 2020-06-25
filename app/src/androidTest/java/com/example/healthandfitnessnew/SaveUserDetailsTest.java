package com.example.healthandfitnessnew;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SaveUserDetailsTest {

    //test the activity
    @Rule
    public ActivityTestRule<SaveUserDetails> sdActivityTestRule = new ActivityTestRule<>(SaveUserDetails.class);

    //reference the main activity
    private SaveUserDetails sdActivity = null;

    //called before test case is executed
    @Before
    public void setUp() throws Exception {
        sdActivity = sdActivityTestRule.getActivity();
    }

    @Test
    public void testStartUp() {
        //try to find a view. if view is found, the activity has launched successfully
        View view = sdActivity.findViewById(R.id.nameInput);

        //if view is found to be not null, the activity has launched successfully
        assertNotNull(view);
    }

    //called after test case is executed
    @After
    public void tearDown() throws Exception {
        sdActivity = null;
    }
}