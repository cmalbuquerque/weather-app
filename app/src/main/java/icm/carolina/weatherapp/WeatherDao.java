package icm.carolina.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;


import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface WeatherDao {

    @Insert(onConflict = REPLACE)
    void saveWeather(Weather weather);


    @Query("SELECT * FROM weather WHERE globalIdLocal = :globalIdLocal")
    LiveData<Weather> getWeatherFrom(int globalIdLocal);


    @Query("SELECT * from weather ORDER BY globalIdLocal ASC")
    LiveData<List<Weather>> getAllWeather();


    @Query("SELECT * FROM weather WHERE globalIdLocal = :globalIdLocal AND lastRefresh > :lastRefreshMax LIMIT 1")
    Weather hasWeather(int globalIdLocal, Date lastRefreshMax);
}
