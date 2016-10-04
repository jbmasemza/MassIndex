package com.example.android.massindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double weight, BMI;
    EditText edtheight;
    RadioGroup rediGroup;
    RadioButton selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtheight = (EditText) findViewById(R.id.height);
        rediGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        rediGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selected = (RadioButton) rediGroup.findViewById(checkedId);

                String weight_msg = selected.getText().toString();

                if (weight_msg.equals("0-49")) {
                    weight = 49;
                } else if (weight_msg.equals("50-89")) {
                    weight = 89;
                } else if (weight_msg.equals("90-180")) {
                    weight = 180;
                }

                String tempHeight = edtheight.getText().toString();
                double height = Double.parseDouble(tempHeight);

                BMI = (weight / (height * height));
                String convertedBMI = convertNumber(BMI);

                String msg = "";

                if (BMI > 30) {
                    msg = "OBESE";
                } else if (BMI > 25) {
                    msg = "OERWEIGHT";
                } else if (BMI > 18.5) {
                    msg = "NORMAL";
                } else {
                    msg = "Under Weight";
                }

                Toast.makeText(MainActivity.this, convertedBMI + " You are " + msg, Toast.LENGTH_LONG).show();


                Toast.makeText(MainActivity.this, convertedBMI, Toast.LENGTH_LONG).show();
            }
        });
    }

    public String convertNumber(double tempBMI) {
        // 2.654782

        String convertedBMI, tempPart1, longString, tempPart3;
        int pos = 0;

        tempPart1 = String.valueOf(tempBMI);
        pos = tempPart1.indexOf(".");
        tempPart3 = tempPart1.substring(0, pos);
        longString = tempPart1.substring(pos + 1, tempPart1.length());


        convertedBMI = tempPart3 + "." + longString.substring(0, 2);

        return convertedBMI;
    }

}

