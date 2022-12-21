package com.example.settleup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class testActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");
    private adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<model>list;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adapter = new adapter(this,list);
        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    model mod = dataSnapshot.getValue(model.class);
                    list.add(mod);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1();

            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user2();

            }
        });
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user3();

            }
        });
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user4();

            }
        });
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user5();

            }
        });
    }
    public void user1(){
        startActivity( new Intent(getApplicationContext(), user1.class));
    }
    public void user2(){
        startActivity( new Intent(getApplicationContext(), user2.class));
    }
    public void user3(){
        startActivity( new Intent(getApplicationContext(), user3.class));
    }
    public void user4(){
        startActivity( new Intent(getApplicationContext(), user4.class));
    }
    public void user5(){
        startActivity( new Intent(getApplicationContext(), user5.class));
    }
}