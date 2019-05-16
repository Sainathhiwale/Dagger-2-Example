package com.examen.daggerconstinject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/*
* Component and method  and constructor @Inject annotation
* We create a new Java interface that we annotate with @Component and which has 1 method declaration thatreturns our requested fully instantiated object.
* Dagger will then at compile time generate the implementation for this so-called provision method so we can use it in our activity. In order for this to work, we have to tell
 Dagger how to create all the necessary dependencies. One way of doing this is with the help of constructor injection, for which we have to annotate all the constructors Dagger has to know about with @Inject. This javax annotation is standardized under JSR 330.
Dagger will then internally generate a directed acyclic graph (DAG) that contains all the dependencies in the correct order. For this, it doesn’t use any Java reflection like earlier dependency injection frameworks (like Spring, Guice or Dagger 1).*/
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
     Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent carComponent = DaggerCarComponent.create();
        car = carComponent.getCar();
        car.run();
        Log.d(TAG, "onCreate: ");
    }
}
