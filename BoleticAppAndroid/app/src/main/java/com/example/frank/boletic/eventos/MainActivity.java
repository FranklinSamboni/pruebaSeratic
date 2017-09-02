package com.example.frank.boletic.eventos;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.frank.boletic.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    FrameLayout frameDrawer;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    EventsFragment eventsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        setToolbar();

        eventsFragment = new EventsFragment();
        loadFragment(eventsFragment, "Eventos");

}

    private void getViews(){
        toolbar         = (Toolbar) findViewById(R.id.toolbar_main_activity);
        frameDrawer     = (FrameLayout) findViewById(R.id.content_drawer);
        drawerLayout    = (DrawerLayout) findViewById(R.id.drawer_main_activity);
        navigationView  = (NavigationView) findViewById(R.id.navigation_options_drawer);

        // * Set first option in drawer
        navigationView.setNavigationItemSelectedListener(this);
        //onNavigationItemSelected(navigationView.getMenu().getItem(0).getSubMenu().getItem(0));
    }

    private void setToolbar(){

        setSupportActionBar(toolbar);
        toolbar.setTitle("Boletic");
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setDisplayHomeAsUpEnabled(true);
            }

        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_reservas:
                Toast.makeText(this,"siii",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(this,"asdad",Toast.LENGTH_LONG).show();
                break;
        }

        return false;
    }

    private void loadFragment(Fragment fragment, final String title){
        if (fragment!=null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_drawer,fragment).addToBackStack("tag");
            transaction.commit();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    toolbar.setTitle(title);
                }
            });

        }
    }

}
