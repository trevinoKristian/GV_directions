package kmcbinc.gvdirections;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class BuildingInfoActivity extends ActionBarActivity {

    private ArrayList<String> buildingNames;
    private ArrayList<String> buildingDescs;

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
}
