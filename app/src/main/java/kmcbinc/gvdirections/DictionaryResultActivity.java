package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class DictionaryResultActivity extends AppCompatActivity {

    Button buttonOne;
    Map<String,String> wordDef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_results);

        Intent i = getIntent();
        String word = i.getStringExtra("searchTerm");

        createMap();

        if (wordDef.containsKey(word)){
            ((TextView) findViewById(R.id.theWord)).setText(word);
            ((TextView) findViewById(R.id.wordDefinition)).setText(wordDef.get(word));
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
        wordDef.put("2020 Desk", "2020 is a help desk, located in Kirkhof, where people answer any questions you may have.");
        wordDef.put("The Wrecking Ball", "The 'wrecking ball' is a pendulum located near Henry Hall and Padnos. It looks like a wrecking ball and was made famous when students made videos of themselves riding it to the song \"Wrecking Ball\" by Miley Cyrus");
        wordDef.put("T. Haas", "T. Haas is the president of GVSU. He is revered as an important part of GVSU.");
        wordDef.put("Debit Dollars", "Debit Dollars, also known as dining dollars, are the dollars that you are able to spend at any food-dispensing estabilishment on campus, from places that usually grant meals (like Fresh) to places like Starbucks and Einstein's Bagels.");
    }
}
