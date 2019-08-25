package com.redcells;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class searchview extends AppCompatActivity {
private TextView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);
        Button srch=(Button) findViewById(R.id.button3);
        final Spinner blood=(Spinner) findViewById(R.id.spinner3);
        final TextView p=findViewById(R.id.spinner4);

            srch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ppp = p.getText().toString();

                    if (ppp.equals("Tap to detect")) {
                        Toast.makeText(getApplicationContext(),"Please select your Location",Toast.LENGTH_SHORT).show();

                    }
                    else {
                        String btype = blood.getSelectedItem().toString();
                        String panc = p.getText().toString();
                        Intent re = new Intent(searchview.this, Search.class);
                        re.putExtra("bt", btype);
                        re.putExtra("pa", panc);
                        startActivity(re);
                    }
                }
            });



        p.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
            } else {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                assert locationManager != null;
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                try {
                    assert location != null;
                    String city = hereLocation(location.getLatitude(), location.getLongitude());
                    p.setText(city);
                    Toast.makeText(searchview.this, "Awesome you're in " + city, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(searchview.this, "Please check if your GPS is turned on or open G-Maps and Position yourself ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    });
}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1000: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    assert locationManager != null;
                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    try {
                        assert location != null;
                        String city = hereLocation(location.getLatitude(),location.getLongitude());
                        p.setText(city);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(searchview.this,"Please check if your GPS is turned on or open G-Maps and Position yourself ",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast t =  Toast.makeText(this,"Permission not Granted",Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            }
        }
    }

    private String hereLocation(double lat, double lon)
    {
        String cityName = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(lat,lon,10);
            if (addresses.size() > 0){
                for(Address adr: addresses){
                    if (adr.getLocality() != null && adr.getLocality().length() > 0){
                        cityName = adr.getLocality();
                        break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return cityName;
    }
}
