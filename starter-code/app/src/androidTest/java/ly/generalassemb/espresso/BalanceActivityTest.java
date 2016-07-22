package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.NumberFormat;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by roosevelt on 7/21/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {

    /*TODO Requirements

    Use the following user stories for each test. "As a user":

    I can view my current balance.
    I can withdraw money from my account.
    I can deposit money into my account.
    I can perform multiple back-to-back withdrawals and deposits without fail.
    Bonus:

    As a user, I can see a list of my previous transactions.
    As a user, I can see correct values for each listed transaction.
    Add any additional tests you feel would be good to have.
    */

    @Rule
    public ActivityTestRule<BalanceActivity> mMainActivityRule = new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void testViewBalance() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testWithdrawMoney() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Withdraw 12345"));
        onView(withId(R.id.amountEditText)).perform(typeText("12345"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$12,345.00")));
    }

    @Test
    public void testDepositMoney() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Deposit 4 321"));
        onView(withId(R.id.amountEditText)).perform(typeText("4321"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$4,321.00")));
    }

    @Test
    public void testMultipleB2BDepositsAndWithdrawals() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Deposit 4 321"));
        onView(withId(R.id.amountEditText)).perform(typeText("4321"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$4,321.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Withdraw 12345"));
        onView(withId(R.id.amountEditText)).perform(typeText("12345"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$8,024.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Deposit 4 321"));
        onView(withId(R.id.amountEditText)).perform(typeText("4321"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$3,703.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Withdraw 297"));
        onView(withId(R.id.amountEditText)).perform(typeText("297"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$4,000.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Deposit 5 000"));
        onView(withId(R.id.amountEditText)).perform(typeText("5000"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$1,000.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Withdraw 675"));
        onView(withId(R.id.amountEditText)).perform(typeText("675"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$325.00")));

    }

}
