package com.example.gestionhospitales;

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
public class MenuHistorialTest {

    @Rule
    public ActivityTestRule<MenuHistorial> activityRule = new ActivityTestRule<>(MenuHistorial.class);
    @Test
    public void menuHistorialCitas(){
        onView(withId(R.id.historialCitas)).perform(click());
    }
    @Test
    public void menuHistorialRecetas(){
        onView(withId(R.id.historialRecetas)).perform(click());
    }
    @Test
    public void menuHistorialExamenes(){
        onView(withId(R.id.historialExamenes)).perform(click());
    }

}
