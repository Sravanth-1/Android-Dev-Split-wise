package com.example.settleup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultamt extends AppCompatActivity {
    TextView getdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultamt);
        Intent intent = getIntent();

        getdata = findViewById(R.id.textView15);

        int data1 = intent.getIntExtra("key1",0);
        getdata.setText(Integer.toString(data1));
        getdata = findViewById(R.id.textView16);

        int data2 = intent.getIntExtra("key2",0);
        getdata.setText(Integer.toString(data2));
        getdata = findViewById(R.id.textView17);

        int data3 = intent.getIntExtra("key3",0);
        getdata.setText(Integer.toString(data3));
        getdata = findViewById(R.id.textView18);

        int data4 = intent.getIntExtra("key4",0);
        getdata.setText(Integer.toString(data4));
        getdata = findViewById(R.id.textView19);

        int data5 = intent.getIntExtra("key5",0);
        getdata.setText(Integer.toString(data5));
    }
}