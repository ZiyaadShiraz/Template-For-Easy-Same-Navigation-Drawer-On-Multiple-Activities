package com.example.navigationdrawertemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//ALL ACTIVITIES THAT WANTS TO HAVE THE NAVIGATION DRAWER MUST EXTEND THIS CLASS INSTEAD OF ACTIVITY OR APPCOMPAT
public class MainActivity extends DrawerController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecondActivity(View view){
        Intent intent = new Intent (this, SecondActivity.class);
        startActivity(intent);
    }
}