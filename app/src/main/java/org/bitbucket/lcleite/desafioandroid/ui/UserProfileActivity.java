package org.bitbucket.lcleite.desafioandroid.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity implements RepositoryListAdapter.OnItemClickListener {

    /*@ViewById(R.id.rvRepositoryList) */protected RecyclerView repositoriesRecyclerView;
    RepositoryListAdapter repositoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        repositoriesRecyclerView = findViewById(R.id.rvRepositoryList);
        setupRepositoriesRecyclerViewAdapter();
        setupRepositoriesRecyclerView();

        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(final AppBarLayout appBarLayout, int verticalOffset) {
                //Initialize the size of the scroll
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                //Check if the view is collapsed
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(UserProfileActivity.this, R.color.colorPrimary));
                }else{
                    toolbar.setBackgroundColor(ContextCompat.getColor(UserProfileActivity.this, android.R.color.transparent));
                }
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setupRepositoriesRecyclerViewAdapter(){
        repositoriesAdapter = new RepositoryListAdapter(mockRepositories());
        repositoriesAdapter.setOnItemClickListener(this);
    }

    private List<Repository> mockRepositories() {
        List<Repository> repositories = new ArrayList<>();

        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());
        repositories.add(createRepo());

        return repositories;
    }

    private Repository createRepo(){
        Repository repository = new Repository();

        User user = new User();
        user.setUsername("lcleite");

        repository.setOwner(user);
        repository.setName("project");
        repository.setDescription("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        return repository;
    }

    private void setupRepositoriesRecyclerView() {
//        endlessScrollListener = new EndlessScrollListener(this);
        repositoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        repositoriesRecyclerView.setAdapter(repositoriesAdapter);
        repositoriesRecyclerView.addItemDecoration(
                new ListDivider(ContextCompat.getDrawable(this, R.drawable.divider_item_list)));
//        repositoriesRecyclerView.addOnScrollListener(endlessScrollListener);
    }

    @Override
    public void onItemClick(int position) {

    }
}
