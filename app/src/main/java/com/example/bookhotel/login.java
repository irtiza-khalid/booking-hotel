package com.example.bookhotel;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity {
EditText email,password;
Button login,signup;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    boolean validL =true;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    login = findViewById(R.id.button);
    signup = findViewById(R.id.button2);
    email = findViewById(R.id.editTextTextPersonName);
    password = findViewById(R.id.editTextTextPersonName2);
    im = findViewById(R.id.imageView3);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

im.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent( login.this,starter.class);
        startActivity(intent);
    }
});
        login.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {

            checkFieldL(email);
            checkFieldL(password);
            if(validL)
            {

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(login.this, "Login Successfully" , Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(getApplicationContext(),user_side_panel.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() { @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(login.this, "Incorrect Info Try Again", Toast.LENGTH_SHORT).show();

                }
                });
            }

        }
        });
        signup.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), signup.class));
            finish();

        }
        });

    }
    public boolean checkFieldL(EditText text)
    {
        if(text.getText().toString().isEmpty())
        {

            text.setError("Fill all Fields"); validL=false;
        }
        else
        {
            validL=true;
        }
        return	validL;
    }
}