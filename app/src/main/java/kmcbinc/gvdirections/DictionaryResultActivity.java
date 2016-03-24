package kmcbinc.gvdirections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryResultActivity extends AppCompatActivity {

    Button buttonOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_results);

        buttonOne = (Button) findViewById(R.id.whatIsBuilding);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(DictionaryResultActivity.this, MainActivity.class);

                DictionaryResultActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        } );
    }
}
