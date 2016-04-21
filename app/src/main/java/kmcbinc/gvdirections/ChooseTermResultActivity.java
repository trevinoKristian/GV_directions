package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ChooseTermResultActivity extends AppCompatActivity implements AcronymAdapter.AcronymSelectedListener {
//public class ChooseTermResultActivity extends AppCompatActivity {
   // Map chooseTerm = new HashMap<>();

    //my stuff
    //private TextView title;
    private ArrayList<String> food;
    private ArrayList<String> coffee;
    private ArrayList<String> study;
    private ArrayList<String> info;
    private ArrayList<String> health;
    private ArrayList<String> computer;
    private ArrayList<String> printing;

    private RecyclerView recycler;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager mymanager;

    //end my stuff

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_term_result);

        //createHashMap();

        Intent intent = getIntent();
        String term = intent.getStringExtra("term");

        ((TextView) findViewById(R.id.title)).setText(term);
        /*((TextView) findViewById(R.id.locationsText)).setText((String) chooseTerm.get(term));

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.theTermText)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.locationsText)).setTypeface(custom_font);
        */

        //my stuff
        recycler = (RecyclerView) findViewById(R.id.recView);
        mymanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mymanager);

        food = new ArrayList<String>();
        food.add("Kleiner");
        food.add("Commons");
        food.add("Mackinac POD");
        food.add("AuSable POD");
        food.add("The Connection");
        food.add("Kirkhof");
        food.add("MIP Library Argo");
        food.add("The Marketplace");

        coffee = new ArrayList<String>();
        coffee.add("JavaCity @ Kleiner");
        coffee.add("POD @ Mackinac");
        coffee.add("StarBucks @ The Marketplace");
        coffee.add("POD @ The Connection");
        coffee.add("JavaCity @ Kirkhof");

        study = new ArrayList<String>();
        study.add("The Library");
        study.add("Kirkhof");
        study.add("Mackinac");

        info = new ArrayList<String>();
        info.add("Student Services");
        info.add("2020 @ Kirkhof");
        info.add("The IT Help Desk");
        info.add("The Knowledge Market @ MIP");


        health = new ArrayList<String>();
        health.add("Campus Health Center");
        health.add("Women's Center");

        computer = new ArrayList<String>();
        computer.add("Manitou 2nd Floor");
        computer.add("Mackinac");
        computer.add("Library");
        computer.add("Kirkhof");

        printing = new ArrayList<String>();
        printing.add("Manitou 2nd floor");
        printing.add("Library");
        printing.add("Kirkhof");


        if (term.equals("Food")) {
            myadapter = new AcronymAdapter(food, this);
        }else if (term.equals("Coffee")){
            myadapter = new AcronymAdapter(coffee, this);
        }else if (term.equals("Study Space")){
            myadapter = new AcronymAdapter(study, this);
        }else if(term.equals("Information")){
            myadapter = new AcronymAdapter(info, this);
        }else if(term.equals("Health Services")){
            myadapter = new AcronymAdapter(health, this);
        }else if(term.equals("Computer Lab")){
            myadapter = new AcronymAdapter(computer, this);
        }else if(term.equals("Printing")){
            myadapter = new AcronymAdapter(food, this);
        }

        recycler.setAdapter(myadapter);
        //end my stuff
    }
/*
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
    */

    @Override
    public void onWordSelected(String term) {

        Intent i = new Intent(this, BuildingInfoActivity.class);
        i.putExtra("acr", term);
        startActivity(i);
    }
}
