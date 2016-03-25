package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;
import java.util.HashMap;

public class ChooseTermResultActivity extends AppCompatActivity {
    Map chooseTerm = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_term_result);

        createHashMap();

        Intent intent = getIntent();
        String term = intent.getStringExtra("term");

        ((TextView) findViewById(R.id.theTermText)).setText(term);
        ((TextView) findViewById(R.id.locationsText)).setText((String)chooseTerm.get(term));

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.theTermText)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.locationsText)).setTypeface(custom_font);
    }

    public void createHashMap(){
        chooseTerm.put("food", "Kleiner \n\n Commons \n\n Mackinac POD \n\n " +
                "AuSable POD \n\n The Connection \n\n Kirkhof \n\n MIP Library Argo \n\n" +
                "The Marketplace");
        chooseTerm.put("coffee", "JavaCity @ Kleiner \n\n POD @ Mackinac \n\n Starbucks @ The Marketplace\n\n" +
                "POD @ The Connection \n\n JavaCity @ Kirkhof");
        chooseTerm.put("study", "The Library\n\nKirkhof\n\nMackinac");
        chooseTerm.put("info", "Student Services\n\n2020 @ Kirkhof\n\nThe IT Help Desk\n\nThe Knowledge Market @ MIP");
        chooseTerm.put("health", "Campus Health Center\n\nWomen's Center");
        chooseTerm.put("computer", "Manitou 2nd floor\n\nMackinac\n\nLibrary\n\nKirkhof");
        chooseTerm.put("printing", "Manitou 2nd floor\n\nLibrary\n\nKirkhof");
    }
}
