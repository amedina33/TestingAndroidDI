package com.ensolabs.testingandroiddi.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.ensolabs.testingandroiddi.R;
import com.ensolabs.testingandroiddi.injection.MainActivityInjector;
import com.ensolabs.testingandroiddi.thing.Thing;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
  public MainActivityTest() {
    super(MainActivity.class);
  }

  public void testTheTestThingsWereInjectedOne() {
    // Given
    String thingOneText = "I'm TEST ONE Thing One!";
    String thingTwoText = "I'm TEST ONE Thing Two!";
    TestThingModule testThingModule = new TestThingModule(
      thing(thingOneText),
      thing(thingTwoText)
    );

    // When
    MainActivityInjector.setModules(testThingModule);
    getActivity();

    // Then
    onView(withId(R.id.thingOneText)).check(matches(withText(thingOneText)));
    onView(withId(R.id.thingTwoText)).check(matches(withText(thingTwoText)));
  }

  public void testTheTestThingsWereInjectedTwo() {
    // Given
    String thingOneText = "I'm TEST TWO Thing One!";
    String thingTwoText = "I'm TEST TWO Thing Two!";
    TestThingModule testThingModule = new TestThingModule(
      thing(thingOneText),
      thing(thingTwoText)
    );

    // When
    MainActivityInjector.setModules(testThingModule);
    getActivity();

    // Then
    onView(withId(R.id.thingOneText)).check(matches(withText(thingOneText)));
    onView(withId(R.id.thingTwoText)).check(matches(withText(thingTwoText)));
  }

  Thing thing(final String speech) {
    return new Thing() {
      @Override public String speak() {
        return speech;
      }
    };
  }

  @Module(
    injects = MainActivity.class,
    includes = BasicModule.class,
    overrides = true
  )
  public static class TestThingModule {
    private final Thing thingOne;
    private final Thing thingTwo;

    public TestThingModule(Thing thingOne, Thing thingTwo) {
      this.thingOne = thingOne;
      this.thingTwo = thingTwo;
    }

    @Provides @Named("Thing 1") public Thing thingOne() {
      return thingOne;
    }

    @Provides @Named("Thing 2") public Thing thingTwo() {
      return thingTwo;
    }
  }

  @Module(
    library = true,
    complete = false
  )
  public static class BasicModule {

    @Provides @Named("Thing 2") public Thing thingTwo() {
      return new Thing() {
        @Override public String speak() {
          return "I AM the THING!";
        }
      };
    }
  }
}
