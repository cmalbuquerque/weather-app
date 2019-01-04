package icm.carolina.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;



@Dao
public interface WeatherDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherPrev weatherPrev);

    @Query("SELECT * from WeatherPrev ORDER BY globalIdLocal ASC")
    LiveData<List<WeatherPrev>> getAllWeatherLocal();

    @Query("SELECT * from WeatherPrev WHERE WeatherPrev.globalIdLocal = :globalIdLocal")
    LiveData<WeatherPrev> getWeatherPrevison(int globalIdLocal);

    @Query("SELECT * FROM WeatherPrev WHERE lastRefresh > :lastRefreshMax LIMIT 1")
    boolean hasWeather(Date lastRefreshMax);

    //@Insert (onConflict = OnConflictStrategy.REPLACE)
    //void insert(Local local);

    //@Query("SELECT * FROM weatherlocal")
    //LiveData<List<Local>> getAllLocals ();


    //@Insert (onConflict = OnConflictStrategy.REPLACE)
    //void insert(Type type);

    //@Query("SELECT * from WeatherType WHERE WeatherType.globalIdLocal = :idWeatherType")
    //LiveData<String> getWeatherType(int idWeatherType);


    //@Query("SELECT localidade from WeatherPrev WHERE WeatherPrev.globalIdLocal = :globalIdLocal")
    //LiveData<String> getLocalidade(int globalIdLocal);



}
