package kmcbinc.gvdirections;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<String> acronyms;
    private RecyclerView recycler;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager mymanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removes title
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_main);

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

        recycler = (RecyclerView)findViewById(R.id.recView);

        mymanager = new LinearLayoutManager(this);
        recycler.setLayoutManager (mymanager);

        myadapter = new AcronymAdapter(acronyms);
        recycler.setAdapter(myadapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
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
}

