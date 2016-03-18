package kmcbinc.gvdirections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseTaskActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_task);

        buttonOne = (Button) findViewById(R.id.whatIsBuilding);
        buttonTwo = (Button) findViewById(R.id.howToGetHere);
        buttonThree = (Button) findViewById(R.id.whereCanFind);
        buttonFour = (Button) findViewById(R.id.whatDoesThisMean);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTaskActivity.this, ChooseTermActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTaskActivity.this, DictionaryActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

    }

    /*class Button_Clicker implements Button.OnClickListener
    {
        @Override
        public void onClick(View v) {

            // if the user clicks
            if(((TextView) v).getText().toString().contains("Building"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().contains("GetHere"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().contains("Find"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, ChooseTermActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().contains("Mean"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, DictionaryActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        }
    }*/
}
