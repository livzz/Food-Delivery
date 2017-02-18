package com.foodypark.foodypark.RestAPI;

import com.foodypark.foodypark.restaurant.RestaurantsInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by ALiBH on 2/18/2017.
 */

public interface FoodyParkAPI {
    @Headers("x-api-key: uraAFT8mNG1cDqcwvo5ZQ937OffSpZVt1jZWpYzO")
    @GET("restaurantlist")
    Call<RestaurantsInfo> getRestaurants(@Path("name") String name);
}
