package com.example.gestionhospitales;

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
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MenuPrincipalTest {

    @Rule
    public ActivityTestRule<MenuCardView> activityRule = new ActivityTestRule<>(MenuCardView.class);
    @Test
    public void muenuHistorial(){
        onView(withId(R.id.historial)).perform(click());
    }
    @Test
    public void muenuEspecialidades(){
        onView(withId(R.id.staff)).perform(click());
    }
    @Test
    public void muenuCalendario(){
        onView(withId(R.id.calendario)).perform(click());
    }
    @Test
    public void muenuReservas(){
        onView(withId(R.id.reservas)).perform(click());
    }
    @Test
    public void muenuPerfil(){
        onView(withId(R.id.perfil)).perform(click());
    }
    @Test
    public void muenuAcercaDe(){
        onView(withId(R.id.acerca)).perform(click());
    }
}
