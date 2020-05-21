package com.simpad.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity implements LocationListener,GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener {

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private static final int ALL_PREMISSION_RESULT = 1111;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissions = new ArrayList<>();
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);

        permissionsToRequest = permissionsToRequest(permissions);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(permissionsToRequest.size()>0){
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),ALL_PREMISSION_RESULT);
            }
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addOnConnectionFailedListener(this)//Adds a listener to register to receive connection failed events from this GoogleApiClient
                .addConnectionCallbacks(this)//Registers a listener to receive connection events from this GoogleApiClient
                .build();


        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds





    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        checkGooglePlayWorking();

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void checkGooglePlayWorking() {
        int errorCode = GoogleApiAvailability.getInstance()
                .isGooglePlayServicesAvailable(this);
        if (errorCode != ConnectionResult.SUCCESS) {
            Dialog errorDialog = GoogleApiAvailability.getInstance()
                    .getErrorDialog(this, errorCode, errorCode,
                            new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
                                    Toast.makeText(SplashActivity.this, "No services", Toast.LENGTH_SHORT).show();
                                }
                            });
            errorDialog.show();
        } else {
            Toast.makeText(this, "Getting your current location", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                            currentLatitude = location.getLatitude();
                            currentLongitude = location.getLongitude();
                            splash.putExtra("latitude", String.valueOf(currentLatitude));
                            splash.putExtra("longtiude", String.valueOf(currentLongitude));
                            startActivity(splash);
                            finish();
                        }

                    }
                }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SplashActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    private boolean hasPermissions(String perm) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return checkSelfPermission(perm) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private ArrayList<String> permissionsToRequest(ArrayList<String> permissions) {

        ArrayList<String> result = new ArrayList<>();
        for (String perm : permissions) {
            if (!hasPermissions(perm)) {
                result.add(perm);
            }
        }
        return result;

    }

}



































    //        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent splash = new Intent(SplashActivity.this,MainActivity.class);
//                startActivity(splash);
//                finish();
//            }
//        },5000);


