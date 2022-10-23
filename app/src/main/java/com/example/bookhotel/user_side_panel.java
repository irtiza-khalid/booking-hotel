package com.example.bookhotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class user_side_panel extends AppCompatActivity {
    BottomNavigationView bt1;
    FragmentContainerView f1;
    bookings bookings = new bookings();
    chat chat = new chat();
    profile profile = new profile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_side_panel);
        bt1 = findViewById(R.id.bottomNavigationView);
        f1 = findViewById(R.id.fragmentContainerView);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,bookings).commit();

        bt1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.bookings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,bookings).commit();
                        break;
                    case R.id.chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,chat).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profile).commit();
                        break;
                }
                return true;
            }
        });

    }
}