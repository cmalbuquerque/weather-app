package icm.carolina.weatherapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class WeatherRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 15;

    private WeatherApi weatherApi;
    private WeatherDao mWeatherDao;
    private Executor executor;
    private LiveData<List<Weather>> mAllWeather;


    @Inject
    public WeatherRepository(Application application) {
        WeatherRoomDatabase db = WeatherRoomDatabase.getDatabase(application);
        mWeatherDao = db.weatherDao();
        mAllWeather = mWeatherDao.getAllWeather();
    }

    LiveData<List<Weather>> getAllWeather() {
        return mAllWeather;
    }

    public LiveData<Weather> getWeather(int localId) {
        refreshWeather(localId); // try to refresh data if possible from Github Api
        return mWeatherDao.getWeatherFrom(localId); // return a LiveData directly from the database.
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

    private void refreshWeather(final int localId) {
        executor.execute(() -> {
            // Check if user was fetched recently
            boolean userExists = (mWeatherDao.hasWeather(localId, getMaxRefreshTime(new Date())) != null);
            // If user have to be updated
            if (!userExists) {
                weatherApi.getWeather(localId).enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        //Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            Weather weather = response.body();
                            weather.setLastRefresh(new Date());
                            mWeatherDao.saveWeather(weather);
                        });
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) { }
                });
            }
        });
    }

    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}
