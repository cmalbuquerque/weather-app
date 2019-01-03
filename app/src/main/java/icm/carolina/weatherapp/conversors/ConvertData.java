package icm.carolina.weatherapp.conversors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import icm.carolina.weatherapp.Data;

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

}
