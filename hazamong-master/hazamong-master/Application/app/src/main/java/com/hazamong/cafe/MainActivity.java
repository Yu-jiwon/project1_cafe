package com.hazamong.cafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private BottomNavigationView mbottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbottomNavigationView = findViewById(R.id.bottomNavigationView);
        // 첫 화면 지정
        getSupportFragmentManager().beginTransaction().add(R.id.bottomNavigationView,new SearchFragment()).commit();

        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId()) {
                        case R.id.action_search: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new SearchFragment()).commit();
                            break;
                        }
                        case R.id.action_qrcognition: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new QrcongFragment()).commit();
                            break;
                        }
                        case R.id.action_mypage: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new MypageFragment()).commit();
                            break;
                        }
                    }
                return true;
            }
        });
    }
}