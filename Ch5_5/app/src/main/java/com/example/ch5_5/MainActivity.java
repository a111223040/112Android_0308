package com.example.ch5_5;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private TextView txvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvOutput = (TextView) findViewById(R.id.txvOutput);
        txvOutput.setTextSize(25);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int act = event.getAction();
        switch (act){
            case MotionEvent.ACTION_DOWN:
                txvOutput.setText("ACTION_DOWN");
                txvOutput.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP:
                txvOutput.setText("ACTION_UP");
                txvOutput.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                txvOutput.setText("X = " + x + "/");
        }
        return false;
    }
}
