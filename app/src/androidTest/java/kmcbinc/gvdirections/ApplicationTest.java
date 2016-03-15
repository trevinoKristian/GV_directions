package kmcbinc.gvdirections;

import android.app.Application;
import android.test.ApplicationTestCase;
import kmcbinc.gvdirections.MainActivity;



import junit.framework.TestResult;

import java.util.ArrayList;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void createArrayLists(){
        ArrayList acronyms = new ArrayList<String>();
        acronyms.add("ASH");
        acronyms.add("BH");
        acronyms.add("CAC");
        acronyms.add("CDC");
        acronyms.add("COM");
        acronyms.add("CON");
        acronyms.add("FH");
        acronyms.add("HON");
        acronyms.add("HRY");
        acronyms.add("JHZ");
        acronyms.add("KC");
        acronyms.add("KHS");
        acronyms.add("KTB");
        acronyms.add("LHH");
        acronyms.add("LIB");
        acronyms.add("LMH");
        acronyms.add("LOH");
        acronyms.add("LSH");
        acronyms.add("LTT");
        acronyms.add("MAK");
        acronyms.add("MAN");
        acronyms.add("PAC");
        acronyms.add("PAD");
        acronyms.add("SH");
        acronyms.add("STU");

        for (int i = 0; i < acronyms.length(); ++i) {
            onView(withText(acronyms.get(i))).perform(click());
        }
    }

    @Test
    public void test1(){
        createArrayLists();
        for (int i = 0; i < acronyms.size(); i++){
            onView(withText(acronyms.get(i)).perform(click()));
            assertTrue(getActivity().equals(BuildingInfoActivity.class));
            assertTrue(getActivity().getIntent().getStringExtra("acr").equalsIgnoreCase((String) acronyms.get(i)));
        }

    }

}