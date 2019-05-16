package com.examen.daggerfieldinjection;

import dagger.Component;

@Component
public interface CarComponent {

    void inject(MainActivity mainActivity);
}
