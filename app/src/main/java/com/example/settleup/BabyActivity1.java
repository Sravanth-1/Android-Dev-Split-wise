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

public class BabyActivity1 extends AppCompatActivity {
    private EditText gname;
    private Button groupname;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby1);
        groupname = (Button) findViewById(R.id.groupname);
        gname = findViewById(R.id.gname);

        groupname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = gname.getText().toString();
                HashMap<String,String> userMap = new HashMap<>();
                userMap.put("group name",name);
                root.push().setValue(userMap);
                BasicActivity2();

            }
        });

    }
    public void BasicActivity2(){
        Intent intent = new Intent( this, BasicActivity2.class);
        startActivity(intent);
    }
}