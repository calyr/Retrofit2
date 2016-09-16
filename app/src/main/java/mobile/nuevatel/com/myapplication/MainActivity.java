package mobile.nuevatel.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import mobile.nuevatel.com.myapplication.model.Movie;
import mobile.nuevatel.com.myapplication.model.MoviesResponse;
import mobile.nuevatel.com.myapplication.model.Restaurant;
import mobile.nuevatel.com.myapplication.rest.ApiClient;
import mobile.nuevatel.com.myapplication.rest.ApiInterface;
import mobile.nuevatel.com.myapplication.rest.RestInteface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "93688c2e9bb6a56b38f9549963a0c3c8";
    private static final String TAG = MainActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse>call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received = " + movies.size());

                for (int i = 0 ; i < movies.size(); i++){
                    Log.d(TAG, "Number Peli =" + movies.toString());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

        */

        RestInteface apiService =
                ApiClient.getClient2().create(RestInteface.class);

        Call<Restaurant> call = apiService.getRestaurant("json");
        Log.e(TAG,"Numbert2 rr "+ call.toString());
        //BUSCA UN RESTAURANT
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant>call, Response<Restaurant> response) {
               if (response.isSuccessful()){
                   Log.e(TAG,"Numbert2 ok");
                   Restaurant rest = response.body();
                   Log.e(TAG,"Numbert2 ok ="+ rest.getName());

               }else{
                   Log.e(TAG,"Numbert2 nok");

               }
                // Restaurant movies = response.body();
//                Log.d(TAG, "Number of movies received = " + movies.getName());

                /*for (int i = 0 ; i < movies.size(); i++){
                    Log.d(TAG, "Number Peli =" + movies.toString());
                }*/
            }

            @Override
            public void onFailure(Call<Restaurant>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

        //BUSCA TODOS LOS RESTAURANTES
        RestInteface apiService2 =
                ApiClient.getClient2().create(RestInteface.class);
        Log.i(TAG, "Numbert2 SEGUNDA LLAMADA " );

        Call<List<Restaurant>> call2 = apiService2.getListRestaurant("json");
        call2.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                if(response.isSuccessful()){
                    List<Restaurant> lista = response.body();
                    for(int i = 0; i < lista.size(); i++){
                        Log.i(TAG, "Numbert2"+ lista.get(i).getName() );
                    }
                    Log.i(TAG, "Numbert2 IS OK" );
                }else{
                    Log.i(TAG, "Numbert2 NO OK");
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {

            }
        });

    }
}
