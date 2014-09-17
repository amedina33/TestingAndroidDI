package com.ensolabs.testingandroiddi.thing;

import com.ensolabs.testingandroiddi.activity.MainActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(
  injects = MainActivity.class
)
public class ThingModule {

  @Provides @Named("Thing 1") public Thing thingOne() {
    return new ThingOne();
  }

  @Provides @Named("Thing 2") public Thing thingTwo() {
    return new ThingTwo();
  }
}
