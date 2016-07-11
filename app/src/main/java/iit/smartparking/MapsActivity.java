package iit.smartparking;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import android.support.v4.content.ContextCompat;
import android.util.Log;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_CONTACTS;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_READ_LOCTION = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_LOCTION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_LOCTION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    onMapReady(mMap);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
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
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        try{
            mMap.setMyLocationEnabled(true);
        }catch (SecurityException e){

        }



        PolygonOptions senthran = new PolygonOptions()
                .add(new LatLng(6.865437, 79.860857),
                        new LatLng(6.865501, 79.861176),
                        new LatLng(6.865157, 79.861275),
                        new LatLng(6.865088, 79.860953),
                        new LatLng(6.865437, 79.860857)).
                        strokeColor(Color.DKGRAY)
                .fillColor(Color.rgb(0,150,136))
        ;
        Polygon polygon = mMap.addPolygon(senthran);

        LatLng senthu = new LatLng(6.865293, 79.860991);

        //mMap.addMarker(new MarkerOptions().position(senthu).title(productViewActivity.data.get(0) + " Slots Available"));

        //  try {
        Marker m1 =(mMap.addMarker(new MarkerOptions().position(senthu).title("Ramakrishna Road, Colombo 06").snippet(1 + " SLOTS AVAILABLE")));




        mMap.moveCamera(CameraUpdateFactory.newLatLng(senthu));
        //CameraUpdateFactory.zoomTo();
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);

        /*--------------------------------------------------------------------------------------------*/

        PolygonOptions gowthamy = new PolygonOptions()
                .add(new LatLng(6.864876, 79.860883),
                        new LatLng(6.864847, 79.860701),
                        new LatLng(6.865119, 79.860629),
                        new LatLng(6.865175, 79.860782),
                        new LatLng(6.864876, 79.860883)).
                        strokeColor(Color.DKGRAY)
                .fillColor(Color.rgb(0,150,136))
        ;
        mMap.addPolygon(gowthamy);

        LatLng gowtham = new LatLng(6.864986, 79.860728);

        //  try{
        Marker m2 =(mMap.addMarker(new MarkerOptions().position(gowtham).title("Ramakrishna Place, Colombo 06").snippet(2+ " SLOTS AVAILABLE")));

        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(gowtham));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);

        /*--------------------------------------------------------------------------------------------*/

        PolygonOptions sahana = new PolygonOptions()
                .add(new LatLng(6.865684, 79.859486),
                        new LatLng(6.865767, 79.859931),
                        new LatLng(6.865402, 79.860020),
                        new LatLng(6.865346, 79.859631),
                        new LatLng(6.865684, 79.859486)).
                        strokeColor(Color.DKGRAY)
                .fillColor(Color.rgb(0,150,136))
        ;
        mMap.addPolygon(sahana);

        LatLng sahan = new LatLng(6.865546, 79.859752);

        //   try{
        Marker m3 =(mMap.addMarker(new MarkerOptions().position(sahan).title("TESTING LOCATION").snippet(" SLOTS AVAILABLE")));

        //   mMap.moveCamera(CameraUpdateFactory.newLatLng(sahan));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);

        /*--------------------------------------------------------------------------------------------*/

        PolygonOptions thiloshon = new PolygonOptions()
                .add(new LatLng(6.864762, 79.859699),
                        new LatLng(6.864829, 79.860093),
                        new LatLng(6.864517, 79.860208),
                        new LatLng(6.864472, 79.859886),
                        new LatLng(6.864762, 79.859699)).
                        strokeColor(Color.DKGRAY)
                .fillColor(Color.rgb(0,150,136))
        ;
       // mMap.addPolygon(thiloshon);

        LatLng thilo = new LatLng(6.864658, 79.859991);

        //  try {
       // Marker m4 =(mMap.addMarker(new MarkerOptions().position(thilo).title("TESTING LOCATION").snippet(LoginActivity.data.get(3) + " SLOTS AVAILABLE")));

        /*mMap.moveCamera(CameraUpdateFactory.newLatLng(thilo));
        */




    }








    /*if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
        mMap.setMyLocationEnabled(true);
    } else {
        // Show rationale and request permission.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST_CODE);
            mMap.setMyLocationEnabled(true);
        }

    }*/

    /*@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == android.Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST_CODE);
                    }
                    return;
                }
                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }

    }*/

}