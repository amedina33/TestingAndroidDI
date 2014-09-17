package com.ensolabs.testingandroiddi.injection;

import com.ensolabs.testingandroiddi.activity.MainActivity;
import com.ensolabs.testingandroiddi.thing.TestThingModule;

import dagger.ObjectGraph;

public class MainActivityInjector {

  public static void inject(MainActivity activity) {
    ObjectGraph objectGraph = ObjectGraph.create(new TestThingModule());
    objectGraph.inject(activity);
  }
}
