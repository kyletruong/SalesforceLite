package csuebswe.salesforcelite;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> lActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    //public ActivityTestRule<EmployeeActivity> eActivityTestRule = new ActivityTestRule<EmployeeActivity>(EmployeeActivity.class);
    private String uName = "Kyle";
    private String pWord = "123";
    //private String b1 = "Open sales";
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testUIScenario(){
        // Input some text(userName) into edit text.
        Espresso.onView(withId(R.id.username)).perform(typeText(uName));
        // Close soft keyboard
        Espresso.closeSoftKeyboard();
        // Input some text(passWord) into edit text.
        Espresso.onView(withId(R.id.password)).perform(typeText(pWord));
        // Close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.login)).perform(click());
        // Checks if its on the correct view
        //Espresso.onView(withId(R.id.rvEmployee)).check(matches(withText(b1)));




    }




    @After
    public void tearDown() throws Exception {
    }
}