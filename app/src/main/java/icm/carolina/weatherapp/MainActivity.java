package icm.carolina.weatherapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private WeatherViewModel viewModel;

    TextView city, tMax, tMin, tMax1, tMax2, tMax3, tMax4, tMin1, tMin2, tMin3, tMin4;
    TextView day1, day2, day3, day4, percipitacao, windDir, estadoTempo, localidade;
    ImageView imgTempo1, imgTempo2,imgTempo3,imgTempo4;
    Spinner spinner;

    List<String> locaisList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** ToolBar **/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        city = (TextView) findViewById(R.id.titleMain);
        tMax = (TextView) findViewById(R.id.tempMax);
        tMin = (TextView) findViewById(R.id.tempMin);
        tMax1 = (TextView) findViewById(R.id.tempMax1);
        tMin1 = (TextView) findViewById(R.id.tempMin2);
        tMax2 = (TextView) findViewById(R.id.tempMax2);
        tMin2 = (TextView) findViewById(R.id.tempMin3);
        tMax3 = (TextView) findViewById(R.id.tempMax3);
        tMin3 = (TextView) findViewById(R.id.tempMin3);
        tMax4 = (TextView) findViewById(R.id.tempMax4);
        tMin4 = (TextView) findViewById(R.id.tempMin4);
        day1 = (TextView) findViewById(R.id.day1);
        day2 = (TextView) findViewById(R.id.day2);
        day3 = (TextView) findViewById(R.id.day3);
        day4 = (TextView) findViewById(R.id.day4);
        percipitacao = (TextView) findViewById(R.id.probPrecipita);
        windDir = (TextView) findViewById(R.id.windDir);
        estadoTempo = (TextView) findViewById(R.id.estadoTempo);
        localidade = (TextView) findViewById(R.id.localAtual);

        imgTempo1 = (ImageView) findViewById(R.id.tempoImage1);
        imgTempo2 = (ImageView) findViewById(R.id.tempoImage2);
        imgTempo3 = (ImageView) findViewById(R.id.tempoImage3);
        imgTempo4 = (ImageView) findViewById(R.id.tempoImage4);


        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        //viewModel.getLocalidadeLiveData().observe(this, local -> updateLocalidade(local));
        viewModel.getWeatherLocalLiveData().observe(this, weather -> updateWeather(weather));



    }

    private void updateLocalidade(String local) {
        if(local != null)
            this.localidade.setText(local);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void updateWeather(@Nullable List<WeatherPrev> weatherPrev){
        if (weatherPrev != null && weatherPrev.size()>0){
            this.city.setText("Aveiro");
            this.tMax.setText(weatherPrev.get(0).getData().get(0).gettMax()+"º");
            this.tMin.setText(weatherPrev.get(0).getData().get(0).gettMin()+"º");
            this.windDir.setText(weatherPrev.get(0).getData().get(0).getPredWindDir());
            this.percipitacao.setText(weatherPrev.get(0).getData().get(0).getPrecipitaProb()+"%");

            this.tMax1.setText(weatherPrev.get(0).getData().get(1).gettMax()+"º");
            this.tMin1.setText(weatherPrev.get(0).getData().get(1).gettMin()+"º");
            this.tMax2.setText(weatherPrev.get(0).getData().get(2).gettMax()+"º");
            this.tMin2.setText(weatherPrev.get(0).getData().get(2).gettMin()+"º");
            this.tMax3.setText(weatherPrev.get(0).getData().get(3).gettMax()+"º");
            this.tMin3.setText(weatherPrev.get(0).getData().get(3).gettMin()+"º");
            this.tMax4.setText(weatherPrev.get(0).getData().get(4).gettMax()+"º");
            this.tMin4.setText(weatherPrev.get(0).getData().get(4).gettMin()+"º");
            this.day2.setText(weatherPrev.get(0).getData().get(2).getForecastDate());
            this.day3.setText(weatherPrev.get(0).getData().get(3).getForecastDate());
            this.day4.setText(weatherPrev.get(0).getData().get(4).getForecastDate());


            this.estadoTempo.setText(weatherPrev.get(0).getEstadoTempo());
            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==1 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==2)
                this.imgTempo1.setImageResource(R.drawable.ic_wb_sunny_black_24dp);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==1 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==2)
                this.imgTempo2.setImageResource(R.drawable.ic_wb_sunny_black_24dp);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==1 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==2)
                this.imgTempo3.setImageResource(R.drawable.ic_wb_sunny_black_24dp);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==1 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==2)
                this.imgTempo4.setImageResource(R.drawable.ic_wb_sunny_black_24dp);

            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==3)
                this.imgTempo1.setImageResource(R.drawable.daycloudy);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==3)
                this.imgTempo2.setImageResource(R.drawable.daycloudy);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==3)
                this.imgTempo3.setImageResource(R.drawable.daycloudy);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==3)
                this.imgTempo4.setImageResource(R.drawable.daycloudy);

            int[] list = {6,7,8,9,10,11,12,13,14,15};
            for(int id: list) {
                if (weatherPrev.get(0).getData().get(1).getIdWeatherType() == id)
                    this.imgTempo1.setImageResource(R.drawable.raindrops_blue);
                if (weatherPrev.get(0).getData().get(2).getIdWeatherType() == id)
                    this.imgTempo2.setImageResource(R.drawable.raindrops_blue);
                if (weatherPrev.get(0).getData().get(3).getIdWeatherType() == id)
                    this.imgTempo3.setImageResource(R.drawable.raindrops_blue);
                if (weatherPrev.get(0).getData().get(4).getIdWeatherType() == id)
                    this.imgTempo4.setImageResource(R.drawable.raindrops_blue);
            }

            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==4 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==5 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==27 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==25)
                this.imgTempo1.setImageResource(R.drawable.ic_cloud_black_24dp);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==4 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==5 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==27 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==25)
                this.imgTempo2.setImageResource(R.drawable.ic_cloud_black_24dp);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==4 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==5 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==27 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==25)
                this.imgTempo3.setImageResource(R.drawable.ic_cloud_black_24dp);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==4 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==5 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==27 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==25)
                this.imgTempo4.setImageResource(R.drawable.ic_cloud_black_24dp);

            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==22 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==21 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==18 )
                this.imgTempo1.setImageResource(R.drawable.ic_ac_unit_black_24dp);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==22 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==21 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==18)
                this.imgTempo2.setImageResource(R.drawable.ic_ac_unit_black_24dp);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==22 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==21 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==18)
                this.imgTempo3.setImageResource(R.drawable.ic_ac_unit_black_24dp);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==22 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==21 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==18)
                this.imgTempo4.setImageResource(R.drawable.ic_ac_unit_black_24dp);

            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==16 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==17 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==26)
                this.imgTempo1.setImageResource(R.drawable.fog);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==16 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==17 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==26)
                this.imgTempo2.setImageResource(R.drawable.fog);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==16 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==17 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==26)
                this.imgTempo3.setImageResource(R.drawable.fog);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==16 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==17 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==26)
                this.imgTempo4.setImageResource(R.drawable.fog);

            if(weatherPrev.get(0).getData().get(1).getIdWeatherType()==23 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==20 || weatherPrev.get(0).getData().get(1).getIdWeatherType()==19)
                this.imgTempo1.setImageResource(R.drawable.storm);
            if(weatherPrev.get(0).getData().get(2).getIdWeatherType()==23 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==20 || weatherPrev.get(0).getData().get(2).getIdWeatherType()==19)
                this.imgTempo2.setImageResource(R.drawable.storm);
            if(weatherPrev.get(0).getData().get(3).getIdWeatherType()==23 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==20 || weatherPrev.get(0).getData().get(3).getIdWeatherType()==19)
                this.imgTempo3.setImageResource(R.drawable.storm);
            if(weatherPrev.get(0).getData().get(4).getIdWeatherType()==23 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==20 || weatherPrev.get(0).getData().get(4).getIdWeatherType()==19)
                this.imgTempo4.setImageResource(R.drawable.storm);

            /*for(int i = 1; i<5; i++){
                if(weatherPrev.get(0).getData().get(i).getIdWeatherType()==1){

                }

            }
            */

            //this.localidade.setText(weatherPrev.get(0).getLocalidade());
        }

    }

}
