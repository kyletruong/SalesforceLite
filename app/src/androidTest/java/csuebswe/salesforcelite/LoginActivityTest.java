package csuebswe.salesforcelite;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> LoginRule =
            new ActivityTestRule<>(MainActivity.class);
    private String uName = "kyle";
    private String pWord = "123";

    @Test
    public void loginTest(){
        onView(withId(R.id.username)).perform(typeText(uName), closeSoftKeyboard());

        onView(withId(R.id.password)).perform(typeText(pWord), closeSoftKeyboard());

        onView(withId(R.id.login)).perform(click());

        onView(withText("Open Sales")).check(matches(isDisplayed()));

    }

}