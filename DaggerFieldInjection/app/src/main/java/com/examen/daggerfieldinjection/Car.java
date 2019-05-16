package com.examen.daggerfieldinjection;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
    @Inject
    public Car() {
    }
    
    public void run(){
        Log.d(TAG, "run: Car is running");
    }
}
