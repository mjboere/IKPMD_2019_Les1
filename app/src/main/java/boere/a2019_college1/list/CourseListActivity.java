package boere.a2019_college1.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import boere.a2019_college1.R;
import boere.a2019_college1.models.Course;

public class CourseListActivity extends AppCompatActivity {

    private ListView mListView;
    private CourseListAdapter mAdapter;
    private List<Course> courseModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courselist);

        mListView = (ListView) findViewById(R.id.my_list_view);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast t = Toast.makeText(CourseListActivity.this,
                     "Click" + position,Toast.LENGTH_LONG);
                t.show();
             }
        });

        fillTheModels();
        mAdapter = new CourseListAdapter(CourseListActivity.this, 0, courseModels);
        mListView.setAdapter(mAdapter);
    }


    private void fillTheModels(){
        courseModels.add(new Course("IOPR1", "4", "10", "2"));             // DUMMY DATA
        courseModels.add(new Course("IPSEN", "6", "10", "2"));
    }
}
