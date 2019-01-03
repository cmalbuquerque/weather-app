package icm.carolina.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {

    @SerializedName("descIdWeatherTypeEN")
    @Expose
    private String descIdWeatherTypeEN;

    @SerializedName("descIdWeatherTypePT")
    @Expose
    private String descIdWeatherTypePT;

    @SerializedName("idWeatherType")
    @Expose
    private int idWeatherType;

    public Type(String descIdWeatherTypeEN, String descIdWeatherTypePT, int idWeatherType) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
        this.descIdWeatherTypePT = descIdWeatherTypePT;
        this.idWeatherType = idWeatherType;
    }

    public String getDescIdWeatherTypeEN() {
        return descIdWeatherTypeEN;
    }

    public void setDescIdWeatherTypeEN(String descIdWeatherTypeEN) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
    }

    public String getDescIdWeatherTypePT() {
        return descIdWeatherTypePT;
    }

    public void setDescIdWeatherTypePT(String descIdWeatherTypePT) {
        this.descIdWeatherTypePT = descIdWeatherTypePT;
    }

    public int getIdWeatherType() {
        return idWeatherType;
    }

    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    @Override
    public String toString() {
        return "Type{" +
                "descIdWeatherTypeEN='" + descIdWeatherTypeEN + '\'' +
                ", descIdWeatherTypePT='" + descIdWeatherTypePT + '\'' +
                ", idWeatherType=" + idWeatherType +
                '}';
    }
}
