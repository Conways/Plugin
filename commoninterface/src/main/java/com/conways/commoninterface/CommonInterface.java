package com.conways.commoninterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * @author Zong
 * Created on 2019/5/9
 * Describe:
 */
public interface CommonInterface {

    void attch(AppCompatActivity context);

    void onCreate(Bundle savedInstanceState);

    void onStart();


    void onResume();

    void onStop();

    void onPause();

    void onDestroy();

    void onSaveInstanceState(Bundle outState);

    boolean onTouchEvent(MotionEvent event);


}
