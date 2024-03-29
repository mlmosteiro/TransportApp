package erasmus.transportapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import model.Announcement;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState !=null){
                return;
            }

            DetailsActivityFragment detailsFragment =  new DetailsActivityFragment();
            detailsFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,detailsFragment).commit();

        }

        final Button proposalBtn = (Button) findViewById(R.id.btn_sendPorposal);
        proposalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendPorposalFragment proposalFragment = new SendPorposalFragment();
                proposalFragment.setArguments(getIntent().getExtras());

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, proposalFragment);
                transaction.addToBackStack(null); //En el método addToBackStack() se incluye un parámetro de string opcional que especifica un nombre único para la transacción. El nombre no es necesario a menos que pienses realizar operaciones avanzadas //
                transaction.commit();
            }
        });

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
