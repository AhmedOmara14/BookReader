package tra.wor.bookreader.data;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tra.wor.bookreader.pojo.programming;

public interface apiInterface {
    @GET("volumes")
    public Observable<programming> getbook(@Query("q") String q);

}
