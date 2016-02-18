package kmcbinc.gvdirections;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;


public class BuildingInfoActivity extends ActionBarActivity {

    private ArrayList<String> buildingNames;
    private ArrayList<String> buildingDescs;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    String acronym;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_info);

        buildingNames = new ArrayList<String>();
        buildingNames.add("AuSable Hall");
        buildingNames.add("Boathouse");
        buildingNames.add("Calder Art Center");
        buildingNames.add("Cook-DeWitt Center");
        buildingNames.add("Commons Building");
        buildingNames.add("The Connection");
        buildingNames.add("Fieldhouse");
        buildingNames.add("Honors College");
        buildingNames.add("Henry Hall");
        buildingNames.add("Zumberge");
        buildingNames.add("Kirkhof Center");
        buildingNames.add("P. Kindschi Hall of Science");
        buildingNames.add("Kelly Family Sports Center");
        buildingNames.add("Lake Huron Hall");
        buildingNames.add("Mary Idema Pew Library");
        buildingNames.add("Lake Michigan Hall");
        buildingNames.add("Lake Ontario Hall");
        buildingNames.add("Lake Superior Hall");
        buildingNames.add("Loutit Lecture Halls ");
        buildingNames.add("Mackinac Hall");
        buildingNames.add("Manitou Hall");
        buildingNames.add("Performing Arts Center");
        buildingNames.add("Padnos Hall");
        buildingNames.add("Seidman House");
        buildingNames.add("Student Services Building");

        buildingDescs = new ArrayList<String>();
        buildingDescs.add("POD, classrooms");
        buildingDescs.add("boats");
        buildingDescs.add("art exhibit, classrooms");
        buildingDescs.add("meeting areas");
        buildingDescs.add("food");
        buildingDescs.add("food, classrooms");
        buildingDescs.add("rec center, classsrooms, rock climbing");
        buildingDescs.add("classrooms, reading center, common area, mail room");
        buildingDescs.add("computer labs, classrooms");
        buildingDescs.add("disability services, payroll, human resources");
        buildingDescs.add("food, meeting rooms, lgbt resources, veterans area, 20/20 desk");
        buildingDescs.add("science labs, the marketplace (bookstore, food)");
        buildingDescs.add("sports fields and tracks");
        buildingDescs.add("classrooms");
        buildingDescs.add("books, meeting rooms, argo tea, IT");
        buildingDescs.add("classrooms");
        buildingDescs.add("classrooms");
        buildingDescs.add("classrooms");
        buildingDescs.add("lecture halls, science exhibits");
        buildingDescs.add("classrooms, math tutoring, stats tutoring, CIS labs, CIS success center, language resource center");
        buildingDescs.add("lecture halls, IT help desk, computers");
        buildingDescs.add("performance hall, practice rooms, classrooms");
        buildingDescs.add("classrooms, science labs, chemistry tutoring");
        buildingDescs.add("library, study space");
        buildingDescs.add("student services");

        // gets the info we sent it from main activity
        Intent intent = getIntent();
        acronym = intent.getStringExtra("acr");


        // the index is the location in the arraylist where the relevant info is
        // for example AuSable is index 0 bc it and its description are first
        index = 0;
        switch (acronym) {
            case "ASH":
                index = 0;
                break;
            case "BH":
                index = 1;
                break;
            case "CAC":
                index = 2;
                break;
            case "CDC":
                index = 3;
                break;
            case "COM":
                index = 4;
                break;
            case "CON":
                index = 5;
                break;
            case "FH":
                index = 6;
                break;
            case "HON":
                index = 7;
                break;
            case "HRY":
                index = 8;
                break;
            case "JHZ":
                index = 9;
                break;
            case "KC":
                index = 10;
                break;
            case "KHS":
                index = 11;
                break;
            case "KTB":
                index = 12;
                break;
            case "LHH":
                index = 13;
                break;
            case "LIB":
                index = 14;
                break;
            case "LMH":
                index = 15;
                break;
            case "LOH":
                index = 16;
                break;
            case "LSH":
                index = 17;
                break;
            case "LTT":
                index = 18;
                break;
            case "MAK":
                index = 19;
                break;
            case "MAN":
                index = 20;
                break;
            case "PAC":
                index = 21;
                break;
            case "PAD":
                index = 22;
                break;
            case "SH":
                index = 23;
                break;
            case "STU":
                index = 24;
                break;
        }

        // sets the title & desc equal to appropriate values
        ((TextView) findViewById(R.id.buildingName)).setText(buildingNames.get(index));
        ((TextView) findViewById(R.id.buildingDesc)).setText(buildingDescs.get(index));

        // when user selects "get directions", it will take them to the directions activity
        Button button = (Button) findViewById(R.id.getDirections);

        final String name = buildingNames.get(index);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    class Button_Clicker implements Button.OnClickListener
    {
        @Override
        public void onClick(View v) {

            // if the user clicks
            if(((TextView) v).getText().toString().equals("getDirections"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(BuildingInfoActivity.this, Directions_Activity.class);

                // it will give the directions activity the name of the building
                launchme.putExtra("acr", buildingNames.get(index));

                BuildingInfoActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_building_info, menu);


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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BuildingInfo Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://kmcbinc.gvdirections/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BuildingInfo Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://kmcbinc.gvdirections/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
