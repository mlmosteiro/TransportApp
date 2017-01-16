package erasmus.transportapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * A placeholder fragment containing a simple view.
 */
public class PublishActivityFragment extends Fragment implements OnClickListener, RadioGroup.OnCheckedChangeListener {

    private SimpleDateFormat dateFormatter;
    private RadioGroup radioGroup;
    private EditText loadDateET;
    private EditText downloadDateET;
    private DatePickerDialog loadDateDialog;
    private DatePickerDialog downloadDateDialog;
    private SeekBar priceBar;
    private ImageButton loadDateButton;
    private ImageButton downloadDateButton;
    private ImageButton originButton;
    private ImageButton destinationButton;
    private TextView originTV;
    private TextView destinationTV;
    private TextView vehicleDetailsLabel;
    private EditText vehicleDetails;

    int PLACE_PICKER_REQUEST_ORIGIN = 1;
    int PLACE_PICKER_REQUEST_DESTINATION = 2;

    public PublishActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_publish, container, false);

        radioGroup = (RadioGroup) view.findViewById(R.id.rb_group);
        radioGroup.setOnCheckedChangeListener(this);

        final TextView price = (TextView) view.findViewById(R.id.tv_priceNumber);
        priceBar = (SeekBar) view.findViewById(R.id.sb_price);
        priceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                price.setText("$" + Integer.toString(progress+50));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                price.setTextColor(Color.RED);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                price.setTextColor(Color.BLACK);
            }
        });

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        loadDateET = (EditText) view.findViewById(R.id.et_loadDate);
        downloadDateET = (EditText) view.findViewById(R.id.et_downloadDate);
        loadDateButton = (ImageButton) view.findViewById(R.id.btn_loadDate);
        downloadDateButton = (ImageButton) view.findViewById(R.id.btn_downloadDate);
        originButton = (ImageButton) view.findViewById(R.id.btn_origin);
        destinationButton = (ImageButton) view.findViewById(R.id.btn_destination);
        originTV = (TextView) view.findViewById(R.id.tv_originText);
        destinationTV = (TextView) view.findViewById(R.id.tv_destinationText);
        vehicleDetailsLabel = (TextView) view.findViewById(R.id.tv_vehicleDetailsLabel);
        vehicleDetails = (EditText) view.findViewById(R.id.et_vehicleDetails);

        Spinner type = (Spinner) view.findViewById(R.id.spinner_type);

        loadDateButton.setOnClickListener(this);
        downloadDateButton.setOnClickListener(this);
        loadDateDialog = setDataPicker(loadDateET);
        downloadDateDialog = setDataPicker(downloadDateET);
        originButton.setOnClickListener(this);
        destinationButton.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);

        return view;
    }

    private DatePickerDialog setDataPicker(final EditText fild) {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fild.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        return datePickerDialog;
    }

    @Override
    public void onClick(View view) {
        if (view == loadDateButton) {
            loadDateDialog.show();
        } else if (view == downloadDateButton) {
            downloadDateDialog.show();
        } else if ( view == originButton) {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try {
                startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST_ORIGIN);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }else if ( view == destinationButton){
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try {
                startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST_DESTINATION);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId)        {
            case R.id.rb_carrier:
                vehicleDetailsLabel.setVisibility(View.VISIBLE);
                vehicleDetails.setVisibility(View.VISIBLE);
                vehicleDetails.setText("");
                break;
            case R.id.rb_shipper:
                vehicleDetailsLabel.setVisibility(View.GONE);
                vehicleDetails.setVisibility(View.GONE);
                vehicleDetails.setText("shipper");
                break;
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST_ORIGIN) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getActivity());
                originTV.setText(place.getName());
                String toastMsg = String.format("Place: %s , %s", place.getName(), place.getAddress());
                //TODO quitar esto si no hace falta :D
                Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();


            }
        }
        else if (requestCode == PLACE_PICKER_REQUEST_DESTINATION) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getActivity());
                destinationTV.setText(place.getName());
                String toastMsg = String.format("Place: %s , %s", place.getName(), place.getAddress());
                //TODO quitar esto si no hace falta :D
                Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();


            }
        }
    }
}

