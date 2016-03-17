package kmcbinc.gvdirections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_task);
    }

    class Button_Clicker implements Button.OnClickListener
    {
        @Override
        public void onClick(View v) {

            // if the user clicks
            if(((TextView) v).getText().toString().equals("whatIsBuilding"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().equals("howToGetHere"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, MainActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().equals("whereCanFind"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, ChooseTermActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
            else if(((TextView) v).getText().toString().equals("whatDoesThisMean"))
            {
                // Toast.makeText(v.getContext(), "Hello!! button Clicked", Toast.LENGTH_SHORT).show();

                Intent launchme = new Intent(ChooseTaskActivity.this, DictionaryActivity.class);

                ChooseTaskActivity.this.startActivity(launchme);
                startActivity (launchme);
            }
        }
    }
}
