package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;

import org.junit.Before;
import org.junit.Test;

public class MainActivityTest {
    private final String emptyInput = "";
    private final String fieldEmpty = "Field ini tidak boleh kosong";
    private final String dummyTotal = "Rp. 250000";
    private final String dummyJumlahTiket = "5";

    @Before
    public void setup() {
        ActivityScenario.launch(TicketActivity.class);
    }

    @Test
    public void assertEmptyInput() {
        onView(withId(R.id.edt_jumlah)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_pay)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_pay)).perform(click());
        onView(withId(R.id.edt_jumlah)).check(matches(hasErrorText(fieldEmpty)));
    }

    @Test
    public void assertTotal() {
        onView(withId(R.id.edt_jumlah)).perform(typeText(dummyJumlahTiket));
        onView(withId(R.id.btn_pay)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_pay)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyTotal)));
    }
}