package com.examen.myapplication;

import android.app.Application;

public class App extends Application {
 private static App app;
 private MemberAppComponent memberAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        app=this;
        memberAppComponent = DaggerMemberAppComponent.builder()
                    .memberDataModule(new MemberDataModule())
                    .build();
    }

    public static App getApp() {
        return app;
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }
}
