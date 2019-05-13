package com.conways.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conways.commoninterface.CommonInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ThirdAppHolderActivity extends AppCompatActivity {
    private CommonInterface commonInterface;

    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
        try {
            Class activityClass = getClassLoader().loadClass(className);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});
            commonInterface = (CommonInterface) instance;
            commonInterface.attch(this);
            commonInterface.onCreate(savedInstanceState);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        commonInterface.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        commonInterface.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        commonInterface.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        commonInterface.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        commonInterface.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        commonInterface.onSaveInstanceState(outState);
    }

    @Override
    public ClassLoader getClassLoader() {
        return PlugionManager.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        return PlugionManager.getInstance().getResources();
    }

    @Override
    public void startActivity(Intent intent) {
        String className = intent.getStringExtra("className");
        Intent intent1 = new Intent(this, ThirdAppHolderActivity.class);
        intent1.putExtra("className", className);
        super.startActivity(intent1);
    }
}
