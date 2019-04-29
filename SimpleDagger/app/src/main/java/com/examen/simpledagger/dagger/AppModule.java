package com.examen.simpledagger.dagger;

import com.examen.simpledagger.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
 private Application mApplication;

 public AppModule(Application mApplication){
     this.mApplication=mApplication;
 }
 @Provides
 @Singleton
    Application provideApplication(){
     return mApplication;
 }

}
