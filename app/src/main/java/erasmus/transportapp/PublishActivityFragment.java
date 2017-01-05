package erasmus.transportapp;

import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A placeholder fragment containing a simple view.
 */
public class PublishActivityFragment extends Fragment implements OnClickListener {

    private SimpleDateFormat dateFormatter;
    private EditText loadDateET;
    private EditText downloadDateET;
    private DatePickerDialog loadDateDialog;
    private DatePickerDialog downloadDateDialog;
    ImageButton loadDateButton;
    ImageButton downloadDateButton;

    public PublishActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_publish, container, false);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        loadDateET= (EditText) view.findViewById(R.id.et_loadDate);
        downloadDateET= (EditText) view.findViewById(R.id.et_downloadDate);

        loadDateButton = (ImageButton) view.findViewById(R.id.btn_loadDate);
        downloadDateButton = (ImageButton) view.findViewById(R.id.btn_downloadDate);
        loadDateButton.setOnClickListener(this);
        downloadDateButton.setOnClickListener(this);

        loadDateDialog = setDataPicker(loadDateET);
        downloadDateDialog = setDataPicker(downloadDateET);

        return view;
    }

    private DatePickerDialog setDataPicker(final EditText fild){
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
    public void onClick(View view){
           if ( view == loadDateButton)
                    loadDateDialog.show();
            else if( view == downloadDateButton)
                    downloadDateDialog.show();
            }
    }