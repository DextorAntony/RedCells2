package com.redcells;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class policy extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        tv = findViewById(R.id.tv);
        String text = "";
        try {
            InputStream is = getAssets().open("File.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        tv.setText(text);
    }
    }

