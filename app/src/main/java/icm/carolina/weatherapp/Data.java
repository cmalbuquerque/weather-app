package icm.carolina.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("precipitaProb")
    @Expose
    private String precipitaProb;

    @SerializedName("tMin")
    @Expose
    private String tMin;

    @SerializedName("tMax")
    @Expose
    private String tMax;

    @SerializedName("predWindDir")
    @Expose
    private String predWindDir;

    @SerializedName("idWeatherType")
    @Expose
    private int idWeatherType;

    @SerializedName("classWindSpeed")
    @Expose
    private int classWindSpeed;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("forecastDate")
    @Expose
    private String forecastDate;


    public String getPrecipitaProb() {
        return precipitaProb;
    }

    public void setPrecipitaProb(String precipitaProb) {
        this.precipitaProb = precipitaProb;
    }

    public String gettMin() {
        return tMin;
    }

    public void settMin(String tMin) {
        this.tMin = tMin;
    }

    public String gettMax() {
        return tMax;
    }

    public void settMax(String tMax) {
        this.tMax = tMax;
    }

    public String getPredWindDir() {
        return predWindDir;
    }

    public void setPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
    }

    public int getIdWeatherType() {
        return idWeatherType;
    }

    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public int getClassWindSpeed() {
        return classWindSpeed;
    }

    public void setClassWindSpeed(int classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    @Override
    public String toString() {
        return "{" +
                "precipitaProb='" + precipitaProb + '\'' +
                ", tMin='" + tMin + '\'' +
                ", tMax='" + tMax + '\'' +
                ", predWindDir='" + predWindDir + '\'' +
                ", idWeatherType=" + idWeatherType +
                ", classWindSpeed=" + classWindSpeed +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", forecastDate='" + forecastDate + '\'' +
                '}';
    }
}
