package com.conways.plugin;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlugionManager.getInstance().setContext(this);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file=new File(getCacheDir().toString(),"thirdApp.apk");
                PlugionManager.getInstance().load(file.getAbsolutePath());
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,ThirdAppHolderActivity.class);
                String name=PlugionManager.getInstance().getEnterActivityName();
                intent.putExtra("className", name);
                startActivity(intent);
            }
        });
    }
}
