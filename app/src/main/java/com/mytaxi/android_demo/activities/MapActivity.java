package com.mytaxi.android_demo.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.adapters.DriverAdapter;
import com.mytaxi.android_demo.utils.PermissionHelper;

import javax.inject.Inject;

import static com.mytaxi.android_demo.misc.Constants.DEFAULT_LOCATION;
import static com.mytaxi.android_demo.misc.Constants.DEFAULT_ZOOM;

public class MapActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private Boolean mLocationPermissionGranted = false;

    private FusedLocationProviderClient mFusedLocationProviderClient;
    private BitmapDescriptor mIconMarker;
    private Location mLastKnownLocation;
    private AutoCompleteTextView mSearchView;
    private DriverAdapter mAdapter;
    private static final String KEY_LOCATION = "location";

    private static final String TAG = "MapActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    }



}
