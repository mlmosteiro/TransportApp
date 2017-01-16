package erasmus.transportapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;import model.Announcement;
import model.Location;
import model.ShipmentAnnouncements;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public abstract class MainFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.listView = (ListView) view.findViewById(R.id.listView_announcements);
        Contents.getInstance().setAnnouncementsList(dummyDataList());
        this.listView.setAdapter(new AnnouncementsAdapter(getContext(),Contents.getInstance().getAnnouncementsList()));

        listView.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    private ArrayList<Announcement> dummyDataList(){
        ArrayList<Announcement> array = new ArrayList<>();

        for(Integer i=0; i<20; i++){
            Location origin = new Location(i, i+i, "Ciudad" + i);
            Location destination = new Location(i*i, i+1, "Ciudad" + i+1);
            array.add(new ShipmentAnnouncements(i, origin,destination));
        }
        return array;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(Contents.ANNOUNCEMENT_POSSITION, position);
        startActivity(intent);

    }

    public abstract ArrayList getArrayAnnouncements();


}
