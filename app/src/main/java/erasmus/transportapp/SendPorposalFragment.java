package erasmus.transportapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //SendPorposalFragment.//OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SendPorposalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SendPorposalFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SimpleDateFormat dateFormatter;
    private EditText loadDateET;
    private EditText downloadDateET;
    private DatePickerDialog loadDateDialog;
    private DatePickerDialog downloadDateDialog;
    private SeekBar priceBar;
    private ImageButton loadDateButton;
    private ImageButton downloadDateButton;
    private EditText proposalDetails;

    public SendPorposalFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SendPorposalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendPorposalFragment newInstance(String param1, String param2) {
        SendPorposalFragment fragment = new SendPorposalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_send_porposal, container, false);

        final TextView price = (TextView) view.findViewById(R.id.tv_priceNumber);
        priceBar = (SeekBar) view.findViewById(R.id.sb_price);
        priceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                price.setText("$" + Integer.toString(progress+50));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)  {
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
        loadDateButton.setOnClickListener(this);
        downloadDateButton.setOnClickListener(this);
        loadDateDialog = setDataPicker(loadDateET);
        downloadDateDialog = setDataPicker(downloadDateET);

        proposalDetails = (EditText) view.findViewById(R.id.et_proposalDetails);

        Button sendProposal = (Button) getActivity().findViewById(R.id.btn_sendPorposal);
        sendProposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkProposal())
                    Toast.makeText(getActivity(),"Esto enviará la propuesta al usuario, pero aun no :D ",Toast.LENGTH_LONG).show();
            }
        });
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
        }
        else if (view == downloadDateButton) {
            downloadDateDialog.show();
        }
    }

    private boolean checkProposal(){
        try{
            if(loadDateET.getText().length()==0) throw new Exception("LoadDate no especificada");
            if(downloadDateET.getText().length()==0) throw new Exception("DownloadDate no especificada");
            if(proposalDetails.getText().length()==0) throw new Exception("Detalles de publicacion no especificados");

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Falta alguno de los elementos requeridos",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


}
