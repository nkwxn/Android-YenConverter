package com.money.yen.yenconverter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private EditText exRateEditText;
    private String ratestring;
    private String rateText;
    private Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        ratestring = sharedPref.getString("myrate","");

        rateText = ratestring;

        exRateEditText = (EditText) findViewById(R.id.exRateEditText);
        convertBtn = (Button) findViewById(R.id.convertBtn);

        exRateEditText.setText(rateText);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText exRateEditText = (EditText) findViewById(R.id.exRateEditText);
                EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

//              Nilai tukar * Jumlah uang dalam Yen = Jumlah uang dalam Rupiah
                int num1 = Integer.parseInt(exRateEditText.getText().toString());
                int num2 = Integer.parseInt(amountEditText.getText().toString());
                int result = num1 * num2;

                resultTextView.setText(num2 + "円" + System.lineSeparator() + "=" + System.lineSeparator() + "Rp" + result + "");

//              Menyimpan teks yang terakhir dicatat pada Exchange Rate
                sharedPref.edit().putString("myrate", exRateEditText.getText().toString()).commit();
            }
        });

    }
}
