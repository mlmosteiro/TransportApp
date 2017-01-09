package erasmus.transportapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.announcements;

/**
 * Created by MaryLuz on 04/01/2017.
 */
public class AnnouncementsAdapter extends ArrayAdapter{
    private Context context;
    private ArrayList<announcements> dataArray;

    public AnnouncementsAdapter(Context context, ArrayList data) {
        super(context, R.layout.list_item_announcemet, data);
        this.context = context;
        this.dataArray = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View announcement = inflater.inflate(R.layout.list_item_announcemet, null);

        TextView title = (TextView) announcement.findViewById(R.id.tv_title);
        title.setText(dataArray.get(position).getTitle());

        ImageView image = (ImageView) announcement.findViewById(R.id.iv_type);
        image.setImageResource(dataArray.get(position).getImageId());

        TextView origin = (TextView) announcement.findViewById(R.id.tv_origin);
        origin.setText(dataArray.get(position).getOrigin());

        TextView destination = (TextView) announcement.findViewById(R.id.tv_destination);
        destination.setText(dataArray.get(position).getDestination());


        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        TextView loadDate = (TextView) announcement.findViewById(R.id.tv_loadDate);
        loadDate.setText(df.format(dataArray.get(position).getLoadDate()));

        TextView downloadDate = (TextView) announcement.findViewById(R.id.tv_downloadDate);
        downloadDate.setText(df.format(dataArray.get(position).getDownloadDate()));

        return announcement;
    }
}
