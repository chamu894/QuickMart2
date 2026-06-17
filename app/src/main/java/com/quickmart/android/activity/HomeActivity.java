package com.quickmart.android.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.quickmart.android.R;
import com.quickmart.android.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding activityHomeBinding;
    private DrawerLayout drawerLayout;
    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private NavigationView navigationView;

    private View navHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(activityHomeBinding.getRoot());

        this.drawerLayout = activityHomeBinding.main;
        this.toolbar = activityHomeBinding.toolbar;
        this.bottomNavigationView = activityHomeBinding.bottomNavigationView;
        this.navigationView = activityHomeBinding.navigationView;
        this.navHeaderView = activityHomeBinding.navigationView.getHeaderView(0);

        setSupportActionBar(toolbar);

        this.appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,
                R.id.categoriesFragment,
                R.id.wishlistFragment,
                R.id.profileFragment,
                R.id.cartFragment
        )
                .setOpenableLayout(drawerLayout).build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(activityHomeBinding.containerView.getId());

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        NavigationUI.setupActionBarWithNavController(HomeActivity.this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        navHeaderView.findViewById(R.id.headerBackBtn).setOnClickListener(view -> {
            drawerLayout.close();
        });


//        EdgeToEdge.enable(this);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }
}