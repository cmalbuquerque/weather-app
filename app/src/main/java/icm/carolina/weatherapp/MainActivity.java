package icm.carolina.weatherapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private WeatherViewModel viewModel;

    TextView city, tMax, tMin, tMax1, tMax2, tMax3, tMax4, tMin1, tMin2, tMin3, tMin4;
    TextView day1, day2, day3, day4, percipitacao, windDir;
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



        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        viewModel.getWeatherLocalLiveData().observe(this, weather -> updateWeather(weather));



    }

    private void updateWeather(@Nullable List<WeatherPrev> weatherPrev){
        if (weatherPrev != null && weatherPrev.size()>0){
            this.city.setText(weatherPrev.get(0).getGlobalIdLocal()+"");
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
        }
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

}
