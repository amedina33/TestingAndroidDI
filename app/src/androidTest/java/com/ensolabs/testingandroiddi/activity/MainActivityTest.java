package com.ensolabs.testingandroiddi.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.ensolabs.testingandroiddi.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
  public MainActivityTest() {
    super(MainActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    getActivity();
  }

  public void testTheTestThingsWereInjected() {
    onView(withId(R.id.thingOneText)).check(matches(withText("I'm TEST Thing One!")));
    onView(withId(R.id.thingTwoText)).check(matches(withText("I'm TEST Thing Two!")));
  }
}
