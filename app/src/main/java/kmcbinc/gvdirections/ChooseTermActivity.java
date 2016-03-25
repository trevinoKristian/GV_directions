package kmcbinc.gvdirections;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChooseTermActivity extends AppCompatActivity {

    Button foodButton;
    Button coffeeButton;
    Button studyButton;
    Button infoButton;
    Button healthButton;
    Button computerButton;
    Button printingButton;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_term2);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font1.ttf");
        ((TextView)findViewById(R.id.textView6)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.foodButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.coffeeButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.studyButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.infoButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.healthButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.computerButton)).setTypeface(custom_font);
        ((TextView)findViewById(R.id.printingButton)).setTypeface(custom_font);

        foodButton = (Button) this.findViewById(R.id.foodButton);
        coffeeButton = (Button) this.findViewById(R.id.coffeeButton);
        studyButton = (Button) this.findViewById(R.id.studyButton);
        infoButton = (Button) this.findViewById(R.id.infoButton);
        healthButton = (Button) this.findViewById(R.id.healthButton);
        computerButton = (Button) this.findViewById(R.id.computerButton);
        printingButton = (Button) this.findViewById(R.id.printingButton);

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "food");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "coffee");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "study");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "info");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "health");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        computerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "computer");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        });

        printingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchme = new Intent(ChooseTermActivity.this, ChooseTermResultActivity.class);

                launchme.putExtra("term", "printing");
                ChooseTermActivity.this.startActivity(launchme);
                startActivity(launchme);
            }
        });


    }
}
