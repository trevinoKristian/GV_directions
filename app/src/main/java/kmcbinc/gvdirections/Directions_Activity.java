package kmcbinc.gvdirections;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Directions_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions_);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /* code from: http://www.joellipman.com/articles/google/android/application-development/basic-android-app-using-google-maps-and-current-location.html */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker").snippet("Snippet"));

        // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // set map type
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));
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
        Map locLatLon = new HashMap();
        locLatLon.put("AuSable Hall",	new LatLng(42.963312,-85.885452));
        locLatLon.put("Boathouse", new LatLng(42.9699,-85.877954));
        locLatLon.put("Calder Art Center", new LatLng(42.961305,-85.883006));
        locLatLon.put("Cook-DeWitt Center", new LatLng(42.964052,-85.888348));
        locLatLon.put("Commons Building", new LatLng(42.96608, -85.886714));
        locLatLon.put("The Connection", new LatLng(42.959911, -85.888439));
        locLatLon.put("Fieldhouse", new LatLng(42.967063,-85.889812));
        locLatLon.put("Honors College", new LatLng(42.96016, -85.88635));
        locLatLon.put("Henry Hall", new LatLng(42.964816, -85.888464));
        locLatLon.put("Zumberge", new LatLng(42.962844,-85.886693));
        locLatLon.put("Kirkhof Center", new LatLng(42.96315,-85.88872));
        locLatLon.put("P. Kindschi Hall of Science", new LatLng(42.966212,-85.888526));
        locLatLon.put("Kelly Family Sports Center", new LatLng(42.966919,-85.892345));
        locLatLon.put("Lake Huron Hall", new LatLng(42.962601,-85.885285));
        locLatLon.put("Mary Idema Pew Library", new LatLng(42.963143, -85.889662));
        locLatLon.put("Lake Michigan Hall", new LatLng(42.961298, -85.886208));
        locLatLon.put("Lake Ontario Hall", new LatLng(42.9612,-85.88516));
        locLatLon.put("Lake Superior Hall", new LatLng(42.962032,-85.886458));
        locLatLon.put("Loutit Lecture Halls", new LatLng(42.965126,-85.888271));
        locLatLon.put("Mackinac Hall", new LatLng(42.966068,-85.886243));
        locLatLon.put("Manitou Hall", new LatLng(42.966131,-85.887305));
        locLatLon.put("Performing Arts Center", new LatLng(42.9612,-85.888088));
        locLatLon.put("Padnos Hall", new LatLng(42.965267,-85.887176));
        locLatLon.put("Seidman House", new LatLng(42.962168,-85.885559));
        locLatLon.put("Student Services Building", new LatLng(42.964453,-85.888703));


        // Add a marker in Sydney and move the camera
        //LatLng mak = new LatLng(42.9664369,-85.8888817);
        //mMap.addMarker(new MarkerOptions().position(mak).title("Mackinac Hall"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mak));

        // iterates through map of title, lat/lon pairs and plots them on the google map
        Iterator it = locLatLon.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            mMap.addMarker(new MarkerOptions().position((LatLng)pair.getValue()).title((String) pair.getKey()));
            it.remove(); // avoids a ConcurrentModificationException
        }
        this.setUpMap();
    }
}
