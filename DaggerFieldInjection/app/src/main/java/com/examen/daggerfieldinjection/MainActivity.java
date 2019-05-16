package com.examen.daggerfieldinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

/*we will learn how to do field injection. By annotating a non-private, non-final member variable with @Inject,
 we tell Dagger to set its value by referencing it directly. Field injection is mainly used to inject variables
  into Android framework types that the system instantiates and on which we can’t do constructor injection,
 like activities, BroadcastReceivers and fragments*/
public class MainActivity extends AppCompatActivity {
    @Inject Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent carComponent = DaggerCarComponent.create();
        carComponent.inject(this);
        car.run();
    }
}
