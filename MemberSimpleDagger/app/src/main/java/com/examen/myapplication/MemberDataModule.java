package com.examen.myapplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//MemberDataModule data object is dependecies for mainactivity
@Module
public class MemberDataModule {
    /* Include @Singleton or other scope related annotation before the declaration
    of a method which provides dependencies(if considering scope is important for the project only) */

    /*Include @Provides annotation before the declaration of a
    method which provides dependencies (required objects). */

    @Provides
    @Singleton
    MemberDataManager provideMemberDataManager() {
        return new MemberDataManager();


    }
}
