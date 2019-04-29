package com.examen.simpledagger.dagger;

import com.examen.simpledagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity mainActivity);
}
