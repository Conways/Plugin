package com.conways.thirdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hostContext,SecondActivity.class);
                startActivity(intent);

                Toast.makeText(hostContext,"app",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
