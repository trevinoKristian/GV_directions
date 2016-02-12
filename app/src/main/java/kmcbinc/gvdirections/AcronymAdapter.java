package kmcbinc.gvdirections;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Kristian on 2/10/2016.
 */
public class AcronymAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<String> dataSource;
    AcronymSelectedListener acronymListen;

    public AcronymAdapter (ArrayList<String> acronyms, AcronymSelectedListener tmp){

        dataSource = acronyms;
        acronymListen = tmp;
    }

    private class AcronymHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView output;
        public AcronymHolder(View itemView) {
            super(itemView);
            output = (TextView)itemView.findViewById(R.id.myacronym);

            //gives each acronym an OnClickListener
            output.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            TextView t = (TextView)v; /* v is the argument of OnClick */
            acronymListen.onWordSelected(t.getText().toString());

        }
    }

    public interface AcronymSelectedListener {
        void onWordSelected (String w);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell,
                viewGroup, false);
        AcronymHolder holder = new AcronymHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        AcronymHolder tmp = (AcronymHolder)viewHolder;
        tmp.output.setText(dataSource.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
