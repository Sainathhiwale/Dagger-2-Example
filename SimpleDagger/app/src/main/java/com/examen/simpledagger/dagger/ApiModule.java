package com.examen.simpledagger.dagger;

import com.examen.simpledagger.Application;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
  String mBaseUrl;

  public ApiModule(String mBaseUrl){
      this.mBaseUrl = mBaseUrl;
  }

  @Provides
    @Singleton
    Cache provideHttpCache(Application application){
      int cachesize = 10 * 1024 * 1024; // this is 10MB
      Cache caches = new Cache(application.getCacheDir(),cachesize);
      return caches;
  }
  @Provides
    @Singleton
    Gson provideGson(){
      GsonBuilder  gsonBuilder = new GsonBuilder();
      gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
      return  gsonBuilder.create();
  }

  @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache){
      OkHttpClient.Builder client = new OkHttpClient.Builder();
      client.cache(cache);
      return client.build();
  }
  @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson,OkHttpClient okHttpClient){
      return new Retrofit.Builder()
              .addConverterFactory(GsonConverterFactory.create(gson))
              .baseUrl(mBaseUrl)
              .client(okHttpClient)
              .build();
  }
}
