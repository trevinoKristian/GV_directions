package kmcbinc.gvdirections;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*******************************************************************
 * Adapter for the list of Acronyms. Supplies only the visible
 * portion of the data to the RecyclerView.
 *
 * @author Kristian Trevino
 * @author Morgan Oneka
 * @author Chris DesRosiers
 * @author Brandon Marshall
 *
 * @version 2/22/16
 *
 ********************************************************************/
public class AcronymAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    /** stores all the data to be displayed */
    private ArrayList<String> dataSource;

    /** acronym listener */
    AcronymSelectedListener acronymListen;

    /*******************************************************************
     * Constructor initializes variables
     * @param acronyms the list of building acronyms
     * @param listen listener for acronym selection
     *******************************************************************/
    public AcronymAdapter (ArrayList<String> acronyms, AcronymSelectedListener listen){

        dataSource = acronyms;
        acronymListen = listen;
    }

    /*******************************************************************
     * Creates objects that hold currently visible data items
     *******************************************************************/
    private class AcronymHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /** data that is outputted */
        public TextView output;

        /*******************************************************************
         * Constructor gives acronyms an onClickListener
         * @param itemView item from the data source
         *******************************************************************/
        public AcronymHolder(View itemView) {

            //calls the parent class constructor
            super(itemView);

            //obtains a reference to the output TextView
            output = (TextView)itemView.findViewById(R.id.myacronym);

            //gives each acronym an OnClickListener
            output.setOnClickListener(this);
        }

        /*******************************************************************
         * Gets acronym text and converts it to a string when user selects
         * the acronym
         * @param acro the acronym selected
         *******************************************************************/
        @Override
        public void onClick(View acro) {
            TextView acron = (TextView)acro;
            acronymListen.onWordSelected(acron.getText().toString());

        }
    }

    /*******************************************************************
     * Defines the listener when an acronym is selected
     *******************************************************************/
    public interface AcronymSelectedListener {
        void onWordSelected (String w);
    }

    /*******************************************************************
     * Creates a new instance of the View Holder
     * @param viewGroup the layout view
     * @param t the view type
     *******************************************************************/
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int t) {

        //keeps a cached copy of all the inflated views
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell,
                viewGroup, false);
        AcronymHolder holder = new AcronymHolder(v);
        return holder;
    }

    /*******************************************************************
     * Populates the RecyclerView with the information from the
     * data source
     * @param viewHolder the view holder
     * @param position the position of the view holder
     *******************************************************************/
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        //initialized a temporary view holder
        AcronymHolder tmp = (AcronymHolder)viewHolder;

        //performs the "binding" between the data source and the RecyclerView
        tmp.output.setText(dataSource.get(position));
    }

    /*******************************************************************
     * Informs RecyclerView the total number of items in the data source
     *******************************************************************/
    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
