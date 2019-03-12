package boere.a2019_college1.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import boere.a2019_college1.R;
import boere.a2019_college1.models.Car;
import boere.a2019_college1.models.Course;

public class CarListAdapter extends ArrayAdapter<Car> {
    public CarListAdapter(Context context, int resource, List<Car> objects){
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null ) {
            vh = new ViewHolder();
            LayoutInflater li = LayoutInflater.from(getContext());
            convertView = li.inflate(R.layout.view_content_row, parent, false);
            vh.kleur = (TextView) convertView.findViewById(R.id.subject_kleur);
            vh.merk = (TextView) convertView.findViewById(R.id.subject_merk);
            vh.type = (TextView) convertView.findViewById(R.id.subject_type);
            vh.aantalDeuren = (TextView) convertView.findViewById(R.id.subject_aantalDeuren);
            vh.prijs = (TextView) convertView.findViewById(R.id.subject_prijs);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Car auto = getItem(position);


        vh.kleur.setText((CharSequence) auto.getKleur());
        vh.merk.setText((CharSequence) auto.getMerk());
        vh.type.setText((CharSequence) auto.getType());
        vh.aantalDeuren.setText((CharSequence) auto.getAantalDeuren());
        vh.prijs.setText((CharSequence) auto.getPrijs());
        return convertView;
    }

    private static class ViewHolder {
        TextView kleur;
        TextView merk;
        TextView type;
        TextView aantalDeuren;
        TextView prijs;
    }
}
