package com.example.simplegps;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
	 
    // Google Map
    private GoogleMap googleMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
        	
        	//googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        	
        	
        	SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
        			.findFragmentById(R.id.map);

        	googleMap = mapFrag.getMap();
        	
        	
        	
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            
            // latitude and longitude
            double latitude = 43.7000;
            double longitude = -79.4000;
            // create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps ");
            // adding marker
            googleMap.addMarker(marker);
            
            // latitude and longitude
            double latitude2 = 0;
            double longitude2 = 0;
            // create marker
            MarkerOptions marker2 = new MarkerOptions().position(new LatLng(latitude2, longitude2)).title("Hello Maps ");
             
            // adding marker
            googleMap.addMarker(marker2);
            
            
            
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(12).build();
     
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
            
            googleMap.getUiSettings().setZoomControlsEnabled(false); // true to enable
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            
            googleMap.setMyLocationEnabled(true);
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
 
}

