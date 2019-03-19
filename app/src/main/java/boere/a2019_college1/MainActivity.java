package boere.a2019_college1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import boere.a2019_college1.models.Car;

public class MainActivity extends AppCompatActivity {

    Button college1Button;
    private final static String TAG = "MAIN_ACTIVITY";
    public static final String PREFS_NAME = "MyPrefsFile";

    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // The FAB is defined inline
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // All other buttons are linked here
        linkButtonsToEventListeners();

        // general Log message
        Log.d("hieperdepiep", "hello world");

        // Good practice - use the TAG constant
        Log.d(TAG,"all buttons linked");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void linkButtonsToEventListeners() {
        college1Button = findViewById(R.id.button);
        // INLINE METHOD CALLED
        college1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate from Source (main) to Destination (les1)
                startActivity(new Intent(MainActivity.this, Les1Activity.class));
            }
        });
    }

    public void les2ActivityButtonClicked(View v) {

        // Shared Preferences Example
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        // EDIT MODE ENABLED
        SharedPreferences.Editor editor = settings.edit();
        // WRITE A PRIMITIVE (i.e. now a boolean) but could be an int, double, String, char, etc.
        editor.putBoolean("interestingStuff", true);
        // SAVE YOUR CHANGES
        editor.commit();

        // Parameter passing example
        Intent i = new Intent(MainActivity.this, Les2Activity.class);
        Bundle b = new Bundle();
        b.putInt("key", 1); 		// Use a <key/value> pair : <"key",1>
        b.putChar("letter", 'a');   // Use a <key/value> pair : <"letter",a>
        i.putExtras(b); 	        // Store the key/value in the Intent
        startActivity(i);	        // start navigating to new activity (pass the intent class)
    }

    public void les3ActivityButtonClicked(View v) {
        startActivity(new Intent(MainActivity.this, Les3Activity.class));
    }

    public void les4ActivityButtonClicked(View v) {
        startActivity(new Intent(MainActivity.this, Les4Activity.class));
    }


    public void michielsFunctie (View v) {
        // DOE IETS
        // startActivity(new Intent(this, Les1Activity.class));
    }



}
