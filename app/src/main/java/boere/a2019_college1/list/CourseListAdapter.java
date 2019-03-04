package boere.a2019_college1.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import boere.a2019_college1.R;
import boere.a2019_college1.models.Course;

import static java.security.AccessController.getContext;

/**
 * Created by mjboere on 28-11-2017.
 * 1 element van de lijst
 */
public class CourseListAdapter extends ArrayAdapter<Course> {
    public CourseListAdapter(Context context, int resource, List<Course> objects){
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null ) {
            vh = new ViewHolder();
            LayoutInflater li = LayoutInflater.from(getContext());
            convertView = li.inflate(R.layout.view_content_row, parent, false);
            vh.name = (TextView) convertView.findViewById(R.id.subject_name);
            vh.code = (TextView) convertView.findViewById(R.id.subject_code);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Course cm = getItem(position);
        vh.name.setText((CharSequence) cm.getName());
        vh.code.setText((CharSequence) cm.getEcts());
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView code;
    }
}
