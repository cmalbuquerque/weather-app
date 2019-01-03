package icm.carolina.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.List;



@Dao
public interface WeatherDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherPrev weatherPrev);

    @Query("SELECT * from WeatherPrev ORDER BY globalIdLocal ASC")
    LiveData<List<WeatherPrev>> getAllWeatherLocal();

    @Query("SELECT * from WeatherLocal ORDER BY globalIdLocal ASC")
    LiveData<List<WeatherLocal>> getLocal();


    @Query("SELECT * FROM WeatherPrev WHERE lastRefresh > :lastRefreshMax LIMIT 1")
    WeatherPrev hasWeather(Date lastRefreshMax);
}
