package com.example.explicitlntentdemo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opactivity);

        CheckBox chKDivide = (CheckBox) findViewById(R.id.chkDivide);
        chKDivide.setEnabled(false);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1, opd2;
                double result = 0.0;
                RadioButton rdbAdd, rdbSubtract, rdbMulitiply, rdbDivide;
                CheckBox chkDivide;
                //取得傳遞資料
                Bundle bundle = OPActivity.this.getIntent().getExtras();
                if(bundle == null) return;;
                //取得運算元
                opd1 = Integer.parseInt(bundle.getString("OPERANDO1"));
                opd2 = Integer.parseInt(bundle.getString("OPERANDO2"));
                //取得選取的運算子
                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                if(rdbAdd.isChecked()){
                    result = opd1 + opd2; //加
                }
                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                if(rdbSubtract.isChecked()){
                    chKDivide.setEnabled(false);
                    result = opd1 - opd2; //減
                }
                rdbMulitiply = (RadioButton) findViewById(R.id.rdbMultiply);
                if(rdbMulitiply.isChecked()){
                    chKDivide.setEnabled(false);
                    result = opd1 * opd2; //乘
                }
                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
                //chKDivide = (CheckBox) findViewById(R.id.chkDivide);
                if (rdbDivide.isChecked()){
                    chKDivide.setEnabled(true);
                    if(chKDivide.isChecked())
                        result = opd1 / opd2;
                    else
                        result = opd1 / (double)opd2;
                }
                Intent rIntent = new Intent();
                Bundle rbunble = new Bundle();
                rbunble.putDouble("RESULT", result);
                rIntent.putExtras(rbunble);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });
    }
}