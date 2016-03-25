package kmcbinc.gvdirections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class ChooseTermActivity extends AppCompatActivity {

    Button foodButton;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_term2);

        foodButton = (Button) this.findViewById(R.id.foodButton);
    }
}
