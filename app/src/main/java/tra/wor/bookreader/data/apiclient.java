package tra.wor.bookreader.data;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tra.wor.bookreader.pojo.programming;

public class apiclient {

    private static apiclient instance;
    private String url = "https://www.googleapis.com/books/v1/";
    apiInterface apiInterface;

    public apiclient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiInterface=retrofit.create(apiInterface.class);
    }

    public static apiclient getInstance() {
        if (instance==null){
            instance=new apiclient();
        }
        return instance;
    }

    public Observable<programming> getbooks(String item){
        return apiInterface.getbook(item);
    }
}
