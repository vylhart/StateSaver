package com.example.statesaver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCounter  = 0;
    private TextView textView;
    private final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        findViewById(R.id.button).setOnClickListener(view->{
            mCounter++;
            reflectClick();
        });
    }

    private void reflectClick(){
        textView.setText(String.valueOf(mCounter));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("MAIn", "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY, mCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt(KEY);
        reflectClick();
    }
}