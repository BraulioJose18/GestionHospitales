package com.example.gestionhospitales;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MedicosTest {

    @Rule
    public ActivityTestRule<MedicosListado> activityRule = new ActivityTestRule<>(MedicosListado.class);

    @Test
    public void RecyclerMedicos(){
        onView(withId(R.id.rvMedicos)).perform(RecyclerViewActions.scrollToPosition(15));
        //onView(withId(R.id.rvMedicos)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.rvMedicos)).perform(RecyclerViewActions.scrollToPosition(1));
    }
}
