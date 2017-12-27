package org.bitbucket.lcleite.desafioandroid;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;
import org.bitbucket.lcleite.desafioandroid.resource.IntentServiceIdlingResource;
import org.bitbucket.lcleite.desafioandroid.resource.RecyclerViewSizeAssertion;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity_;
import org.bitbucket.lcleite.desafioandroid.ui.RepositoryListActivity_;
import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity_;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static org.bitbucket.lcleite.desafioandroid.resource.MatcherUtils.withIndex;
import static org.bitbucket.lcleite.desafioandroid.resource.ViewActionUtils.waitFor;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by leandro on 26/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class RepositoryListActivityTest {
    @Rule
    public ActivityTestRule<RepositoryListActivity_> activityTestRule =
            new ActivityTestRule<>(RepositoryListActivity_.class);

    private IntentServiceIdlingResource idlingResource;

    @Before
    public void registerIntentServiceIdlingResource() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        idlingResource = new IntentServiceIdlingResource(RepositoryRetrofitService.class, instrumentation.getTargetContext());
        Espresso.registerIdlingResources(idlingResource);
    }

    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }

    @Test
    public void itShould_loadRepositories(){
        onView(isRoot()).perform(waitFor(1000));
        onView(withId(R.id.rvRepositoryList))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void itShould_goToPullRequestActivity(){
        Intents.init();

        onView(isRoot()).perform(waitFor(1000));
        onView(withId(R.id.rvRepositoryList))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        intended(hasComponent(PullRequestListActivity_.class.getName()));

        Intents.release();
    }

    @Test
    public void itShould_loadMoreItemsIfBottomListIsReached(){
        onView(isRoot()).perform(waitFor(1000));
        onView(withId(R.id.rvRepositoryList))
                .perform(RecyclerViewActions.scrollToPosition(29));

        onView(isRoot()).perform(waitFor(2000));
        onView(withId(R.id.rvRepositoryList))
                .check(new RecyclerViewSizeAssertion(greaterThan(30)))
                .perform(RecyclerViewActions.scrollToPosition(35));
    }

    @Test
    public void itShould_goToUserDetailsActivity(){
        Intents.init();

        onView(isRoot()).perform(waitFor(1000));
        onView(withIndex(withId(R.id.ivUserProfile), 0))
                .perform(click());

        intended(hasComponent(UserDetailsActivity_.class.getName()));

        Intents.release();
    }

    @Test
    public void itShould_notLoseDataOnScreenRotation(){
        Activity activity = activityTestRule.getActivity();

        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        activity.setRequestedOrientation(changeActivityOrientation(activity));

        onView(withId(R.id.rvRepositoryList))
                .check(new RecyclerViewSizeAssertion(greaterThan(1)));
    }

    private int changeActivityOrientation(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        else
            return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }
}
