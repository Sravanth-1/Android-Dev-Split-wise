package com.example.settleup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

    ImageView google_img;
    GoogleSignInClient gsc;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google_img = findViewById(R.id.google);
        firebaseAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("338938075301-49prkhc332ac9ltf9d28lsudbi3jp3a5.apps.googleusercontent.com")
                .requestEmail()
                .build();

        gsc = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        google_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }

        });
    }
        private void SignIn() {
            Intent intent=gsc.getSignInIntent();
            startActivityForResult(intent,100);
        }
        @Override
                protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 100) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try{
                    GoogleSignInAccount signInAcc = task.getResult(ApiException.class);
                    AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAcc.getIdToken(),null);
                    firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            HomeActivity();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

                } catch (ApiException e){
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        public void HomeActivity() {

            finish();
            Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
    }
