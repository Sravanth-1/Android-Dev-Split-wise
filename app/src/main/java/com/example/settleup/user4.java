package com.example.settleup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class user4 extends AppCompatActivity {
    private EditText newly,person2,person3,person4,person5;
    private EditText newlyv,person2v,person3v,person4v,person5v;
    private EditText newvalue3;
    private Button split;
    private Button button12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user4);
        newly = findViewById(R.id.newly);
        person2 = findViewById(R.id.person2);
        person3 = findViewById(R.id.person3);
        person4 = findViewById(R.id.person4);
        person5 = findViewById(R.id.person5);
        newvalue3 = findViewById(R.id.newvalue3);
        split = (Button) findViewById(R.id.button13) ;
        button12 = (Button) findViewById(R.id.button12) ;
        newlyv = findViewById(R.id.vnewly);
        person2v = findViewById(R.id.vperson2);
        person3v = findViewById(R.id.vperson3);
        person4v = findViewById(R.id.vperson4);
        person5v = findViewById(R.id.vperson5);


        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amt = Integer.parseInt(newvalue3.getText().toString());
                int num1 = Integer.parseInt(newly.getText().toString());
                int num2 = Integer.parseInt(person2.getText().toString());
                int num3 = Integer.parseInt(person3.getText().toString());
                int num4 = Integer.parseInt(person4.getText().toString());
                int num5 = Integer.parseInt(person5.getText().toString());
                int sum = num1+num2+num3+num4+num5;
                int ratio = amt/sum;
                int p1 = ratio*num1;
                int p2 = ratio*num2;
                int p3 = ratio*num3;
                int p4 = ratio*num4;
                int p5 = ratio*num5;

                Intent intent = new Intent (getApplicationContext(),result4.class);
                intent.putExtra("key",sum);
                intent.putExtra("key1",p1);
                intent.putExtra("key2",p2);
                intent.putExtra("key3",p3);
                intent.putExtra("key4",p4);
                intent.putExtra("key5",p5);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amt = Integer.parseInt(newvalue3.getText().toString());
                int n1 = Integer.parseInt(newlyv.getText().toString());
                int n2 = Integer.parseInt(person2v.getText().toString());
                int n3 = Integer.parseInt(person3v.getText().toString());
                int n4 = Integer.parseInt(person4v.getText().toString());
                int n5 = Integer.parseInt(person5v.getText().toString());
                int sum = n1+n2+n3+n4+n5;

                Intent intent = new Intent (getApplicationContext(),resultamt4.class);
                intent.putExtra("key",sum);
                intent.putExtra("key1",n1);
                intent.putExtra("key2",n2);
                intent.putExtra("key3",n3);
                intent.putExtra("key4",n4);
                intent.putExtra("key5",n5);
                startActivity(intent);
            }
        });

    }
}