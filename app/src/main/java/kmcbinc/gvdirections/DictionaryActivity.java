package kmcbinc.gvdirections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DictionaryActivity extends AppCompatActivity {

    Button buttonOne;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        /*
        buttonOne = (Button) this.findViewById(R.id.button2);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit = (EditText)findViewById(R.id.editText2);

                Intent launchme = new Intent(DictionaryActivity.this, DictionaryResultActivity.class);

                //makes info accessible to the BuildingInfoActivity
                launchme.putExtra("input", mEdit.getText().toString());

                //passes data to BuildingInfoActivity
                startActivity(launchme);
            }
        });  */

    }

}
