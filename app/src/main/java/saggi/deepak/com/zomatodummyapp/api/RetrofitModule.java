package saggi.deepak.com.zomatodummyapp.api;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import saggi.deepak.com.zomatodummyapp.BuildConfig;

public class RetrofitModule {


    public static ApiInterface getApiInterface(Retrofit retroFit) {
        return retroFit.create(ApiInterface.class);
    }

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.apiHost)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }


    private static OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient;
        if (BuildConfig.DEBUG) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout((long) (2), TimeUnit.MINUTES)
                    .addInterceptor(getHttpLoggingInterceptor())
                    .build();
        } else {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout((long) (2), TimeUnit.MINUTES)
                    .build();
        }

        return okHttpClient;
    }


    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
