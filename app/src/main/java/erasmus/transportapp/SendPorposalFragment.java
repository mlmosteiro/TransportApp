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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import model.Announcement;


public class SendPorposalFragment extends Fragment implements View.OnClickListener {

    private ImageView userImage;
    private TextView userName;
    private SimpleDateFormat dateFormatter;
    private EditText loadDateET;
    private EditText downloadDateET;
    private DatePickerDialog loadDateDialog;
    private DatePickerDialog downloadDateDialog;
    private SeekBar priceBar;
    private ImageButton loadDateButton;
    private ImageButton downloadDateButton;
    private EditText proposalDetails;

    private Announcement announcement;


    public SendPorposalFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        this.announcement = Contents.getInstance().getAnnouncementsList().get(args.getInt(Contents.ANNOUNCEMENT_POSSITION));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_send_porposal, container, false);

        //User
        userImage = (ImageView) view.findViewById(R.id.iv_avatarUser);
        userName = (TextView) view.findViewById(R.id.tv_userName);
        userName.setText(announcement.getUser().getName());

        //Price
        final TextView price = (TextView) view.findViewById(R.id.tv_priceNumber);
        priceBar = (SeekBar) view.findViewById(R.id.sb_price);
        priceBar.setProgress(announcement.getPrice());
        price.setText(String.format("$%s", announcement.getPrice()));
        priceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                price.setText(String.format("$%s", Integer.toString(progress + 50)));
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

        //Load date
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        loadDateET = (EditText) view.findViewById(R.id.et_loadDate);
        loadDateET.setText(dateFormatter.format(announcement.getLoadDate()));
        loadDateButton = (ImageButton) view.findViewById(R.id.btn_loadDate);
        loadDateButton.setOnClickListener(this);
        loadDateDialog = setDataPicker(loadDateET);

        //Download date
        downloadDateET = (EditText) view.findViewById(R.id.et_downloadDate);
        downloadDateButton = (ImageButton) view.findViewById(R.id.btn_downloadDate);
        downloadDateET.setText(dateFormatter.format(announcement.getDownloadDate()));
        downloadDateButton.setOnClickListener(this);
        downloadDateDialog = setDataPicker(downloadDateET);

        //Proposal details
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

        return new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fild.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
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
