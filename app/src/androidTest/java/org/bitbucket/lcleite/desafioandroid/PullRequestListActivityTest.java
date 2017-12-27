package org.bitbucket.lcleite.desafioandroid;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.resource.IntentServiceIdlingResource;
import org.bitbucket.lcleite.desafioandroid.resource.RecyclerViewSizeAssertion;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity_;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.bitbucket.lcleite.desafioandroid.resource.ViewActionUtils.waitFor;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by leandro on 26/12/2017.
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PullRequestListActivityTest {

    @Rule
    public ActivityTestRule<PullRequestListActivity_> activityTestRule =
            new ActivityTestRule<PullRequestListActivity_>(PullRequestListActivity_.class){
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent intent = new Intent(targetContext, PullRequestListActivity_.class);
                    Bundle args = new Bundle();

                    args.putString(PullRequestListActivity.REPOSITORY_USERNAME, "elastic");
                    args.putString(PullRequestListActivity.REPOSITORY_NAME, "elasticsearch");
                    intent.putExtra(PullRequestListActivity.ARGS, args);

                    return intent;
                }
            };

    private IntentServiceIdlingResource idlingResource;

    @Before
    public void registerIntentServiceIdlingResource() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        idlingResource = new IntentServiceIdlingResource(PullRequestRetrofitService.class, instrumentation.getTargetContext());
        Espresso.registerIdlingResources(idlingResource);
    }

    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }

    @Test
    public void itShould_loadPullRequests(){
        onView(allOf(withId(R.id.rvPullRequestList), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void itShould_loadMoreItemsIfBottomListIsReached(){
        onView(withId(R.id.tabViewPager)).perform(swipeLeft());

        onView(isRoot()).perform(waitFor(1000));
        onView(allOf(withId(R.id.rvPullRequestList), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(29));

        onView(isRoot()).perform(waitFor(2000));
        onView(allOf(withId(R.id.rvPullRequestList), isDisplayed()))
                .check(new RecyclerViewSizeAssertion(greaterThan(30)))
                .perform(RecyclerViewActions.scrollToPosition(35));
    }

    @Test
    public void itShould_notLoseDataOnScreenRotation(){
        Activity activity = activityTestRule.getActivity();

        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        activity.setRequestedOrientation(changeActivityOrientation(activity));

        onView(allOf(withId(R.id.rvPullRequestList), isDisplayed()))
                .check(new RecyclerViewSizeAssertion(greaterThan(1)));
    }

    private int changeActivityOrientation(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        else
            return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    @Test
    public void itShould_openPullRequestUrl(){
        Intents.init();

        onView(withId(R.id.tabViewPager)).perform(swipeLeft());

        onView(isRoot()).perform(waitFor(1000));
        onView(allOf(withId(R.id.rvPullRequestList), isDisplayed()))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        intending(hasAction(Intent.ACTION_VIEW));

        activityTestRule.finishActivity();

        Intents.release();
    }
}
