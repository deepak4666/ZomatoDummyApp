package saggi.deepak.com.zomatodummyapp.api;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import saggi.deepak.com.zomatodummyapp.commons.NetworkUtil;
import saggi.deepak.com.zomatodummyapp.models.CuisineData;
import saggi.deepak.com.zomatodummyapp.models.ResponseData;
import saggi.deepak.com.zomatodummyapp.models.Restaurant;
import saggi.deepak.com.zomatodummyapp.models.RestaurantData;

import static saggi.deepak.com.zomatodummyapp.api.RetrofitModule.getApiInterface;
import static saggi.deepak.com.zomatodummyapp.api.RetrofitModule.getClient;

public class SearchResturant {
    private Context context;
    private String query;
    private int start;
    private int count;
    private String sort;
    private String order;


    public SearchResturant(Context context, String query, int start, int count, String sort, String order) {
        this.context = context;
        this.query = query;
        this.start = start;
        this.count = count;
        this.sort = sort;
        this.order = order;
    }


    public Single<CuisineData> request() {

            ApiInterface apiService = getApiInterface(getClient());
            Single<CuisineData> observable = apiService.Search(query, start, count, sort, order)
                    .flatMap((Function<ResponseData, SingleSource<CuisineData>>) responseData -> {
                        HashMap<String, List<RestaurantData>> data = new HashMap<>();
                        RestaurantData restaurantData;

                        for (Restaurant restaurant : responseData.getRestaurants()) {
                            restaurantData = restaurant.getRestaurant();
                            for (String cuisine : restaurantData.getCuisines()) {
                                if (data.get(cuisine) == null) {
                                    data.put(cuisine, new ArrayList<>());
                                }
                                data.get(cuisine).add(restaurantData);
                            }
                        }

                        CuisineData cuisineData = new CuisineData(responseData.getResultsFound(),  responseData.getResultsStart(),responseData.getResultsShown(), data);

                        return Single.just(cuisineData);

                    });
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());




    }
}
