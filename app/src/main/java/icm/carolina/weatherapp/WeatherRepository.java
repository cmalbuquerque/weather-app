package icm.carolina.weatherapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WeatherRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 15;

    private WeatherApi weatherApi;
    private WeatherDao mWeatherDao;
    private LiveData<List<Weather>> mAllWeather;


    public WeatherRepository(Application application) {
        WeatherRoomDatabase db = WeatherRoomDatabase.getDatabase(application);
        mWeatherDao = db.weatherDao();
        mAllWeather = mWeatherDao.getAllWeather();
    }

    LiveData<List<Weather>> getAllWeather() {
        return mAllWeather;
    }

    public void saveWeather (Weather weather) {
        new insertAsyncTask(mWeatherDao).execute(weather);
    }

    private static class insertAsyncTask extends AsyncTask<Weather, Void, Void> {

        private WeatherDao mAsyncTaskDao;

        insertAsyncTask(WeatherDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Weather... params) {
            mAsyncTaskDao.saveWeather(params[0]);
            return null;
        }
    }
}
