package erasmus.transportapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class PublishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPublish);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    public void publishButton(View view){
        if(checkPublication()) {
            Snackbar.make(view, "Esto publicará el anuncio, pero aun no :D", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    //TODO: checar si los datos indicados son validos  (ubicacion y fechas)
    private boolean checkPublication(){
        EditText loadDate = (EditText) findViewById(R.id.et_loadDate);
        EditText downloadDate = (EditText) findViewById(R.id.et_downloadDate);
        EditText vehicleDetails = (EditText) findViewById(R.id.et_vehicleDetails);
        EditText publicationDetails = (EditText) findViewById(R.id.et_publicationDetails);
        EditText title = (EditText) findViewById(R.id.et_Title);

       try{
           if(loadDate.getText().length()==0) throw new Exception("LoadDate no especificada");
           if(downloadDate.getText().length()==0) throw new Exception("DownloadDate no especificada");
           if(vehicleDetails.getText().length()==0) throw new Exception("VehicleDetails no especificados");
           if(publicationDetails.getText().length()==0) throw new Exception("Detalles de publicacion no especificados");
           if(title.getText().length()==0) throw new Exception("Titulo no especificado");

       } catch (Exception e) {
           e.printStackTrace();
           Toast.makeText(this,"Falta alguno de los elementos requeridos",Toast.LENGTH_LONG).show();
           return false;
       }
        return true;
    }



}
