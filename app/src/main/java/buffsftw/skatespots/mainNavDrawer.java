package buffsftw.skatespots;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.buffsftw.skatespots.R;

import java.io.InputStream;

import buffsftw.skatespots.fragments.spotListFragment;
import buffsftw.skatespots.fragments.mapsFragment;
import buffsftw.skatespots.fragments.profile;
import buffsftw.skatespots.fragments.spotFragment;


import static buffsftw.skatespots.fragments.spotListFragment.*;

public class mainNavDrawer extends AppCompatActivity
        implements profile.OnFragmentInteractionListener, spotFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener,ActivityCompat.OnRequestPermissionsResultCallback, OnListFragmentInteractionListener{
    public OnListFragmentInteractionListener mListener;
    public int REQUEST_LOC = 200;
    public String[] perms = {"android.permission.ACCESS_FINE_LOCATION"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestLocationPermission();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Create null fragment and then default it to Maps
        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = mapsFragment.class;
        //Display fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        setTitle("Map");
        drawer.addDrawerListener(toggle);
        toggle.syncState();



       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        TextView drawer_header = (TextView) navigationView.findViewById(R.id.drawerHeaderTitle);
//        drawer_header.setText("title");
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
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
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
        Fragment fragment = null;
        Class fragmentClass = null;
        Bundle bundle = new Bundle();
        if (id == R.id.nav_map) {
            fragmentClass = mapsFragment.class;
            setTitle("@string/Map");
            requestLocationPermission();
            bundle.putString("attr1", "bla");
        }
        else if (id == R.id.nav_spot_list) {
            fragmentClass = spotListFragment.class;
            setTitle("@string/Spots");
            bundle.putInt("numRows", 5);
        }

        else if (id == R.id.nav_profile) {
            fragmentClass = profile.class;
            setTitle("@string/Profile");
        } else if (id == R.id.nav_manage) {
            fragmentClass = profile.class;
            setTitle("@string/Settings");
        } else if (id == R.id.nav_settings) {
            fragmentClass = profile.class;
            setTitle("@string/Settings");
        } else if (id == R.id.nav_login) {
            fragmentClass = spotFragment.class;
            setTitle("@string/Login");
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance(); // Class type -> newInstance
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // dynamic layout/content handling
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        /*fragmentManager.executePendingTransactions();*/ // ?
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    public void onArticleSelected(int position){

    }
//Runs when spot from spotListFragment is clicked
    //It should replace the fragment with a spotFragment with the information about the spot that was clicked on
    public void onListFragmentInteraction(skateSpots.Spots spots){
        Fragment fragment = null;
        Class fragmentClass = null;
        Bundle bundle = new Bundle();

        fragmentClass = spotFragment.class;
        setTitle("Spot");

        try {
            fragment = (Fragment) fragmentClass.newInstance(); // Class type -> newInstance
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // dynamic layout/content handling
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        /*fragmentManager.executePendingTransactions();*/ // ?
    }

    public void requestLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, perms, REQUEST_LOC);
        }
    }


    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(permsRequestCode, permissions, grantResults);
        switch(permsRequestCode){
            case 200:
                boolean locAccepted = grantResults[0]==PackageManager.PERMISSION_GRANTED;
                break;

        }

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }}