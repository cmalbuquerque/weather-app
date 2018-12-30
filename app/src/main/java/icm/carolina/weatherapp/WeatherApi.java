package icm.carolina.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApi {

    String BASE_URL = "http://api.ipma.pt/";

    @GET("/open-data/forecast/meteorology/cities/daily/{localId}.json")
    Call<Weather> getWeather(@Path("localId") int localId);

    @GET("open-data/distrits-islands.json")
    Call<Local> getLocais();
}
