package com.ensolabs.testingandroiddi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ensolabs.testingandroiddi.R;
import com.ensolabs.testingandroiddi.injection.MainActivityInjector;
import com.ensolabs.testingandroiddi.thing.Thing;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends Activity {
  @Inject @Named("Thing 1") Thing thingOne;
  @Inject @Named("Thing 2") Thing thingTwo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MainActivityInjector.inject(this);

    ((TextView) findViewById(R.id.thingOneText)).setText(thingOne.speak());
    ((TextView) findViewById(R.id.thingTwoText)).setText(thingTwo.speak());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
