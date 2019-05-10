package com.conways.thirdapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.conways.commoninterface.CommonInterface;

/**
 * @author Zong
 * Created on 2019/5/9
 * Describe:
 */
@SuppressLint("MissingSuperCall")
public class BaseActivity extends AppCompatActivity implements CommonInterface {
    AppCompatActivity hostContext;

    @Override
    public void attch(AppCompatActivity context) {
        hostContext = context;
    }

    @Override
    public ClassLoader getClassLoader() {
        if (null == hostContext) {
            return super.getClassLoader();
        }

        return hostContext.getClassLoader();
    }


    @Override
    public <T extends View> T findViewById(int id) {

        if (null == hostContext) {
            return super.findViewById(id);
        }

        return hostContext.findViewById(id);
    }


    @Override
    public void setContentView(int layoutResID) {
        if (null == hostContext) {
            super.setContentView(layoutResID);
        }
        hostContext.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        if (null == hostContext) {
            super.setContentView(view);
        }
        hostContext.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {

        if (null == hostContext) {
            super.setContentView(view, params);
        }
        hostContext.setContentView(view, params);
    }


    @Override
    public LayoutInflater getLayoutInflater() {
        if (null == hostContext) {
            return super.getLayoutInflater();
        }

        return hostContext.getLayoutInflater();
    }

    @Override
    public Window getWindow() {
        if (null == hostContext) {
            return super.getWindow();
        }

        return hostContext.getWindow();
    }

    @Override
    public WindowManager getWindowManager() {
        if (null == hostContext) {
            return super.getWindowManager();
        }

        return hostContext.getWindowManager();
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        if (null == hostContext) {
            return super.getSupportFragmentManager();
        }
        return hostContext.getSupportFragmentManager();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
