package com.example.navigationdrawertemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class SecondActivity extends DrawerController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //this method above will now call the one in super , i.e the DrawerController
    }
}