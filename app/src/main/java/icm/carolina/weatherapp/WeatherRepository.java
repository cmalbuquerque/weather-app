package icm.carolina.weatherapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class WeatherRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 15;
    private static String BASE_URL = "http://api.ipma.pt/";

    private  WeatherApi weatherApi;
    private  WeatherDao weatherDao;
    private  WeatherRoomDatabase db;
    private  Executor executor;
    private  Retrofit retrofit;

    //LiveData<HashMap<Integer, String>> mapa_locais = new HashMap<>();
    //List<Integer> list_aux = new ArrayList<>();

    public WeatherRepository(Application application) {
        db = WeatherRoomDatabase.getDatabase(application);
        weatherDao = db.weatherDao();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        weatherApi = retrofit.create(WeatherApi.class);

        executor = Executors.newSingleThreadExecutor();

        //saveLocals();


    }

    /*private void saveLocals() {
        executor.execute(() -> {
            weatherApi.getLocals().enqueue(new Callback<WeatherLocal>() {
                @Override
                public void onResponse(Call<WeatherLocal> call, Response<WeatherLocal> response) {
                    executor.execute(() -> {
                        WeatherLocal w = response.body();
                        for (Local l : w.getData()) {
                            mapa_locais.put(l.getGlobalIdLocal(), l);
                            list_aux.add(l.getGlobalIdLocal());
                        }
                    });
                }

                @Override
                public void onFailure(Call<WeatherLocal> call, Throwable t) {
                }
            });
        });
    }*/


    LiveData<List<WeatherPrev>> getAllWeatherLocal() {
        refreshWeather();
        return weatherDao.getAllWeatherLocal();
    }

    /*LiveData<HashMap<Integer, WeatherLocal>> getLocals() {
        saveLocals();
        return mapa_locais;
    }*/


    private void refreshWeather() {
        executor.execute(() -> {
            //for(Integer localId : list_aux) {
                weatherApi.getWeather(1010500).enqueue(new Callback<WeatherPrev>() {
                    @Override
                    public void onResponse(Call<WeatherPrev> call, Response<WeatherPrev> response) {
                        //Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            WeatherPrev w = response.body();
                            w.setLastRefresh(new Date());
                            weatherDao.insert(w);
                        });
                    }

                    @Override
                    public void onFailure(Call<WeatherPrev> call, Throwable t) {
                    }
                });

            //}
            });
    }


    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }

}
