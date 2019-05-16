package com.examen.methodinjection;

import dagger.Component;

@Component
public interface CarComponent {

  void inject(MainActivity mainActivity);
}
