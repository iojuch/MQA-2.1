package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction tabView = onView(withText("Tab 1"));
        tabView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withText("Page: 1"));
        tabView.check(matches(isDisplayed()));
        textView.check(matches(withText("Page: 1")));


        ViewInteraction tabView2 = onView(withText("Tab 2"));
        tabView2.check(matches(isDisplayed()));
        tabView2.check(matches(withText("Tab 2")));
        tabView2.perform(click());

        ViewInteraction textView2 = onView(withText("Page: 2"));
        textView2.check(matches(isDisplayed()));
        textView2.check(matches(withText("Page: 2")));
    }
}
