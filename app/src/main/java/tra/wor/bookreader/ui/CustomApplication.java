package tra.wor.bookreader.ui;

import android.app.Application;

import tra.wor.bookreader.DI.DaggerNetworkComponent;
import tra.wor.bookreader.DI.NetworkComponent;
import tra.wor.bookreader.DI.NetworkModule;

public class CustomApplication extends Application {
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
       networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule("https://www.googleapis.com/books/v1/"))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
