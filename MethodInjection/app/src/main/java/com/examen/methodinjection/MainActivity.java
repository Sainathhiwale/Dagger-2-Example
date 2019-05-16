package com.examen.methodinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;
/*we will learn how to do method injection. By annotating a non-private method with @Inject,
 we tell Dagger to call it as part of the injection process and provide its arguments as dependencies.
  In combination with constructor injection, this happens automatically after the constructor finished.
   Without constructor injection, it happens when the members-injection method is called on the component.
   In both cases, the method (or methods) is called after all @Inject annotated fields are injected.
A use case for method injection is if we want to pass the fully constructed object itself to the
dependency with “this”, so we don’t let it escape from the constructor*/
public class MainActivity extends AppCompatActivity {
    @Inject Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent  = DaggerCarComponent.create();
        carComponent.inject(this);
        car.drive();
    }
}
