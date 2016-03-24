package kmcbinc.gvdirections;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    private Marker myMarker;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private static final String TAG = "GooglePlayServicesActivity";

    private static final String KEY_IN_RESOLUTION = "is_in_resolution";

    /**
     * Request code for auto Google Play Services error resolution.
     */
    protected static final int REQUEST_CODE_RESOLUTION = 1;

    /**
     * Google API client.
     */
    private GoogleApiClient mGoogleApiClient;

    /**
     * Determines if the client is in a resolution state, and
     * waiting for resolution intent to return.
     */
    private boolean mIsInResolution;

    /**
     * Called when the activity is starting. Restores the activity state.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();

        if (savedInstanceState != null) {
            mIsInResolution = savedInstanceState.getBoolean(KEY_IN_RESOLUTION, false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    // Optionally, add additional APIs and scopes if required.
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        mGoogleApiClient.connect();
    }

    /**
     * Called when activity gets invisible. Connection to Play Services needs to
     * be disconnected as soon as an activity is invisible.
     */
    @Override
    protected void onStop() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }

    /**
     * Saves the resolution state.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IN_RESOLUTION, mIsInResolution);
    }

    /**
     * Handles Google Play Services resolution callbacks.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_RESOLUTION:
                retryConnecting();
                break;
        }
    }

    private void retryConnecting() {
        mIsInResolution = false;
        if (!mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    /**
     * Called when {@code mGoogleApiClient} is connected.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        Log.i(TAG, "GoogleApiClient connected");
        // TODO: Start making API requests.
        LocationRequest req = new LocationRequest();
        req.setInterval (1000); /* every 3 seconds */ //changed to 1000
        req.setFastestInterval (1000); /* how fast our app can handle the notifications */
        req.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates (
                mGoogleApiClient,   /* fill in with the name of your GoogleMap object */
                req,
                this);  /* this class is the LocationListener */
    }

    /**
     * Called when {@code mGoogleApiClient} connection is suspended.
     */
    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(TAG, "GoogleApiClient connection suspended");
        retryConnecting();
    }

    /**
     * Called when {@code mGoogleApiClient} is trying to connect but failed.
     * Handle {@code result.getResolution()} if there is a resolution
     * available.
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());
        if (!result.hasResolution()) {
            // Show a localized error dialog.
            GooglePlayServicesUtil.getErrorDialog(
                    result.getErrorCode(), this, 0, new OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            retryConnecting();
                        }
                    }).show();
            return;
        }
        // If there is an existing resolution error being displayed or a resolution
        // activity has started before, do nothing and wait for resolution
        // progress to be completed.
        if (mIsInResolution) {
            return;
        }
        mIsInResolution = true;
        try {
            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
        } catch (SendIntentException e) {
            Log.e(TAG, "Exception while starting resolution activity", e);
            retryConnecting();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        //LatLng mak = new LatLng(42.966068,-85.886243);
        //mMap.addMarker(new MarkerOptions().position(mak).title("Mackinac Hall"));


        //LatLng kirk =new LatLng(42.96315,-85.88872);
        //mMap.addMarker(new MarkerOptions().position(kirk).title("Kirkoff Center"));

        LatLng AuS = new LatLng(42.963312, -85.885452);
        mMap.addMarker(new MarkerOptions().position(AuS).title("AuSable Hall"));

        LatLng Boat = new LatLng(42.9699,-85.877954);
        mMap.addMarker(new MarkerOptions().position(Boat).title("Boathouse"));

        LatLng Cald = new LatLng(42.961305,-85.883006);
        mMap.addMarker(new MarkerOptions().position(Cald).title("Calder Art Center"));

        LatLng Cook = new LatLng(42.964052,-85.888348);
        mMap.addMarker(new MarkerOptions().position(Cook).title("Cook-DeWitt Center"));

        LatLng Common = new LatLng(42.96608, -85.886714);
        mMap.addMarker(new MarkerOptions().position(Common).title("Commons Building"));

        LatLng Connect = new LatLng(42.959911, -85.888439);
        mMap.addMarker(new MarkerOptions().position(Connect).title("The Connection"));

        LatLng Field = new LatLng(42.967063,-85.889812);
        mMap.addMarker(new MarkerOptions().position(Field).title("Fieldhouse"));

        LatLng Honor = new LatLng(42.96016, -85.88635);
        mMap.addMarker(new MarkerOptions().position(Honor).title("Honors College"));

        LatLng mak = new LatLng(42.964816, -85.888464);
        mMap.addMarker(new MarkerOptions().position(mak).title("Mackinac Hall"));

        LatLng Zum = new LatLng(42.962844,-85.886693);
        mMap.addMarker(new MarkerOptions().position(Zum).title("Zumberge"));

        LatLng kirk = new LatLng(42.96315,-85.88872);
        mMap.addMarker(new MarkerOptions().position(kirk).title("Kirkhof Center"));

        LatLng ScienceHall = new LatLng(42.966212,-85.888526);
        mMap.addMarker(new MarkerOptions().position(ScienceHall).title("P. Kindschi Hall of Science"));

        LatLng Kelly = new LatLng(42.966919,-85.892345);
        mMap.addMarker(new MarkerOptions().position(Kelly).title("Kelly Family Sports Center"));

        LatLng LakeHuron = new LatLng(42.962601,-85.885285);
        mMap.addMarker(new MarkerOptions().position(LakeHuron).title("Lake Huron Hall"));

        LatLng Library = new LatLng(42.963143, -85.889662);
        mMap.addMarker(new MarkerOptions().position(Library).title("Mary Idema Pew Library"));

        LatLng LakeMichigan = new LatLng(42.961298, -85.886208);
        mMap.addMarker(new MarkerOptions().position(LakeMichigan).title("Lake Michigan Hall"));

        LatLng LakeOntario = new LatLng(42.9612,-85.88516);
        mMap.addMarker(new MarkerOptions().position(LakeOntario).title("Lake Ontario Hall"));

        LatLng LakeSuperior = new LatLng(42.962032,-85.886458);
        mMap.addMarker(new MarkerOptions().position(LakeSuperior).title("Lake Superior Hall"));

        LatLng Loutit = new LatLng(42.965126,-85.888271);
        mMap.addMarker(new MarkerOptions().position(Loutit).title("Loutit Lecture Halls"));

        LatLng Man = new LatLng(42.966131,-85.887305);
        mMap.addMarker(new MarkerOptions().position(Man).title("Manitou Hall"));

        LatLng Pac = new LatLng(42.9612,-85.888088);
        mMap.addMarker(new MarkerOptions().position(Pac).title("Performing Arts Center"));

        LatLng Pad = new LatLng(42.965267,-85.887176);
        mMap.addMarker(new MarkerOptions().position(Pad).title("Padnos Hall"));

        LatLng Seid = new LatLng(42.962168,-85.885559);
        mMap.addMarker(new MarkerOptions().position(Seid).title("Seidman House"));

        LatLng StudentServ = new LatLng(42.964453,-85.888703);
        mMap.addMarker(new MarkerOptions().position(StudentServ).title("Student Services Building"));

    }

    @Override
    public void onLocationChanged(Location location) {

        /* fill in the blanks with the incoming parameter of onLocationChanged */
        LatLng geoPos = new LatLng(location.getLatitude(), location.getLongitude());
        LatLng schoolPos = new LatLng(42.963808, -85.887376);
        CameraPosition myPosition = CameraPosition.builder()
                .target(geoPos)
                .zoom(18)
                .build();

        CameraPosition campus = CameraPosition.builder()
                .target(schoolPos)
                .zoom(17)
                .build();
/* zoom level 18: buildings. Smaller number zoom-out, bigger: zoom-in */

/* fill in the blanks with the name of your GoogleMap object */
        //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(campus));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(schoolPos,17 ));
        if (myMarker == null) /* if we don't have a marker yet, create and add */
            myMarker = mMap.addMarker(new MarkerOptions().position(geoPos));
        else
            myMarker.setPosition (geoPos);
    }

}





