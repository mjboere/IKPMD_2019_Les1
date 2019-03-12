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
import boere.a2019_college1.models.Car;
import boere.a2019_college1.models.Course;

public class CarListActivity extends AppCompatActivity {

    private ListView mListView;
    private CarListAdapter carAdapter;
    private List<Car> carModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courselist);

        mListView = (ListView) findViewById(R.id.my_list_view);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast t = Toast.makeText(CarListActivity.this,
                     "Click" + position,Toast.LENGTH_LONG);
                t.show();
             }
        });

        fillTheModels();
        carAdapter = new CarListAdapter(CarListActivity.this, 0, carModels);
        mListView.setAdapter(carAdapter);
    }


    private void fillTheModels(){
        carModels.add(new Car("Blauw", "Ford", "Mustang", "5", "90.000"));
        carModels.add(new Car("Rood", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Roze", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Bruin", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Geel", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Oranje", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Wit", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Grijs", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Zwart", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Beige", "Toyata", "Prius", "5", "50.000"));
        carModels.add(new Car("Paars", "Toyata", "Prius", "5", "50.000"));

    }
}
