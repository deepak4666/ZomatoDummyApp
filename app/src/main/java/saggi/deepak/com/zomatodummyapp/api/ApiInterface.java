package saggi.deepak.com.zomatodummyapp.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import saggi.deepak.com.zomatodummyapp.BuildConfig;
import saggi.deepak.com.zomatodummyapp.models.ResponseData;

public interface ApiInterface {

    @Headers("user-key:" + BuildConfig.apiKey)
    @GET("search")
    Single<ResponseData> Search(@Query("q") String searchTxt,
                                @Query("start") int start,
                                @Query("count") int count,
                                @Query("sort") String sort,
                                @Query("order") String order);
}
