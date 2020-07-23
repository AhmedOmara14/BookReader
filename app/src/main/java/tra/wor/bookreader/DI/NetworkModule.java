package tra.wor.bookreader.DI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
      private String URLpath;

    public NetworkModule(String URLpath) {
        this.URLpath = URLpath;
    }

    @Singleton
    @Provides
    public Gson provideGson(){
        GsonBuilder builder=new GsonBuilder();
        return builder.create();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URLpath)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
