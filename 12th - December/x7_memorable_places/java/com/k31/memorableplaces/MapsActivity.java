package com.k31.memorableplaces;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<String> places;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();

        places = intent.getStringArrayListExtra("places");

        System.out.println(places + "-----------this is on create");

//        Intent intentMe = getIntent();
//        String[] myStrings = intentMe.getStringArrayExtra("strings");
//
//        System.out.println(myStrings + "--------------------------------");

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                String address = "Can't load address";
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.ENGLISH);
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (listAddresses != null && listAddresses.size() > 0) {
                        System.out.println(listAddresses.get(0).getAdminArea()+"----------this is admin");
                        System.out.println(listAddresses.get(0).getLocality()+"----------this is locality");
                        System.out.println(listAddresses.get(0).getThoroughfare()+"----------this is thoroughfare");
                        System.out.println(listAddresses.get(0).getPostalCode()+"----------this is postal code");


                        address = "Address: ";
                        if (listAddresses.get(0).getThoroughfare() != null) {
                            address += listAddresses.get(0).getThoroughfare() + " ";
                        }

                        if (listAddresses.get(0).getLocality() != null) {
                            address += listAddresses.get(0).getLocality() + " ";
                        }

                        if (listAddresses.get(0).getPostalCode() != null) {
                            address += listAddresses.get(0).getPostalCode() + " ";
                        }

                        if (listAddresses.get(0).getAdminArea() != null) {
                            address += listAddresses.get(0).getAdminArea();
                        }

                        System.out.println(address);
                        places.add(address);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                mMap.addMarker(new MarkerOptions().position(latLng).title(address));
                //System.out.println(latLng.latitude + "----------" + latLng.longitude);
                //System.out.println("here's whole address------" + address);
                System.out.println("added one address-----------" + places);



            }
        });

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


//        gm.setOnMapLongClickListener(this);
//
//        @Override
//        public void onMapLongClick(LatLng point) {
//            gm.addMarker(new MarkerOptions()
//                    .position(point)
//                    .title("You are here")
//                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//        }
    }
}