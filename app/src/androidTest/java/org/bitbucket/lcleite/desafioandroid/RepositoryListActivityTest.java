package org.bitbucket.lcleite.desafioandroid;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity_;
import org.bitbucket.lcleite.desafioandroid.ui.RepositoryListActivity_;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
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
        idlingResource = new IntentServiceIdlingResource(instrumentation.getTargetContext());
        Espresso.registerIdlingResources(idlingResource);
    }

    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }

    @Test
    public void itShould_loadRepositories(){
        onView(withId(R.id.rvRepositoryList))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void itShould_goToPullRequestActivity(){
        Intents.init();

        onView(withId(R.id.rvRepositoryList))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        intended(hasComponent(PullRequestListActivity_.class.getName()));
    }

    @Test
    public void itShould_loadMoreItemsIfBottomListIsReached(){
        onView(withId(R.id.rvRepositoryList))
                .perform(RecyclerViewActions.scrollToPosition(29));

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(1000);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.rvRepositoryList))
                .check(new RecyclerViewSizeAssertion(greaterThan(30)))
                .perform(RecyclerViewActions.scrollToPosition(35));

        Espresso.unregisterIdlingResources(idlingResource);
    }
}
