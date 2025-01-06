package com.example.instaapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.instaapplication.ui.home.HomeFragment;
import com.example.instaapplication.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.instaapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);


        Toolbar tool  = findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        ImageView cam =  tool.findViewById(R.id.camera);
        LinearLayout linearlayout = findViewById(R.id.linearFirst);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "camera on", Toast.LENGTH_SHORT).show();
            }
        });

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.navigation_home){
                    NotificationsFragment homeFragment = new NotificationsFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container,homeFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(item.getItemId() == R.id.search){
                    Toast.makeText(MainActivity.this,"search feature coming soon",Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.user){

//                    if (linearlayout != null) {
//                        linearlayout.setVisibility(View.GONE); // Hides the LinearLayout
//                    }
                    userAccFragment user = new userAccFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, user);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                return true;

                //learning android
            }
        });
    }

}
