package examplecompany.gmap;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import examplecompany.gmap.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setOnMarkerClickListener(this);

        // Add a marker in Sydney and move the camera
        LatLng Location = new LatLng(-34, 151);
        String MarkerTitle = "Zeljko Cupac";

        AddMarker(Location, MarkerTitle);

    }

    public void AddMarker(LatLng Location, String MarkerTitle) {

        Marker MyMarker = mMap.addMarker(new MarkerOptions().position(Location).title(MarkerTitle));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Location));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 15.0f ) );

    }

    public boolean onMarkerClick(Marker marker) {

        String name= marker.getTitle();

        if (name.equalsIgnoreCase("Zeljko Cupac"))
        {
            //this.setContentView(R.layout.pit_information_form);
            Intent intent = new Intent(this, PitInformationForm.class);
            startActivity(intent);
        }

        return true;
    }
}
