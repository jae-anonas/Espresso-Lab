package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
/**
 * Created by roosevelt on 7/21/16.
 */
@RunWith(AndroidJUnit4.class)
public class NewTransactionActivityTest {
    @Rule
    public ActivityTestRule<NewTransactionActivity> mTransactionActivityRule = new ActivityTestRule<>(NewTransactionActivity.class);
}
