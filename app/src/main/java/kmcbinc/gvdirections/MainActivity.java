package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*******************************************************************
 * Main Activity for the application. Displays a list of building
 * acronyms that can be selected by the user
 *
 * @author Kristian Trevino
 * @author Morgan Oneka
 * @author Chris DesRosiers
 * @author Brandon Marshall
 *
 * @version 2/22/16
 *
 ********************************************************************/

public class MainActivity extends ActionBarActivity implements AcronymAdapter.AcronymSelectedListener{

    /** holds list of acrovyms */
    private ArrayList<String> acronyms;

    /** RecyclerView widget */
    private RecyclerView recycler;

    /** adapter for the RecyclerView */
    private RecyclerView.Adapter myadapter;

    /** layout manager for the RecyclerView */
    private RecyclerView.LayoutManager mymanager;

    /*******************************************************************
     * Starts the activity
     * @param savedInstanceState the state of the activity
     *******************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //calls the parent class constructor
        super.onCreate(savedInstanceState);

        //sets the xml
        setContentView(R.layout.activity_main);

        //obtains a reference to the RecyclerView
        recycler = (RecyclerView)findViewById(R.id.recView);

        //sets the layout for the RecyclerView to a Linear Layout
        mymanager = new LinearLayoutManager(this);
        recycler.setLayoutManager (mymanager);

        //attaches AcronymAdapter to the RecyclerView
        myadapter = new AcronymAdapter(acronyms, this);
        recycler.setAdapter(myadapter);

        // changes the font of the title & "select building" text
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");

        //obtains a reference to the TextView for the title
        ((TextView)findViewById(R.id.title)).setTypeface(custom_font);

        //obtains a reference to the TextView underneath the title
        ((TextView)findViewById(R.id.selectTitle)).setTypeface(custom_font);

        //instantiates and populates an ArrayList of building acronyms
        acronyms = new ArrayList<String>();
        acronyms.add("ASH");
        acronyms.add("BH");
        acronyms.add("CAC");
        acronyms.add("CDC");
        acronyms.add("COM");
        acronyms.add("CON");
        acronyms.add("FH");
        acronyms.add("HON");
        acronyms.add("HRY");
        acronyms.add("JHZ");
        acronyms.add("KC");
        acronyms.add("KHS");
        acronyms.add("KTB");
        acronyms.add("LHH");
        acronyms.add("LIB");
        acronyms.add("LMH");
        acronyms.add("LOH");
        acronyms.add("LSH");
        acronyms.add("LTT");
        acronyms.add("MAK");
        acronyms.add("MAN");
        acronyms.add("PAC");
        acronyms.add("PAD");
        acronyms.add("SH");
        acronyms.add("STU");

    }

    /*******************************************************************
     * Creates an options menu to the action bar
     * @param menu the menu
     *******************************************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);

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

    /*******************************************************************
     * Passes data from Main Activity to BuildingInfoActivity
     * @param acronym the building acronym
     *******************************************************************/
    @Override
    public void onWordSelected(String acronym) {

        //creates an intent to pass data from the Main Activity to the BuildingInfoActivity
        Intent i = new Intent(this, BuildingInfoActivity.class);

        //makes info accessible to the BuildingInfoActivity
        i.putExtra("acr", acronym);

        //passes data to BuildingInfoActivity
        startActivity(i);
    }
}

