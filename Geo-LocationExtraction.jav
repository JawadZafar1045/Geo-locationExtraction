import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationHelper implements LocationListener {

    private LocationManager locationManager;
    private Context context;

    public LocationHelper(Context context) {
        this.context = context;
    }

    public void fetchLocation() {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Handle permissions if not granted
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // Fetch weather data using the obtained GPS coordinates
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        // Pass latitude and longitude to another method or class for further processing
        processLocation(latitude, longitude);
    }

    private void processLocation(double latitude, double longitude) {
        // Reverse geocoding to get the city name
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        String cityName = ReverseGeocodingHelper.getCityNameFromCoordinates(latitude, longitude, geocoder);

        // Now you have the city name, you can use it as needed
        Log.d("Location", "City Name: " + cityName);
        // You can pass cityName to another method or class for further processing
    }

    // Other methods of LocationListener interface
    // Implement these methods if needed, but they are not required for the specific task

}
