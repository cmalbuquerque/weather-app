package icm.carolina.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApi {

    @GET("/open-data/forecast/meteorology/cities/daily/{localId}.json")
    Call<WeatherPrev> getWeather(@Path("localId") int localId);

    @GET("/open-data/distrits-islands.json")
    Call<WeatherLocal> getLocals();

    @GET("/open-data/weather-type-classe.json")
    Call<WeatherType> getTypesWeather();
}
