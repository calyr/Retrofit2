package mobile.nuevatel.com.myapplication.rest;

import java.util.List;

import mobile.nuevatel.com.myapplication.model.Restaurant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by callisaya on 9/16/16.
 */
public interface RestInteface {
    @GET("restaurants/restaurant/4")
    Call<Restaurant> getRestaurant(@Query("_format") String format);

    @GET("restaurants")
    Call<List<Restaurant>> getListRestaurant(@Query("_format") String format);


}
