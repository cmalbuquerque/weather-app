package icm.carolina.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Weather {

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("data")
    @Expose
    private ArrayList<Data> data;

    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;

    @SerializedName("dateUpdate")
    @Expose
    private String dateUpdate;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public int getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "owner='" + owner + '\'' +
                ", country='" + country + '\'' +
                ", data=" + data +
                ", globalIdLocal=" + globalIdLocal +
                ", dateUpdate='" + dateUpdate + '\'' +
                '}';
    }
}
