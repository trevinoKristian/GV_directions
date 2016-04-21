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
//        ((TextView) findViewById(R.id.locationsText)).setText((String) chooseTerm.get(term));
//
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.title)).setTypeface(custom_font);
//        ((TextView)findViewById(R.id.locationsText)).setTypeface(custom_font);



        recycler = (RecyclerView) findViewById(R.id.recView);
        mymanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mymanager);

        food = new ArrayList<String>();
        food.add("Commons");
        food.add("Mackinac POD");
        food.add("AuSable POD");
        food.add("The Connection");
        food.add("Kirkhof");
        food.add("MIP Library Argo");
        food.add("The Marketplace");

        coffee = new ArrayList<String>();
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

    }

    @Override
    public void onWordSelected(String term) {

        Intent i = new Intent(this, BuildingInfoActivity.class);
        if (term.equals("Commons")) {
            i.putExtra("acr", "COM");
        }if(term.equals("Mackinac POD")){
            i.putExtra("acr", "MAK");
        }if(term.equals("AuSable POD")){
            i.putExtra("acr", "ASH");
        }if(term.equals("The Connection")){
            i.putExtra("acr", "CON");
        }if(term.equals("Kirkhof")){
            i.putExtra("acr", "KC");
        }if(term.equals("MIP Library Argo")){
            i.putExtra("acr", "LIB");
        }if(term.equals("The Marketplace")){
            i.putExtra("acr","KHS");
        }if(term.equals("POD @ Mackinac")){
            i.putExtra("acr", "MAK");
        }if(term.equals("StarBucks @ The Marketplace")){
            i.putExtra("acr","KHS");
        }if(term.equals("POD @ The Connection")){
            i.putExtra("acr","CON");
        }if(term.equals("JavaCity @ Kirkhof")){
            i.putExtra("acr","KC");
        }if(term.equals("Student Services")){
            i.putExtra("acr","STU");
        }if(term.equals("2020 @ Kirkhof")){
            i.putExtra("acr", "KC");
        }if(term.equals("The IT Help Desk")){
            i.putExtra("acr", "LIB");
        }if(term.equals("The Knowledge Market @ MIP")){
            i.putExtra("acr", "LIB");
        }if(term.equals("Women's Center")){
            i.putExtra("acr", "KC");
        }if(term.equals("Manitou 2nd Floor")){
            i.putExtra("acr", "MAN");
        }if(term.equals("Mackinac")){
            i.putExtra("acr", "MAK");
        }if(term.equals("The Library")){
            i.putExtra("acr","LIB");
        }if(term.equals("Library")){
            i.putExtra("acr","LIB");
        }
        /*
        switch (term){
            case ("Commons"): i.putExtra("acr", "COM");
            case ("Mackinac POD"): i.putExtra("acr","MAK");
            case ("AuSable POD"): i.putExtra("acr", "ASH");
            case ("The Connection"): i.putExtra("acr", "CON");
            case ("Kirkhof"): i.putExtra("acr", "KC");
            case ("MIP Library Argo"): i.putExtra("acr", "LIB");
            case ("The Marketplace"): i.putExtra("acr","KHS");

            case ("POD @ Mackinac"): i.putExtra("acr","MAK");
            case ("StarBucks @ The Marketplace"): i.putExtra("acr","KHS");
            case ("POD @ The Connection"): i.putExtra("acr","CON");
            case ("JavaCity @ Kirkhof"): i.putExtra("acr","KC");

            case ("Student Services"): i.putExtra("acr","STU");
            case ("2020 @ Kirkhof"): i.putExtra("acr", "KC");
            case ("The IT Help Desk"): i.putExtra("acr", "LIB");
            case ("The Knowledge Market @ MIP"): i.putExtra("acr", "LIB");

            case ("Women's Center"): i.putExtra("acr", "KC");

            case ("Manitou 2nd Floor"): i.putExtra("acr", "MAN");
            case ("Mackinac"): i.putExtra ("acr", "MAK");
            case ("Library"): i.putExtra("acr","LIB");
        }
        */

        startActivity(i);
    }
}
