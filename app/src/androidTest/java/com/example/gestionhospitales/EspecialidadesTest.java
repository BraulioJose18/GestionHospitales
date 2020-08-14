package com.example.gestionhospitales;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspecialidadesTest {

    @Rule
    public ActivityTestRule<EspecialidadListado> activityRule = new ActivityTestRule<>(EspecialidadListado.class);

    @Test
    public void RecyclerEspecialidad(){
        onView(withId(R.id.rvEspecialidad)).perform(RecyclerViewActions.scrollToPosition(15));
        onView(withId(R.id.rvEspecialidad)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.rvEspecialidad)).perform(RecyclerViewActions.scrollToPosition(1));
    }
}
