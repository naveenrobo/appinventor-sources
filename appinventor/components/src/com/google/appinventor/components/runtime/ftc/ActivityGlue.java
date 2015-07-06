// Copyright 2011-2015 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime.ftc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.qualcomm.ftccommon.DbgLog;

import com.google.appinventor.components.runtime.FtcRobotController;

/**
 * ActivityGlue is the base class for FtcRobotControllerActivity. It acts like glue between
 * FtcRobotControllerActivity and the actual activity of the app.
 */
class ActivityGlue {
  static final int RESULT_OK = Activity.RESULT_OK;

  protected final Activity thisActivity;
  protected final FtcRobotController aiFtcRobotController;
  protected final ResourceIds R;
  protected final int requestCodeConfigureRobot;

  ActivityGlue(Activity activity, FtcRobotController aiFtcRobotController) {
    thisActivity = activity;
    this.aiFtcRobotController = aiFtcRobotController;
    R = new ResourceIds(activity);
    requestCodeConfigureRobot = aiFtcRobotController.requestCodeConfigureRobot;
  }

  /*
   * Called from FtcRobotController.resultReturned.
   */
  public void onActivityResultAI(int request, int result, Intent intent) {
    onActivityResult(request, result, intent);
  }

  /*
   * Called from FtcRobotController.onNewIntent.
   */
  public void onNewIntentAI(Intent intent) {
    onNewIntent(intent);
  }

  /*
   * Called from FtcRobotController.prepareToDie
   */
  public void onStopAI() {
    onStop();
  }

  // Activity methods that are overridden in FtcRobotControllerActivity.

  protected void onActivityResult(int request, int result, Intent intent) {
  }

  public void onConfigurationChanged(Configuration newConfig) {
  }

  protected void onCreate(Bundle savedInstanceState) {
  }

  public boolean onCreateOptionsMenu(Menu menu) {
    return false;
  }

  protected void onNewIntent(Intent intent) {
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    return false;
  }

  public void onPause() {
  }

  protected void onResume() {
  }

  protected void onStart() {
  }

  protected void onStop() {
  }

  // Activity methods that are called from FtcRobotControllerActivity.

  void bindService(Intent intent, ServiceConnection connection, int flags) {
    thisActivity.bindService(intent, connection, flags);
  }

  View findViewById(int id) {
    return thisActivity.findViewById(id);
  }

  void finish() {
    thisActivity.finish();
  }

  ActionBar getActionBar() {
    return thisActivity.getActionBar();
  }

  Context getBaseContext() {
    return thisActivity.getBaseContext();
  }

  MenuInflater getMenuInflater() {
    return thisActivity.getMenuInflater();
  }

  String getString(int id) {
    return thisActivity.getString(id);
  }

  Window getWindow() {
    return thisActivity.getWindow();
  }

  void openOptionsMenu() {
    thisActivity.openOptionsMenu();
  }

  void runOnUiThread(Runnable runnable) {
    thisActivity.runOnUiThread(runnable);
  }

  void setContentView(int layoutId) {
    // Inflate the layout into the FtcRobotController component's view.
    thisActivity.getLayoutInflater().inflate(layoutId, aiFtcRobotController.view, true);
  }

  void startActivity(Intent intent) {
    try {
      thisActivity.startActivity(intent);
    } catch (Throwable e) {
      DbgLog.error("Could not start activity with intent " + intent);
    }
  }

  void startActivityForResult(Intent intent, int i) {
    try {
      thisActivity.startActivityForResult(intent, i);
    } catch (Throwable e) {
      DbgLog.error("Could not start activity with intent " + intent);
    }
  }

  void unbindService(ServiceConnection connection) {
    thisActivity.unbindService(connection);
  }
}