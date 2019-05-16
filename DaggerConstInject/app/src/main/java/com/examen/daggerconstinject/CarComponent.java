package com.examen.daggerconstinject;

import dagger.Component;

/* We create a new Java interface that we annotate
 with @Component and which has 1 method declaration
 that returns our requested fully instantiated object*/
@Component
public interface CarComponent {

    Car getCar();
}
