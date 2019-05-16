package com.examen.methodinjection;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
    @Inject
    public Car() {
        
    }
    
    public void drive(){
        Log.d(TAG, "drive: Driving....");
    }

    //method injection
    @Inject
    public void enableConnected(Remote remote){
        remote.setListener(this);
    }
}
