package com.nourhan.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String zekrName;
    TextView zekrValue, counterTV;
    EditText getZekr;
    int counter = 0;
    ImageView zekrImg;
    Button reset, okbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zekrValue = findViewById(R.id.tv_zekr_name);
        counterTV = findViewById(R.id.counterTV);
        getZekr   = findViewById(R.id.ZekrEditText);
        zekrImg   = findViewById(R.id.zekrimg);
        reset     = findViewById(R.id.reset);
        okbtn     = findViewById(R.id.okbtn);


        okbtn.setOnClickListener(v ->
        {
            zekrName = getZekr.getText().toString();
            zekrValue.setText(zekrName);
            closeKeyBoard();
        });
        zekrImg.setOnClickListener(v ->
        {
            counter = counter + 1;
            counterTV.setText(String.valueOf(counter));
        });
        reset.setOnClickListener(v ->
        {
            getZekr.setText("");
            zekrValue.setText("");
            counterTV.setText("0");
        });
    }
    private void closeKeyBoard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

