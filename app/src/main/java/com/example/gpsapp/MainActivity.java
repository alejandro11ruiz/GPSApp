package com.example.gpsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtLatitud, txtLongitud, txtRadio;
    Button btnCoor, btnAqui;
    public static double lat, lon;
    public static float rad;
    public static boolean tipe;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.editLatitud);
        txtLongitud = findViewById(R.id.editLongitud);
        txtRadio = findViewById(R.id.editRadio);
        btnCoor = findViewById(R.id.buttonCoord);
        btnAqui = findViewById(R.id.buttonAqui);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }

        btnCoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lat = Double.parseDouble(txtLatitud.getText().toString());
                lon = Double.parseDouble(txtLongitud.getText().toString());
                rad = Float.parseFloat(txtRadio.getText().toString());
                tipe = true;
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


        btnAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rad = Float.parseFloat(txtRadio.getText().toString());
                tipe=false;
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

    }

}