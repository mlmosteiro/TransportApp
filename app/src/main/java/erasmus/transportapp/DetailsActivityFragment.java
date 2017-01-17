package erasmus.transportapp;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Locale;

import model.Announcement;
import model.ShipmentAnnouncements;
import model.TransportAnnouncements;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {
    private Announcement announcement;

    private SimpleDateFormat dateFormatter;
    private TextView loadDateTV;
    private TextView downloadDateTV;
    private TextView originTV;
    private TextView destinationTV;
    private TextView priceTV;
    private TextView vehicleDetails;
    private TextView vehicleDetailsLabel;
    private TextView description;
    private ImageView imageType;

    private MapView mMapView;
    private GoogleMap googleMap;

    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);

        Bundle args = getArguments();
        this.announcement = Contents.getInstance().getAnnouncementsList().get(args.getInt(Contents.ANNOUNCEMENT_POSSITION));

        //Price
        priceTV = (TextView) view.findViewById(R.id.tv_priceNumber);
        priceTV.setText(String.format("$%s", Integer.toString(announcement.getPrice())));

        //Image type
        imageType = (ImageView) view.findViewById(R.id.iv_type);
        imageType.setImageResource(announcement.getType().getSrcImage());

        //Load Date
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        loadDateTV = (TextView) view.findViewById(R.id.tv_loadDate);
        loadDateTV.setText(dateFormatter.format(announcement.getLoadDate()));

        //Download date
        downloadDateTV = (TextView) view.findViewById(R.id.tv_downloadDate);
        downloadDateTV.setText(dateFormatter.format(announcement.getDownloadDate()));

        //Origin
        originTV = (TextView) view.findViewById(R.id.tv_origin);
        originTV.setText(announcement.getOrigin().getName());

        //Destination
        destinationTV = (TextView) view.findViewById(R.id.tv_destination);
        destinationTV.setText(announcement.getDestination().getName());

        //Vehicle Details
        vehicleDetails = (TextView) view.findViewById(R.id.tv_vehicleDetails);
        if (announcement instanceof TransportAnnouncements) {
            vehicleDetailsLabel = (TextView) view.findViewById(R.id.tv_vehicleDetailsLabel);
            vehicleDetailsLabel.setVisibility(View.GONE);
            vehicleDetails.setVisibility(View.GONE);
            vehicleDetails.setText("");
        } else {
            vehicleDetailsLabel = (TextView) view.findViewById(R.id.tv_vehicleDetailsLabel);
            vehicleDetailsLabel.setVisibility(View.VISIBLE);
            vehicleDetails.setVisibility(View.VISIBLE);
            vehicleDetails.setText("");
            //TODO: Arreglar esto :(
            //    vehicleDetails.setText((TransportAnnouncements) announcement.getVhDetails());
        }

        description = (TextView) view.findViewById(R.id.tv_publicationDetails);
        description.setText(announcement.getDescription());

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        setMap(mMapView);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    private void setMap(MapView mMapView) {


        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map

                googleMap.addMarker(new MarkerOptions().position(announcement.getOrigin().getLatLng()).title(announcement.getOrigin().getName()));
                googleMap.addMarker(new MarkerOptions().position(announcement.getDestination().getLatLng()).title(announcement.getDestination().getName()));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(announcement.getOrigin().getLatLng()).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
    }

}