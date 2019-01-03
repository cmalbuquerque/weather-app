package icm.carolina.weatherapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
class WeatherType {

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("data")
    @Expose
    private List<Type> data;

    @PrimaryKey
    @NonNull
    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;

    @SerializedName("dateUpdate")
    @Expose
    private String dateUpdate;


    public WeatherType(String owner, String country, List<Type> data, @NonNull int globalIdLocal, String dateUpdate) {
        this.owner = owner;
        this.country = country;
        this.data = data;
        this.globalIdLocal = globalIdLocal;
        this.dateUpdate = dateUpdate;
    }

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

    public List<Type> getData() {
        return data;
    }

    public void setData(List<Type> data) {
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
        return "WeatherType{" +
                "owner='" + owner + '\'' +
                ", country='" + country + '\'' +
                ", data=" + data +
                ", globalIdLocal=" + globalIdLocal +
                ", dateUpdate='" + dateUpdate + '\'' +
                '}';
    }
}
