package csuebswe.salesforcelite.model;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.junit.Assert.*;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import csuebswe.salesforcelite.MainActivity;
import csuebswe.salesforcelite.R;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest

public class EmployeeModelUITest {

    @Rule
    public ActivityTestRule<MainActivity> lActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private String uName = "Kyle";
    private String pWord = "123";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getClosedSales() {
        //Input text to login with username and password
        Espresso.onView(withId(R.id.username)).perform(typeText(uName), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password)).perform(typeText(pWord), closeSoftKeyboard());
        Espresso.onView(withId(R.id.login)).perform(click());

        //perform button click to get closed sales list
        Espresso.onView(withId(R.id.rvCloseSale)).perform(click());

    }

    @Test
    public void getOpenSales() {
       //Input text to login with username and password
        Espresso.onView(withId(R.id.username)).perform(typeText(uName), closeSoftKeyboard());
        Espresso.onView(withId(R.id.password)).perform(typeText(pWord), closeSoftKeyboard());
        Espresso.onView(withId(R.id.login)).perform(click());

        //perform button click to get open sales list
        Espresso.onView(withId(R.id.rvSalesList)).perform(click());

    }
}