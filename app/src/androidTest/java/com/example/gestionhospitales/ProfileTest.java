package com.example.gestionhospitales;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileTest {

    @Rule
    public ActivityTestRule<MenuCardView> activityRule = new ActivityTestRule<>(MenuCardView.class);

    @Test
    public void VerificarDatos(){
        onView(withId(R.id.perfil)).perform(click());
        onView(withId(R.id.viewName)).check(matches(withText("Braulio")));
        onView(withId(R.id.viewApell)).check(matches(withText("Chire Quilca")));
        onView(withId(R.id.viewDNI)).check(matches(withText("71374895")));
        onView(withId(R.id.viewCorreo)).check(matches(withText("brauliochire@gmail.com")));
    }

    @Test
    public void CerrarSesionTest(){
        onView(withId(R.id.perfil)).perform(click());
        onView(withId(R.id.cerrarSesion)).perform(click());
        onView(withId((R.id.correo))).check(matches(isDisplayed()));
    }

}
