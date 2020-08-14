package com.example.gestionhospitales;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalendarioTest {

    @Rule
    public ActivityTestRule<Calendario> activityRule = new ActivityTestRule<>(Calendario.class);

    @Test
    public void VerificarDatos(){
        onView(withId(R.id.imageView8));
        onView(withId(R.id.textView2));
        onView(withId(R.id.calendarView));
    }
}
