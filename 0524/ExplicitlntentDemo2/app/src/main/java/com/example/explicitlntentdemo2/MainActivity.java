package com.example.explicitlntentdemo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txvOpd1, txvOpd2;
                txvOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txvOpd2 = (EditText) findViewById(R.id.txtOpd2);
                Intent intent = new Intent(MainActivity.this, OPActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPERANDO1", txvOpd1.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    output.setText("計算結果:" + bundle.getDouble("RESULT"));
                }
                break;
        }
    }
}