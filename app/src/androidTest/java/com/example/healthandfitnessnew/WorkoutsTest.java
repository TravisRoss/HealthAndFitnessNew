package com.example.healthandfitnessnew;

import com.example.healthandfitnessnew.workout.Workout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WorkoutsTest {
    private Workout workout;

    @Before
    public void setUp() {
        workout = new Workout();
        workout.setInfo("Info test");
        workout.setTitle("Title test");
    }

    @After
    public void tearDown() {
        System.out.println("Workout testing finished.");
    }

    @Test
    public void testInfo() {
        String testString = workout.getInfo();
        assertEquals("Info is invalid", "Info test", testString);
    }

    @Test
    public void testTitle() {
        String testString = workout.getTitle();
        assertEquals("Workout title is invalid", "Title test", testString);
    }

}
