package boere.a2019_college1;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import boere.a2019_college1.database.DatabaseHelper;
import boere.a2019_college1.database.DatabaseInfo;
import boere.a2019_college1.models.Authentication;
import boere.a2019_college1.models.Car;
import boere.a2019_college1.models.Course;

public class Les2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les2);


        //  Used parameter passing to give the <"key",1> to this activity
        Bundle b = getIntent().getExtras();
        if(b != null) {                         // Check if the bundle was created
            int value = b.getInt("key");    // FIND THE value based on the key
            char letter = b.getChar("letter");
            Log.d("Param.Pass: ",""+value+""+ letter); //
        }


        // Used the shared Preferences to store a boolean in your app.
        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        // the false parameter is the default parameter - if the "interestingStuff" is not found
        boolean interesting = settings.getBoolean("interestingStuff", false);
        Log.d(" Found this value :",""+ interesting +"" );						// Use data



    }

    public void makeSomeTestModels(View v) {
        Car audiTT = new Car("Zwart","Audi","TT", "3", "80.000");
        makeToastMessage("Audi created");
        // Course c = new Course ( ..);
        // Authentications a = new Authentication ();
    }

    public void makeSnackBar(String waarde) {
        Snackbar.make(this.findViewById(android.R.id.content),
                "Dit heb ik gevonden:"+waarde+"",
                Snackbar.LENGTH_LONG).setAction("", null).show();
    }

    public void makeToastMessage(String txt) {	// Laat een toast message zien
        //CharSequence text = "Batmobiel gemaakt";
        int duration = Toast.LENGTH_LONG;      // kort = 0.5 sec // long = 1 sec
        Toast toast = Toast.makeText(getApplicationContext(), txt, duration);
        toast.show();
    }

    public void setUsernameButtonClicked (View v) {
        EditText editTxt =(EditText)findViewById(R.id.editText);
        String userName = editTxt.getText().toString();
        Authentication auth = new Authentication(userName, "admin" );
        makeSnackBar( " Username : "+auth.getUsername() );
    }

    public void AddToDBButtonEvent(View v) {
        addToDatabase();
    }

    private void addToDatabase(){
        // Roep een instantie van je class DatabaseHelper aan.
        // Merk op dat de DatabaseHelper synchronised is => altijd maar 1 instantie.
        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);

        ContentValues values = new ContentValues();
        values.put(DatabaseInfo.CarColumn.MERK, "Audi");
        values.put(DatabaseInfo.CarColumn.PRIJS, "6000");
        values.put(DatabaseInfo.CarColumn.KLEUR, "Rood");

        // INSERT dit values object in DE (ZELFGEMAAKTE) RIJ COURSE,
        dbHelper.insert(DatabaseInfo.CarTables.CARTABLE, null, values);
        makeToastMessage("Added a red audi to DB");
    }

    public void GetFromDBButtonEvent(View v) {
        getFromDatabase();
    }

    public void getFromDatabase(){
        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);

        Cursor rs = dbHelper.query(DatabaseInfo.CarTables.CARTABLE, new String[]{"*"},
                null, null, null, null, null);
        rs.moveToFirst();   // Skip : de lege elementen vooraan de rij.

        String name = (String) rs.getString(rs.getColumnIndex("merk"));

        Log.d("Michiel heeft gevonden:", "deze :"+name);
    }

    public void initializeGSON (View v) {
        Gson gson = new Gson();

        // CONVERTS THE JSON String to an array of model objects
        Course[] courses = gson.fromJson(localData, Course[].class);

        for (Course c : courses){
            Log.d("initGSON","-->"+ c.getName());
        }
    }

    private String localData =
            "[{'name':'IARCH','ects':'3','grade':'1','period':'1'}," +
            "{'name':'IIBPM','ects':'3','grade':'1','period':'1'}," +
            "{'name':'IHBO','ects':'3','grade':'1','period':'1'}," +
            "{'name':'IOPR1','ects':'4','grade':'1','period':'1'}," +
            "{'name':'INET','ects':'3','grade':'1','period':'2'}," +
            "{'name':'IWDR','ects':'3','grade':'1','period':'2'}, " +
            "{'name':'IRDB','ects':'3','grade':'1','period':'2'}," +
            "{'name':'IIBUI','ects':'3','grade':'1','period':'2'}," +
            "{'name':'IPRODAM','ects':'2','grade':'1','period':'2'}," +
            "{'name':'IPROMEDT','ects':'2','grade':'1','period':'2'}," +
            "{'name':'IMUML','ects':'3','grade':'1','period':'3'}," +
            "{'name':'IOPR2','ects':'4','grade':'1','period':'3'}, " +
            "{'name':'IFIT','ects':'3','grade':'1','period':'2'}," +
            "{'name':'IPOFIT','ects':'2','grade':'1','period':'2'}," +
            "{'name':'IPOSE','ects':'2','grade':'1','period':'3'}, " +
            "{'name':'IIPXXXX','ects':'10','grade':'1','period':'4'}, " +
            "{'name':'IPROV','ects':'3','grade':'1','period':'4'}, " +
            "{'name':'ICOMMP','ects':'3','grade':'1','period':'4'}, " +
            "{'name':'ISLP','ects':'1','grade':'1','period':'4'}" +
            "]";

    private void addListToDatabase() {
        Car[] cars = new Car[2];

        cars[0] = new Car("Zwart","Audi","TT", "3", "80.000");
        cars[1] = new Car("Grijs","Mazda","5", "5", "6.000");

        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);
        for (Car car : cars) {
            ContentValues values = new ContentValues();
            values.put(DatabaseInfo.CarColumn.KLEUR, car.getKleur());
            values.put(DatabaseInfo.CarColumn.MERK, car.getMerk());
            values.put(DatabaseInfo.CarColumn.PRIJS, car.getPrijs());
            dbHelper.insert(DatabaseInfo.CarTables.CARTABLE, null, values);
        }
    }

}
