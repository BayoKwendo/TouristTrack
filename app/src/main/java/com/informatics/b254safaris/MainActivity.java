package com.informatics.b254safaris;

import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private TextView mTextMessage;
    private static final String TAG = "MainActivity";

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {

//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mTextMessage = findViewById(R.id.message);

        mBottomNavigationView = findViewById(R.id.Bottom_navigation_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mBottomNavigationView.setSelectedItemId(R.id.navigation_home);
//        // The above sets the main section when the application is launched

    }

    Discover discoverFragment = new Discover();
    Home homeFragment = new Home();
    Profile profileFragment = new Profile();
    Search searchFragment = new Search();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){
           case R.id.navigation_home:
               getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
               return true;

           case R.id.navigation_search:
               getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
               return true;

           case R.id.navigation_discover:
               getSupportFragmentManager().beginTransaction().replace(R.id.container, discoverFragment).commit();
               return true;

           case R.id.navigation_profile:
               getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
               return true;
       }

        return false;
    }
}
