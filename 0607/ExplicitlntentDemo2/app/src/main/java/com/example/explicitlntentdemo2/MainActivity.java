package com.example.explicitlntentdemo2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NonNls;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    ActivityResultLauncher launcher = registerForActivityResult(new ResultContract(),
            new ActivityResultCallback<Double>() {
                @Override
                public void onActivityResult(Double o) {
                    output.setText("計算結果:" + o);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launcher.launch(true);
                launcher.launch("CHUCK");
            }
        });
    }

    class ResultContract extends ActivityResultContract<String, Double> {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String s) {
            Intent intent = new Intent(MainActivity.this, OPActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01", ((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPREAND02", ((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            Log.v("CHUCK", s);
            return intent;
        }

        @Override
        public Double parseResult(int i, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result;
        }
    }
}