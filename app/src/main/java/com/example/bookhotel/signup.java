package com.example.bookhotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
EditText name,email,password,phone;
TextView tv1;
Button signup;
ImageView im;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    boolean valid = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.editTextTextPersonName3);
        email = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextTextPersonName5);
        phone = findViewById(R.id.editTextTextPersonName6);
        signup = findViewById(R.id.button3);
        tv1 = findViewById(R.id.textView4);
        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        im = findViewById(R.id.imageView2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
            }
        });

    im.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(signup.this,login.class);
            startActivity(intent);
        }
    });

        signup.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {

            checkField(name);
            checkField(email);
            checkField(password);
            checkField(phone);

            if(valid)
            {

// start user reg process

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password
                        .getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>()
                {
                    @Override
                    public void onSuccess(AuthResult authResult) { FirebaseUser firebaseUser
                            =firebaseAuth.getCurrentUser();
                        Toast.makeText(signup.this, "Account Created",Toast.LENGTH_SHORT).show();

                        Map<String,Object> userInfo =new HashMap<>();
                        userInfo.put("FullName",name.getText().toString());
                        userInfo.put("UserEmail",email.getText().toString());
                        userInfo.put("Phone",phone.getText().toString());
                        userInfo.put("Password",password.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("User").setValue(userInfo);
//if admin userInfo.put("isUser","1"); documentReference.set(userInfo);
                        startActivity(new Intent(getApplicationContext(),user_side_panel.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() { @Override
                public void onFailure(@NonNull Exception e) { Toast.makeText(signup.this, "Account Not Created", Toast.LENGTH_SHORT).show();
                }
                });

            }


        }
        });


    }
    public boolean checkField(EditText text)
    {
        if(text.getText().toString().isEmpty())
        {
            text.setError("Fill all Fields"); valid=false;
        }
        else
        {
            valid=true;
        }
        return	valid;
    }




}