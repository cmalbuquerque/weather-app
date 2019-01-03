package icm.carolina.weatherapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WeatherViewModel extends AndroidViewModel {

    private WeatherRepository mRepository;

    private LiveData<List<Weather>> mAllWeather;

    public WeatherViewModel (Application application) {
        super(application);
        mRepository = new WeatherRepository(application);
        mAllWeather = mRepository.getAllWeather();
    }

    LiveData<List<Weather>> getmAllWeather() { return mAllWeather; }

    LiveData<List<Weather>> getWeather(int globalIdLocal) { return mAllWeather; }

    public void saveWeather(Weather weather) { mRepository.saveWeather(weather); }
}
