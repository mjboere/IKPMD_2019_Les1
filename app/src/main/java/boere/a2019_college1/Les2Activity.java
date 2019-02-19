package boere.a2019_college1;

import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import boere.a2019_college1.models.Car;

public class Les2Activity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les2);


        //  Used parameter passing to give the <"key",1> to this activity
        Bundle b = getIntent().getExtras();
        if(b != null) {                         // Check if the bundle was created
            int value = b.getInt("key");    // FIND THE value based on the key
            Log.d("Found this : ",""+value+""); //
        }


        // Used the shared Preferences to store a boolean in your app.
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        // the false parameter is the default parameter - if the "inter.stuff" is not found
        boolean interesting = settings.getBoolean("interestingStuff", false);

        Log.d(" Found this value :",""+ interesting +"" );						// Use data



    }

    public void makeSomeTestModels() {
        Car audiTT = new Car("Zwart","Audi","TT", "3");
        // Course c = new Course ( ..);
        // Authentications a = new Authentication ();
    }

    public void makeSnackBar() {		// Zie ook volgende sheet voor Maven import
        String naam = "hiep hoi";
        Snackbar.make(this.findViewById(android.R.id.content), "Dit heb ik gevonden:"+naam+"", Snackbar.LENGTH_LONG).setAction("", null).show();
    }

    public void makeToastMessage() {	// Laat een toast message zien
        CharSequence text = "Batmobiel gemaakt";
        int duration = Toast.LENGTH_LONG;      // kort = 0.5 sec // long = 1 sec
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

}
