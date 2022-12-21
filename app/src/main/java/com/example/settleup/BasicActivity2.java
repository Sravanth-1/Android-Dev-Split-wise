package com.example.settleup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BasicActivity2 extends AppCompatActivity {
    private Button button;
    private Button button2;
    private EditText indname;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic2);
        indname = findViewById(R.id.indname);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = indname.getText().toString();
                HashMap<String,String> userMap = new HashMap<>();
                userMap.put("person",name);
                root.push().setValue(userMap);
                BasicActivity2();

            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testActivity();

            }
        });
    }
    public void BasicActivity2(){
        Intent intent = new Intent(this, BasicActivity2.class);
        startActivity(intent);
    }
    public void testActivity(){
        Intent intent = new Intent(this, testActivity.class);
        startActivity(intent);
    }
}