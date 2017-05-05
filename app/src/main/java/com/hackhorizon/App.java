package com.hackhorizon;

import android.app.Application;

import com.hackhorizon.dagger.AppModule;
import com.hackhorizon.dagger.NetComponent;
import com.hackhorizon.dagger.NetModule;

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = com.hackhorizon.dagger.DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://www.jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}