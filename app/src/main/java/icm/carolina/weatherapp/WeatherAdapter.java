package icm.carolina.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private final LayoutInflater mInflater;
    private List<Weather> mWeathers; // Cached copy of weathers

    WeatherAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_view_row_main, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        if (mWeathers != null) {
            Weather current = mWeathers.get(position);
            holder.weatherItemView.setText(current.getGlobalIdLocal());
        } else {
            // Covers the case of data not being ready yet.
            holder.weatherItemView.setText("No Weather");
        }
    }

    void setWeather(List<Weather> weather){
        mWeathers = weather;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWeathers != null)
            return mWeathers.size();
        else return 0;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        private final TextView weatherItemView;

        private WeatherViewHolder(View itemView) {
            super(itemView);
            weatherItemView = itemView.findViewById(R.id.textView);
        }
    }
}