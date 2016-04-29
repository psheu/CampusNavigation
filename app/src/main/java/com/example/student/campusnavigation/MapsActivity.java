package com.example.student.campusnavigation;


import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int REQUEST_FINE_LOCATION = 11;
    private GoogleMap mMap;


    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();
        mDrawerLayout.closeDrawers();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }



    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    private void addDrawerItems() {
        String[] osArray = { "Alumni House","Arnold Fine Arts Annex","Bellarmine Hall","BVM Hall",
                "Campion Hall","Canisius Hall","Centennial Forum","Coffey Hall",
                "Crown Center","Cudahy Library","Cudahy Science Hall", "Cuneo Hall",
                "Damen Student Center","de Nobili Hall","Dumbach Hall","Fairfield Hall",
                "Flanner Hall","Fordham Hall","Gentile Arena","Georgetown Hall",
                "Granada Center","Halas Sports Center","Ignatius House",
                "Institute of Environmental Sustainability","International House",
                "Klarchek Information Commons","LeMoyne Hall", "Madonna della Strada Chapel",
                "Marquette Hall", "Marquette South", "Mertz Hall", "Messina Hall",
                "Mundelein Center", "Norville Athletics Center", "Piper Hall",
                "Quinlan Life Sciences Building", "Regis Hall", "San Francisco Hall",
                "Santa Clara Hall", "Seattle Hall", "Simpson Hall", "Spring Hill Hall",
                "Sullivan Center", "Xavier Hall"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

                mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (mMap != null) {
                            mMap.clear();
                        }
                        switch (position) {
                            case 0:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996831, -87.658709)).title("Alumni House")).showInfoWindow();
                                break;
                            case 1:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997924, -87.658709)).title("Arnold Fine Arts Annex")).showInfoWindow();
                                break;
                            case 2:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.003183, -87.661064)).title("Bellarmine Hall")).showInfoWindow();
                                break;
                            case 3:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998059, -87.656646)).title("BVM Hall")).showInfoWindow();
                                break;
                            case 4:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.002059, -87.660208)).title("Campion Hall")).showInfoWindow();
                                break;
                            case 5:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995984, -87.657364)).title("Canisius Hall")).showInfoWindow();
                                break;
                            case 6:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.001301, -87.659900)).title("Centennial Forum")).showInfoWindow();
                                break;
                            case 7:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998919, -87.655802)).title("Coffey Hall")).showInfoWindow();
                                break;
                            case 8:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.001344, -87.656512)).title("Crown Center")).showInfoWindow();
                                break;
                            case 9:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000767, -87.656875)).title("Cudahy Library")).showInfoWindow();
                                break;
                            case 10:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999885, -87.657843)).title("Cudahy Science Hall")).showInfoWindow();
                                break;
                            case 11:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999213, -87.657273)).title("Cuneo Hall")).showInfoWindow();
                                break;
                            case 12:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000527, -87.660019)).title("Damen Student Center")).showInfoWindow();
                                break;
                            case 13:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997812, -87.657537)).title("de Nobili Hall")).showInfoWindow();
                                break;
                            case 14:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000427, -87.657842)).title("Dumbach Hall")).showInfoWindow();
                                break;
                            case 15:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995649, -87.658770)).title("Fairfield Hall")).showInfoWindow();
                                break;
                            case 16:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998546, -87.658278)).title("Flanner Hall")).showInfoWindow();
                                break;
                            case 17:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999712, -87.660317)).title("Fordham Hall")).showInfoWindow();
                                break;
                            case 18:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000648, -87.659118)).title("Gentile Arena")).showInfoWindow();
                                break;
                            case 19:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996763, -87.656535)).title("Georgetown Hall")).showInfoWindow();
                                break;
                            case 20:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999655, -87.660282)).title("Grenada Center")).showInfoWindow();
                                break;
                            case 21:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999646, -87.659472)).title("Halas Sports Center")).showInfoWindow();
                                break;
                            case 22:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997332, -87.657401)).title("Ignatius House")).showInfoWindow();
                                break;
                            case 23:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997741, -87.656651)).title("Institute of Environmental Sustainability")).showInfoWindow();
                                break;
                            case 24:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995952, -87.658773)).title("International House")).showInfoWindow();
                                break;
                            case 25:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000178, -87.656301)).title("Klarchek Information Commons")).showInfoWindow();
                                break;
                            case 26:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996654, -87.658770)).title("LeMoyne Hall")).showInfoWindow();
                                break;
                            case 27:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.999555, -87.656262)).title("Madonna della Strada Chapel")).showInfoWindow();
                                break;
                            case 28:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996190, -87.656642)).title("Marquette Hall")).showInfoWindow();
                                break;
                            case 29:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995897, -87.656639)).title("Marquette South")).showInfoWindow();
                                break;
                            case 30:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.001250, -87.659604)).title("Mertz Hall")).showInfoWindow();
                                break;
                            case 31:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995384, -87.658017)).title("Messina Hall")).showInfoWindow();
                                break;
                            case 32:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998780, -87.656609)).title("Mundelein Center")).showInfoWindow();
                                break;
                            case 33:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.000540, -87.658957)).title("Norville Athletic Center")).showInfoWindow();
                                break;
                            case 34:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998679, -87.655532)).title("Piper Hall")).showInfoWindow();
                                break;
                            case 35:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.998673, -87.657769)).title("Quinlan Life Science Building")).showInfoWindow();
                                break;
                            case 36:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997818, -87.658921)).title("Regis Hall")).showInfoWindow();
                                break;
                            case 37:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997020, -87.656826)).title("San Francisco Hall")).showInfoWindow();
                                break;
                            case 38:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(42.001873, -87.656610)).title("Santa Clara Hall")).showInfoWindow();
                                break;
                            case 39:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996792, -87.657920)).title("Seattle Hall")).showInfoWindow();
                                break;
                            case 40:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997651, -87.658228)).title("Simpson Hall")).showInfoWindow();
                                break;
                            case 41:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.995017, -87.658072)).title("Spring Hill Hall")).showInfoWindow();
                                break;
                            case 42:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.997813, -87.655049)).title("Sullivan Center")).showInfoWindow();
                                break;
                            case 43:
                                mMap.addMarker(new MarkerOptions().position(new LatLng(41.996708, -87.658100)).title("Xavier Hall")).showInfoWindow();
                                break;
                        }
                        if (mDrawerLayout != null) {
                            mDrawerLayout.closeDrawers();
                        }
                    }
                });
    }



    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Buildings");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng loyola = new LatLng(41.9993, -87.659);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loyola, (float) 15.5));
        if (checkPermissions()) {
            setMyLocationEnabled();
        }



    }
    /*
    public void onCameraChange(CameraPosition position) {
        double maxZoom = 15.5;
        if (position.zoom > maxZoom) {
            mMap.animateCamera(CameraUpdateFactory.zoomTo((float) maxZoom));
        }
    }*/



    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissions();
            return false;
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_FINE_LOCATION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setMyLocationEnabled();
                } else {
                }
            }
        }
    }


    private void setMyLocationEnabled() {
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
            }
        });
    }




}
