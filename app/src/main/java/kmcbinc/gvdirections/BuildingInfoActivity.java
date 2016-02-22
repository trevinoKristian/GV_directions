package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/*******************************************************************
 * Second activity for the application. Displays building information
 * such as building name, picture, and description.
 *
 * @author Kristian Trevino
 * @author Morgan Oneka
 * @author Chris DesRosiers
 * @author Brandon Marshall
 *
 * @version 2/22/16
 *
 ********************************************************************/
public class BuildingInfoActivity extends ActionBarActivity {

    /** holds list of building names  */
    private ArrayList<String> buildingNames;

    /** holds list of building descriptions */
    private ArrayList<String> buildingDescs;

    /** the app indexing API */
    private GoogleApiClient client;

    /** acronym of building */
    private String acronym;

    /** the current index of the ArrayList */
    private int index;

    /*******************************************************************
     * Loads photo of building to be displayed
     * @param name the name of the building
     *******************************************************************/
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

    /*******************************************************************
     * Starts the activity
     * @param savedInstanceState the state of the activity
     *******************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //calls the parent class constructor
        super.onCreate(savedInstanceState);

        //sets the xml
        setContentView(R.layout.activity_building_info);

        //obtains a reference to the TextView for the building name
        ((TextView) findViewById(R.id.buildingName)).setText(buildingNames.get(index));

        //obtains a reference to the TextView for the building description
        ((TextView) findViewById(R.id.buildingDesc)).setText(buildingDescs.get(index));

        //obtains a reference to the Button that will get directions
        Button button = (Button) findViewById(R.id.getDirections);

        //the name of the building at a specific index
        final String name = buildingNames.get(index);

        //creates the google API client
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        // changes the font of the text
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.buildingName)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.buildingDesc)).setTypeface(custom_font);

        //instantiates and populates an ArrayList of building names
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

        //instantiates and populates an ArrayList of building descriptions
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

        // gets info from the Main Activity
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
        
    }

    /********************************************************************
     * Defines what happens when user selects the "Get Directions" button
     ********************************************************************/
    class Button_Clicker implements Button.OnClickListener
    {
        /**********************************************************************
         * Passes data from the BuildingInfoActivity to the Directions_Activity
         * @param b the button selected
         **********************************************************************/
        @Override
        public void onClick(View b) {

            // if the user clicks
            if(((TextView) b).getText().toString().equals("getDirections"))
            {
                //creates an intent to pass data from the BuildingInfoActivity
                //the Directions Activity
                Intent launchme = new Intent(BuildingInfoActivity.this, Directions_Activity.class);

                // makes data accesible to the Directions Activity
                launchme.putExtra("acr", buildingNames.get(index));

                //passes data to the Directions Activity
                BuildingInfoActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        }
    }


    /*******************************************************************
     * Creates an options menu to the action bar
     * @param menu the menu
     *******************************************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_building_info, menu);

        return true;
    }

    /*******************************************************************
     * Handles action bar item clicks
     * @param item the menu item selected
     *******************************************************************/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //gets item id
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

