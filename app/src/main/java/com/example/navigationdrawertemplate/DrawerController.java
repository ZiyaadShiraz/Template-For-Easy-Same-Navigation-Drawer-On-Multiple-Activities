package com.example.navigationdrawertemplate;

import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerController extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    NavigationView navigationView;
    Toolbar toolbar;


//    SO ALL CALLS TO SETCONTENT IN THE ACTIVITIES ARE ACTUALLY RUNNING THE SET CONTENT BELOW. WE JUST PASS IN THE LAYOUT OF THE ACTIVITY, AND EVENTUALLY ADD IT TO THE FRAMELAYOUT IN dr
    @Override
    public void setContentView(int layoutResourceID ) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.drawer_layout, null);//THIS ALLOWS US ACCESS TO THE IDS IN THE DRAWER LAYOUT
        navigationView = drawerLayout.findViewById(R.id.nav_view);
        toolbar = drawerLayout.findViewById(R.id.toolbar);
        frameLayout = drawerLayout.findViewById(R.id.activity_content);

//        this next line is to inject what was passed into the frame layout.
        getLayoutInflater().inflate(layoutResourceID,frameLayout,true);

        //now the content is set using the drawer layout which has the frame layout, which was injected with the layout passed in the activity.
        setContentView(drawerLayout);

        //YOU CAN PUT THE CONTENTS OF SET NAV DRAWER HERE. JUST SEPARATED IT TO CLEAN UP
        setUpNavDrawer();
    }


//    TO CLOSE THE NAVIGATION DRAWER WHEN THE BACK BUTTON IS PRESSED.
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    public void setUpNavDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();

        //use this to add listeners on click.
//        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }

}
