package erasmus.transportapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;import model.announcements;
import model.shipmentAnnouncements;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MainFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.listView = (ListView) view.findViewById(R.id.listView_announcements);
        ArrayList announcementsList = dummyDataList();
        this.listView.setAdapter(new AnnouncementsAdapter(getContext(),announcementsList));

        listView.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    private ArrayList dummyDataList(){
        ArrayList<announcements> array = new ArrayList<>();

        for(int i=0; i<20; i++){
            array.add(new shipmentAnnouncements("Ciudad"+i, "Ciudad"+(i+1)));
        }
        return array;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Intent intent = new Intent(getContext(), DetailsActivity.class);
        startActivity(intent);

       // DetailsActivityFragment detailsFragment = new DetailsActivityFragment();

        /*Bundle args = new Bundle();
            TODO:  Aqui poner los argumentos necesarios como para poder realizar la propuesta
        */

/*
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null); //En el método addToBackStack() se incluye un parámetro de string opcional que especifica un nombre único para la transacción. El nombre no es necesario a menos que pienses realizar operaciones avanzadas //
        transaction.commit();*/
    }


}
