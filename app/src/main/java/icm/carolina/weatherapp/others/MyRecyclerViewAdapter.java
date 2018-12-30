package icm.carolina.weatherapp.others;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import icm.carolina.weatherapp.Data;
import icm.carolina.weatherapp.R;
import icm.carolina.weatherapp.Weather;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<Weather> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView distrito, tempMax, tempMin, precipitaProb;
        ImageView actIcon;

        public DataObjectHolder(View itemView) {
            super(itemView);
            distrito = (TextView) itemView.findViewById(R.id.textDistrict);
            tempMax = (TextView) itemView.findViewById(R.id.textTMax);
            tempMin = (TextView) itemView.findViewById(R.id.textTMin);
            precipitaProb = (TextView) itemView.findViewById(R.id.textPrecipita);
            actIcon = (ImageView) itemView.findViewById(R.id.imageViewActivity);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);

        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;

    }

    public MyRecyclerViewAdapter(List<Weather> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row_main, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.distrito.setText(mDataset.get(position).getGlobalIdLocal()+"");
        holder.tempMax.setText(mDataset.get(position).getData().get(0).gettMax() + "ºC");
        holder.tempMin.setText(mDataset.get(position).getData().get(0).gettMin() + "ºC");
        holder.precipitaProb.setText(mDataset.get(position).getData().get(0).getPrecipitaProb() + "%");


        //String aux = (new Date (mDataset.get(position).getDate() * 1000)).toString();
        //String[] data = aux.split(" ");
        //String nova = data[0] + " " + data[2] + " " + data[1] + " " + data[data.length -1] + "\n" + data[3];
        //holder.date.setText(nova);
        //mDataset.get(position).getDate();

    }


    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}