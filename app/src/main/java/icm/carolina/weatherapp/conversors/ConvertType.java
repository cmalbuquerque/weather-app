package icm.carolina.weatherapp.conversors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ConvertType {

    static Gson gson = new Gson();

    @TypeConverter
    public static List<icm.carolina.weatherapp.Type> stringToList(String data){
        if (data == null)
            return Collections.emptyList();
        Type listType = new TypeToken<List<icm.carolina.weatherapp.Type>>(){}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listToString(List<icm.carolina.weatherapp.Type> data){
        return gson.toJson(data);
    }
}
