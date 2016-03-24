package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class BuildingInfoActivity extends ActionBarActivity {

    private ArrayList<String> buildingNames;
    private ArrayList<String> buildingDescs;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private String acronym;
    private int index;

    public Drawable loadPhoto(String name) {

        // load image
        try {
            // get input stream
            InputStream ims = getAssets().open("photos/" + name + ".JPG");
            // load image as Drawable
            return Drawable.createFromStream(ims, null);
        }
        catch(IOException ex) {
            return null;
        }

    }

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
        buildingDescs.add("AuSable is one of the older buildings on campus. It houses many classrooms and faculty offices and is the home of the Psychology and Political Science departments. It also houses the ELS center. If you're hungry, AuSable also has a POD.");
        buildingDescs.add("The Boat House is used to store nautical equipment.");
        buildingDescs.add("Calder Art Center is GVSU's visual arts hub. Located inside are art studios of many kinds, and art exhibits.");
        buildingDescs.add("The Cook DeWitt Center is used for large gatherings, including weddings. It is also where many of the campus religious clubs hold their meetings, and it is where Sunday mass is located.");
        buildingDescs.add("The Commons building is a place for food. The top floor has Fresh and Einstein Bagels, and the bottom floor has Fuel.");
        buildingDescs.add("The Connection is a building with both food and classrooms.");
        buildingDescs.add("The Fieldhouse is the place to go for health. There is a pool, a rock climbing wall, and a recreation center. There are also many exercise science classes.");
        buildingDescs.add("The Honors College is where most honors courses and some non-honors courses are taught. In addition to the classrooms, there is a common room with a piano, a reading room, a computer lab, and a mail room.");
        buildingDescs.add("Henry Hall is the home of the Biomedical Sciences department. The first floor also has several computer labs where introductory CIS courses are often taught and where you can print things.");
        buildingDescs.add("Zumberge Hall was originally GVSU's library, but now it is the home of many different things, including Payroll, Human Resources, and Disability Resources.");
        buildingDescs.add("Kirkhof is the heart of GVSU, and there are many different interesting things inside. Many clubs have their meetings in its many meeting rooms, and large gatherings often call the large Grand River Room their home. There are many places to eat, including Subway and Panda Express, and there is also a POD. The 20/20 desk is located on the first floor. There are many other places inside, including the Veteran's Area, the LGBT resources center, and the Student Organization Center.");
        buildingDescs.add("Kindschi Hall is one of the newest additions to GVSU. Inside are many classrooms and laboratories. It is also connected to the Marketplace, which is the home of the bookstore, Starbucks, and Which Wich.");
        buildingDescs.add("The Kelly Family Sports Center is home to many of GVSU's indoor tracks and fields.");
        buildingDescs.add("Lake Huron Hall is one of the original buildings here at GVSU. It has many classrooms inside.");
        buildingDescs.add("Mary Idema Pew is the Allendale campus's library. Obviously, there are books, but there is also much more. There are meeting rooms you can rent for group meetings, hundreds of computers, and many places to sit and study. If you're hungry, thirsty, or in need of some caffeine, Argo Tea is located on the first floor.");
        buildingDescs.add("Lake Michigan Hall is full of classrooms.");
        buildingDescs.add("Lake Ontario Hall is a building full of classrooms and offices.");
        buildingDescs.add("Lake Superior Hall is the home of many communications and photography classes.");
        buildingDescs.add("The Loutit Lecture Halls are where many large introductory science courses hold their lectures. When there are important guest speakers on campus, they will often hold their talks in the Loutit Lecture Halls. Also located in this area are many science exhibits and pieces of artwork.");
        buildingDescs.add("Mackinac Hall is one of GVSU's oldest buildings. Notorious for its complex layout, it is home to many different departments, including Math, CIS, Statistics, and History. There are several computer labs, a POD for food, and many places around to sit and do work. If you need help in your classes, there is also a Math tutoring center and a Stats tutoring center, as well as the CIS success center. There is also a POD if you are hungry.");
        buildingDescs.add("Manitou Hall is home to one of GVSU's computer labs, with nearly the entire first floor comprising of rows of computer where you can do work and print things. The bottom floor houses many large lecture halls where large classes are taught and where introductory CIS courses give their final exams.");
        buildingDescs.add("The Performing Arts Center is the headquarters of performance at GVSU. It is the home of the music, dance, and theater departments. There are practice rooms, faculty offices, and classrooms. It is also home to the Louis Armstrong Theater, where many performances are held.");
        buildingDescs.add("Padnos is the home of many science classrooms and labs. There are also tutoring centers if you are struggling in your science classes, and faculty offices as well.");
        buildingDescs.add("The Seidman House is a small library and provides a quiet environment for students to read and study in.");
        buildingDescs.add("Student Services is home to, well, student services. Whether you need to pay off part of your tuition, buy a new student ID, talk to someone about a job, or get information for a friend looking to attend GVSU, this is the place. Anything and everything you need to know about life at GVSU can likely be found within these walls.");

        // gets the info we sent it from main activity
        Intent intent = getIntent();
        acronym = intent.getStringExtra("acr");


        // the index is the location in the arraylist where the relevant info is
        // for example AuSable is index 0 because its name and its description are firstin the arraylists
        index = 0;
        ImageView img= (ImageView) findViewById(R.id.buildingPhoto);
        switch (acronym) {
            case "ASH":
                index = 0;
                img.setImageDrawable(loadPhoto("ASH"));
                break;
            case "BH":
                index = 1;
                break;
            case "CAC":
                index = 2;
                img.setImageDrawable(loadPhoto("CLD"));
                break;
            case "CDC":
                index = 3;
                img.setImageDrawable(loadPhoto("CDW"));
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
                img.setImageDrawable(loadPhoto("HENRY"));
                break;
            case "JHZ":
                index = 9;
                img.setImageDrawable(loadPhoto("JHZ"));
                break;
            case "KC":
                index = 10;
                img.setImageDrawable(loadPhoto("KC"));
                break;
            case "KHS":
                index = 11;
                img.setImageDrawable(loadPhoto("KHS"));
                break;
            case "KTB":
                index = 12;
                break;
            case "LHH":
                index = 13;
                img.setImageDrawable(loadPhoto("LHH"));
                break;
            case "LIB":
                index = 14;
                img.setImageDrawable(loadPhoto("MIP"));
                break;
            case "LMH":
                index = 15;
                img.setImageDrawable(loadPhoto("LMH"));
                break;
            case "LOH":
                index = 16;
                img.setImageDrawable(loadPhoto("LOH"));
                break;
            case "LSH":
                index = 17;
                img.setImageDrawable(loadPhoto("LSH"));
                break;
            case "LTT":
                index = 18;
                break;
            case "MAK":
                index = 19;
                img.setImageDrawable(loadPhoto("MAK"));
                break;
            case "MAN":
                index = 20;
                img.setImageDrawable(loadPhoto("MANITOU"));
                break;
            case "PAC":
                index = 21;
                img.setImageDrawable(loadPhoto("PAC"));
                break;
            case "PAD":
                index = 22;
                img.setImageDrawable(loadPhoto("PAD"));
                break;
            case "SH":
                index = 23;
                img.setImageDrawable(loadPhoto("SEIDMAN"));
                break;
            case "STU":
                index = 24;
                img.setImageDrawable(loadPhoto("STUDSERV"));
                break;
        }

        // sets the title & desc equal to appropriate values
        ((TextView) findViewById(R.id.theWord)).setText(buildingNames.get(index));
        ((TextView) findViewById(R.id.buildingDesc)).setText(buildingDescs.get(index));

        // when user selects "get directions", it will take them to the directions activity
        Button button = (Button) findViewById(R.id.getDirections);

        final String name = buildingNames.get(index);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.theWord)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.buildingDesc)).setTypeface(custom_font);
    }

    public int getCurrentIndex(){
        return index;
    }

    public String getBuildingName(int i){
        return buildingNames.get(i);
    }

    public String getBuildingDesc(int i){
        return buildingDescs.get(i);
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

   /* @Override
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
        /*Action viewAction = Action.newAction(
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
        client.disconnect();*/
    }

