package com.examen.simpledagger;

import com.examen.simpledagger.dagger.ApiComponent;
import com.examen.simpledagger.dagger.ApiModule;
import com.examen.simpledagger.dagger.AppModule;
import com.examen.simpledagger.dagger.DaggerApiComponent;

public class Application extends android.app.Application {
   private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("http://fakerestapi.azurewebsites.net/api/"))
                .build();

    }
    public ApiComponent getNetComponent(){
        return mApiComponent;
    }
}
