package kmcbinc.gvdirections;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.*;

/* tests the startup method (choose task */
@RunWith(AndroidJUnit4.class)
public class ChooseTaskTestActivity{
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(ChooseTaskActivity.class);

    @Test
    public void testClickButtonOne(){

        // click "what is building" button
        onView(withId(R.id.whatIsBuilding)).perform(click());

        // makes sure we are on building select page
        onView(withId(R.id.title)).check(matches(withText("GV Directions")));
    }

    @Test
    public void testClickButtonTwo(){
        // click "how to get here" button
        onView(withId(R.id.howToGetHere)).perform(click());

        // makes sure we are on building select page
        onView(withId(R.id.title)).check(matches(withText("GV Directions")));
    }

    @Test
    public void testClickButtonThree(){
        // click "where can i find" button
        onView(withId(R.id.whereCanFind)).perform(click());

        // makes sure we are on building select page
        onView(withId(R.id.textView3)).check(matches(withText("What do you want to find?")));
    }

    @Test
    public void testClickButtonFour(){
        // click "what does this mean" button
        onView(withId(R.id.whatDoesThisMean)).perform(click());

        // makes sure we are on building select page
        onView(withId(R.id.textView5)).check(matches(withText("What term do you want to look up?")));
    }

}

@RunWith(AndroidJUnit4.class)
public class ChooseTaskTestActivity{

    ArrayList<String> acronyms;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    public void createArrayLists(){
        acronyms = new ArrayList<String>();
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
    }

    @Test
    public void testCorrectTitle() {
        createArrayLists();
        for (int i = 0; i < acronyms.size(); i++) {
            onView(withText(acronyms.get(i)).perform(click()));
            onView(withId(R.id.buildingName)).check(matches(withText(acronyms.get(i))));
        }
    }
}

@RunWith(AndroidJUnit4.class)
public class BuildingInfoTestActivity{

    ArrayList<String> acronyms;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void checkTitle() {
        createArrayLists();

        for (int i = 0; i < acronyms.length(); ++i) {
            Context targetContext = InstrumentationRegistry.getInstrumentation()
                    .getTargetContext();
            Intent intent = new Intent(targetContext, MainActivity.class);
            intent.putExtra("acr", acronyms.get(i));

            mActivityRule.launchActivity(intent);

            // asserts title loads correctly
            onView(withId(R.id.buildingName)).check(matches(withText(acronyms.get(i))));
        }

    }

    public void createArrayLists(){
        acronyms = new ArrayList<String>();
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
    }
}





