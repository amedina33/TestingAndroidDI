package com.ensolabs.testingandroiddi.injection;

import com.ensolabs.testingandroiddi.activity.MainActivity;

import dagger.ObjectGraph;

public class MainActivityInjector {
  private static Object[] modules = new Object[0];

  public static void inject(MainActivity activity) {
    ObjectGraph objectGraph = ObjectGraph.create(modules);
    objectGraph.inject(activity);
  }

  public static void setModules(Object... modules) {
    MainActivityInjector.modules = modules;
  }
}
