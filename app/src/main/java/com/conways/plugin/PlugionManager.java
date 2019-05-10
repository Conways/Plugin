package com.conways.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * @author Zong
 * Created on 2019/5/10
 * Describe:
 */
public class PlugionManager {

    private DexClassLoader dexClassLoader;
    private Resources resources;
    private Context context;
    private String enterActivityName="test";

    private static final PlugionManager ourInstance = new PlugionManager();

    public static PlugionManager getInstance() {
        return ourInstance;
    }

    private PlugionManager() {
    }


    public void load(String path) {
        File dexOutFile = context.getDir("dex", Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(), null,
                context.getClassLoader());
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path,
                PackageManager.GET_ACTIVITIES);
        enterActivityName = packageInfo.activities[0].name;
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(),
                    context.getResources().getConfiguration());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public String getEnterActivityName() {
        return enterActivityName;
    }


    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

}
