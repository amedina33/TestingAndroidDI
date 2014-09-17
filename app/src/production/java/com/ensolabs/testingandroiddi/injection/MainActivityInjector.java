package com.ensolabs.testingandroiddi.injection;

import com.ensolabs.testingandroiddi.activity.MainActivity;
import com.ensolabs.testingandroiddi.thing.ThingModule;

import dagger.ObjectGraph;

public class MainActivityInjector {

  public static void inject(MainActivity activity) {
    ObjectGraph objectGraph = ObjectGraph.create(new ThingModule());
    objectGraph.inject(activity);
  }
}
