package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class DictionaryResultActivity extends AppCompatActivity {

    //private TextView title;
    //private TextView description;
    Button buttonOne;
    Map<String,String> wordDef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_results);

        //title = (TextView)findViewById(R.id.theWord);
        //description = (TextView)findViewById(R.id.wordDefinition);

        Intent i = getIntent();
        String word = i.getStringExtra("searchTerm");

        //title.setText(word);
        //description.setText("yo dawg");*/


        createMap();

        if (wordDef.containsKey(word.toUpperCase())){
            ((TextView) findViewById(R.id.theWord)).setText(word.toUpperCase());
            ((TextView) findViewById(R.id.wordDefinition)).setText(wordDef.get(word.toUpperCase()));
        } else{
            ((TextView) findViewById(R.id.theWord)).setText(word);
            ((TextView) findViewById(R.id.wordDefinition)).setText("No definition found.");
        }

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.theWord)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.wordDefinition)).setTypeface(custom_font);
    }


    private void createMap(){
        wordDef = new HashMap<String,String>();
        wordDef.put("2020 DESK", "20/20 is a help desk, located in Kirkhof, where people answer any questions you may have.");
        wordDef.put("20/20 DESK", "20/20 is a help desk, located in Kirkhof, where people answer any questions you may have.");
        wordDef.put("THE WRECKING BALL", "The 'wrecking ball' is a pendulum located near Henry Hall and Padnos. It looks like a wrecking ball and was made famous when students made videos of themselves riding it to the song \"Wrecking Ball\" by Miley Cyrus");
        wordDef.put("T. HAAS", "T. Haas is the president of GVSU. He is revered as an important part of GVSU.");
        wordDef.put("DEBIT DOLLARS", "Debit Dollars, also known as dining dollars, are the dollars that you are able to spend at any food-dispensing estabilishment on campus, from places that usually grant meals (like Fresh) to places like Starbucks and Einstein's Bagels.");
        wordDef.put("NANDIGAM", "Professor who should give us 100 for this release.");
        wordDef.put("LIB", "Short for library.");
        wordDef.put("EOS", "Computer lab in A1-171, with CIS department keycards required for entry");
        wordDef.put("LATE NIGHT", "Dining option located at Kleiner and Connection that lasts from 10-12");


    }

}

