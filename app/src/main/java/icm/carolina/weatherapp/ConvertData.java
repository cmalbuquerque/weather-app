package icm.carolina.weatherapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ConvertData {

    static Gson gson = new Gson();

    @TypeConverter
    public static List<Data> stringToList(String data){
        if (data == null)
            return Collections.emptyList();
        Type listType = new TypeToken<List<Data>>(){}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listToString(List<Data> data){
        return gson.toJson(data);
    }

    /*@TypeConverter
    public static Data toData(String precipitaProb, String tMin, String tMax, String predWindDir, int idWeatherType, int classWindSpeed, String longitude, String latitude, String forecastDate) {
        return (precipitaProb == null || tMin == null || tMax == null || predWindDir == null || longitude == null || forecastDate == null || latitude == null)?
                null : new Data(precipitaProb, tMin, tMax, predWindDir, idWeatherType, classWindSpeed, longitude, latitude, forecastDate);
    }
    */

    /*@TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
    */

}
