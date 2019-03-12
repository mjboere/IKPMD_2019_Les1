package boere.a2019_college1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import boere.a2019_college1.list.CarListActivity;
import boere.a2019_college1.list.CourseListActivity;
import boere.a2019_college1.models.Course;
import boere.a2019_college1.volley.GsonRequest;
import boere.a2019_college1.volley.VolleyHelper;

public class Les3Activity extends AppCompatActivity {

    private String webLocation = "http://fuujokan.nl/subject_lijst.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void showTheListButtonClicked(View v) {
        startActivity(new Intent(this, CourseListActivity.class));
    }

    public void goToAutolijstje(View v) {
        startActivity(new Intent(this, CarListActivity.class));
    }

    public void getJSONOnlineButtonClicked(View v){

        requestSubjects();


    }




    private void requestSubjects(){
        Type type = new TypeToken<List<Course>>(){}.getType();

        GsonRequest<List<Course>> request = new GsonRequest<List<Course>>(webLocation,
                type, null, new Response.Listener<List<Course>>() {
            @Override
            public void onResponse(List<Course> response) {
                processRequestSucces(response);                 // SUCCES !!
            }
                                        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                processRequestError(error);                     // FAIL :-(
            }
        });
        VolleyHelper.getInstance(this).addToRequestQueue(request);
    }

    private void processRequestSucces(List<Course> subjects ){
        //Log.d("  SUCCES !! "," AJJA ");
        // putting all received classes in my database.
        for (Course cm : subjects) {
           /* ContentValues cv = new ContentValues();
            cv.put(DatabaseInfo.CourseColumn.NAME, cm.name);
            cv.put(DatabaseInfo.CourseColumn.GRADE, cm.grade);
            cv.put(DatabaseInfo.CourseColumn.ECTS, cm.ects);
            cv.put(DatabaseInfo.CourseColumn.CODE , cm.code);
            dbHelper.insert(DatabaseInfo.CourseTables.COURSE, null, cv);
            */
            Log.d("   Found ",""+cm.getName());
        }

        makeToastMessage("Request Succesfull");
        //Cursor rs = dbHelper.query(DatabaseInfo.CourseTables.COURSE, new String[]{"*"}, null, null, null, null, null);
        //rs.moveToFirst();   // kan leeg zijn en faalt dan
        //DatabaseUtils.dumpCursor(rs);

    }

    private void processRequestError(VolleyError error){
        // WAT ZULLEN WE HIERMEE DOEN ??
        Log.d("  FAIL  !! ",error.getMessage());
        makeToastMessage("Request Failed");
    }

    public void makeToastMessage(String txt) {	// Laat een toast message zien
        //CharSequence text = "Batmobiel gemaakt";
        int duration = Toast.LENGTH_LONG;      // kort = 0.5 sec // long = 1 sec
        Toast toast = Toast.makeText(getApplicationContext(), txt, duration);
        toast.show();
    }

}
