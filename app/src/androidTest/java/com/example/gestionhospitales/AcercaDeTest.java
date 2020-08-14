package com.example.gestionhospitales;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class AcercaDeTest {

    @Rule
    public ActivityTestRule<About> activityRule = new ActivityTestRule<>(About.class);

    @Test
    public void VerificarDatos(){
        onView(withId(R.id.imageView8));
        onView(withId(R.id.textView9));
        onView(withId(R.id.viewSomos));
        onView(withId(R.id.textView10));
        onView(withId(R.id.viewInfo));
        onView(withId(R.id.imageView9));
        onView(withId(R.id.viewHistoria));
        onView(withId(R.id.imageView7));
        onView(withId(R.id.viewCitas));
        onView(withId(R.id.imageView10));
        onView(withId(R.id.viewStaffDoc));
        onView(withId(R.id.imageView11));
    }
}
