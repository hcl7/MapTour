package com.example.seven.mapapi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

public class MapAPI extends FragmentActivity implements OnMapReadyCallback{

    Context context;
    private GoogleMap mMap;
    final float zoomLevel = 9;
    String fid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_api);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //getDirectionsUrl(mapdata);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.296663, 20.018167), zoomLevel));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        Toast toast = Toast.makeText(getApplicationContext(), "Loading Map Application Locations!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        MarkerOptions options = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.markericon));
        ArrayList<MarkerData> mapdata = new ArrayList<MarkerData>();

        Integer[] Cities = {
                R.string.Benc,
                R.string.Gusmar,
                R.string.Kuc,
                R.string.Corraj,
                R.string.Borsh,
                R.string.Nivice,
                R.string.Doshnice,
                R.string.Dragot,
                R.string.Fushebardhe,
                R.string.Golem,
                R.string.Hoshteve,
                R.string.Kaparjel,
                R.string.Koncke,
                R.string.Kudhes,
                R.string.Lekdush,
                R.string.Leskaj,
                R.string.Nivan,
                R.string.Peshtan,
                R.string.Polican,
                R.string.Progonat,
                R.string.Qeparo,
                R.string.Sarande,
                R.string.Selenice,
                R.string.Sheper,
                R.string.Skore,
                R.string.Sopik,
                R.string.Tepelene,
                R.string.Zhulat,
        };

        final String[] CityName = {
                "Benc",
                "Gusmar",
                "Kuc",
                "Corraj",
                "Borsh",
                "Nivice",
                "Doshnice",
                "Dragot",
                "Fushebardhe",
                "Golem",
                "Hoshteve",
                "Kaparjel",
                "Koncke",
                "Kudhes",
                "Lekdush",
                "Leskaj",
                "Nivani",
                "Peshtan",
                "Polican",
                "Progonat",
                "Qeparo",
                "Sarande",
                "Selenice",
                "Sheper",
                "Skore",
                "Sopik",
                "Tepelene",
                "Zhulat",
        };

        String[] asset_files = {
                "Benc.html",
                "Gusmar.html",
                "Kuc.html",
                "Corraj.html",
                "Borsh.html",
                "Nivice.html",
                "Doshnice.html",
                "Dragot.html",
                "Fushebardhe.html",
                "Golem.html",
                "Hoshteve.html",
                "Kaparjel.html",
                "Koncke.html",
                "Kudhes.html",
                "Lekdush.html",
                "Leskaj.html",
                "Nivan.html",
                "Peshtan.html",
                "Polican.html",
                "Progonat.html",
                "Qeparo.html",
                "Sarande.html",
                "Senice.html",
                "Sheper.html",
                "Skore.html",
                "Sopik.html",
                "Tepelene.html",
                "Zhulat.html",
        };

        final String[] txt_files = {
                "latlng1.txt",
                "latlng2.txt",
                "latlng3.txt",
                "latlng4.txt",
                "latlng5.txt",
                "latlng6.txt",
                "latlng7.txt",
                "latlng8.txt",
        };

        mapdata.add(new MarkerData(new LatLng(40.255369, 20.005513), CityName[0], getResources().getString(Cities[0])));
        mapdata.add(new MarkerData(new LatLng(40.222320, 19.891631), CityName[1], getResources().getString(Cities[1])));
        mapdata.add(new MarkerData(new LatLng(40.175935, 19.839529), CityName[2], getResources().getString(Cities[2])));
        mapdata.add(new MarkerData(new LatLng(40.114524, 19.864248), CityName[3], getResources().getString(Cities[3])));
        mapdata.add(new MarkerData(new LatLng(40.055712, 19.850859), CityName[4], getResources().getString(Cities[4])));
        mapdata.add(new MarkerData(new LatLng(40.236593, 19.896534), CityName[5], getResources().getString(Cities[5])));
        mapdata.add(new MarkerData(new LatLng(40.236246, 20.215088), CityName[6], getResources().getString(Cities[6])));
        mapdata.add(new MarkerData(new LatLng(40.289528, 20.068044), CityName[7], getResources().getString(Cities[7])));
        mapdata.add(new MarkerData(new LatLng(40.099836, 19.998813), CityName[8], getResources().getString(Cities[8])));
        mapdata.add(new MarkerData(new LatLng(40.170088, 19.936288), CityName[9], getResources().getString(Cities[9])));
        mapdata.add(new MarkerData(new LatLng(40.218873, 20.248223), CityName[10], getResources().getString(Cities[10])));
        mapdata.add(new MarkerData(new LatLng(40.134569, 19.951322), CityName[11], getResources().getString(Cities[11])));
        mapdata.add(new MarkerData(new LatLng(40.194530, 20.279126), CityName[12], getResources().getString(Cities[12])));
        mapdata.add(new MarkerData(new LatLng(40.102909, 19.819442), CityName[13], getResources().getString(Cities[13])));
        mapdata.add(new MarkerData(new LatLng(40.222368, 19.960107), CityName[14], getResources().getString(Cities[14])));
        mapdata.add(new MarkerData(new LatLng(40.246434, 20.192750), CityName[15], getResources().getString(Cities[15])));
        mapdata.add(new MarkerData(new LatLng(40.180050, 20.292902), CityName[16], getResources().getString(Cities[16])));
        mapdata.add(new MarkerData(new LatLng(40.289129, 20.124624), CityName[17], getResources().getString(Cities[17])));
        mapdata.add(new MarkerData(new LatLng(40.131153, 20.350453), CityName[18], getResources().getString(Cities[18])));
        mapdata.add(new MarkerData(new LatLng(40.212746, 19.945220), CityName[19], getResources().getString(Cities[19])));
        mapdata.add(new MarkerData(new LatLng(40.053751, 19.829117), CityName[20], getResources().getString(Cities[20])));
        mapdata.add(new MarkerData(new LatLng(39.859212, 20.027100), CityName[21], getResources().getString(Cities[21])));
        mapdata.add(new MarkerData(new LatLng(40.011316, 20.003853), CityName[22], getResources().getString(Cities[22])));
        mapdata.add(new MarkerData(new LatLng(40.169761, 20.305562), CityName[23], getResources().getString(Cities[23])));
        mapdata.add(new MarkerData(new LatLng(40.107286, 20.365139), CityName[24], getResources().getString(Cities[24])));
        mapdata.add(new MarkerData(new LatLng(40.086267, 20.412803), CityName[25], getResources().getString(Cities[25])));
        mapdata.add(new MarkerData(new LatLng(40.296663, 20.018167), CityName[26], getResources().getString(Cities[26])));
        mapdata.add(new MarkerData(new LatLng(40.120165, 19.988392), CityName[27], getResources().getString(Cities[27])));


        Log.d("array size", Integer.toString(mapdata.size()));

        for (int i=0;i<mapdata.size();i++){
            options.position(mapdata.get(i).getLatLng());
            options.title(mapdata.get(i).getTitle());
            //options.icon(BitmapDescriptorFactory.fromResource(getResources().getInteger(mapdata.get(i).getBitmap())));
            options.snippet(mapdata.get(i).getDescription());
            mMap.addMarker(options);
            options.visible(true);
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String title = marker.getTitle().toString();
                Log.d("Title", title);
                for (int c = 0;c < CityName.length;c++){
                    if (CityName[c].equals(title)){
                        fid = Integer.toString(c);
                    }
                }
                startActivity(new Intent(MapAPI.this, CitiesDesc.class).putExtra("fid", fid));
                return false;
            }
        });

        /*readFromTxtFile(txt_files[0]);
        readFromTxtFile(txt_files[1]);
        readFromTxtFile(txt_files[2]);
        readFromTxtFile(txt_files[3]);
        readFromTxtFile(txt_files[4]);
        readFromTxtFile(txt_files[5]);
        readFromTxtFile(txt_files[6]);
        readFromTxtFile(txt_files[7]);*/

        //getDirectionsUrl(mapdata);

    }

    private void readFromTxtFile(String file){
        ArrayList<LatLng> latLng = new ArrayList<LatLng>();
        String line;
        double lat;
        double lng;
        LatLng latLngTemp;
        MarkerOptions option = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.markericon));
        try {
            InputStream is = getAssets().open(file);
            InputStreamReader input = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(input);
            if (!br.ready()) {
                throw new IOException();
            }
            while((line = br.readLine()) != null){
                String[] tmplatlng = line.split(",");
                lat = Double.parseDouble(tmplatlng[0]);
                lng = Double.parseDouble(tmplatlng[1]);
                latLngTemp = new LatLng(lat, lng);
                latLng.add(latLngTemp);
            }
            br.close();
            for (int i=0;i<latLng.size()-1;i++){
                option.position(latLng.get(i));
                //mMap.addMarker(option);
                option.visible(false);
            }
            getRoadByLatLng(latLng);
        }
        catch (IOException e){
            Log.e("IOExepation: ", e.getMessage());
        }
    }

    private void getDirectionsUrl(ArrayList<MarkerData> md) {
        PolylineOptions rectOptions = new PolylineOptions();
        rectOptions.color(Color.argb(255, 85, 166, 27));

        LatLng startLatLng = null;
        LatLng endLatLng = null;
        for (int i = 0; i < md.size(); i++) {
            if (i == 0) {
                startLatLng = md.get(i).getLatLng();
            }
            if (i == md.size() - 1) {
                endLatLng = md.get(i).getLatLng();
            }
            rectOptions.add(md.get(i).getLatLng());
        }
        mMap.addPolyline(rectOptions);
    }

    private void getRoadByLatLng(ArrayList<LatLng> md) {
        PolylineOptions rectOptions = new PolylineOptions();
        rectOptions.color(Color.argb(255, 255, 0, 0));

        LatLng startLatLng = null;
        LatLng endLatLng = null;
        for (int i = 0; i < md.size(); i++) {
            if (i == 0) {
                startLatLng = md.get(i);
            }
            if (i == md.size() - 1) {
                endLatLng = md.get(i);
            }
            rectOptions.add(md.get(i));
        }
        mMap.addPolyline(rectOptions);
    }
}

class MarkerData {
    LatLng latLng;
    String title;
    int bitmap;
    String description;

    MarkerData(LatLng _latLng, String _title, String _description){
        this.latLng = _latLng;
        this.title = _title;
        this.description = _description;
    }
    public LatLng getLatLng() {
        return this.latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return this.description;
    }
}
