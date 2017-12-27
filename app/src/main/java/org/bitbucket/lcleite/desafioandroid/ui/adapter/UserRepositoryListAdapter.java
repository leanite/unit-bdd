package org.bitbucket.lcleite.desafioandroid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserRepositoryListAdapter extends RecyclerView.Adapter<UserRepositoryListAdapter.ViewHolder> {

    private List<Repository> repositories;

    public UserRepositoryListAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_user_repository, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Repository repository = repositories.get(position);

        setViews(repository, holder);
    }

    private void setViews(Repository repository, ViewHolder holder){
        holder.tvName.setText(repository.getName());
        holder.tvDescription.setText(repository.getDescription());
        holder.tvStars.setText(String.valueOf(repository.getStars()));
        holder.tvForks.setText(String.valueOf(repository.getForks()));
        holder.tvIssues.setText(String.valueOf(repository.getIssues()));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDescription;
        public TextView tvStars;
        public TextView tvForks;
        public TextView tvIssues;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvStars = itemView.findViewById(R.id.tvStars);
            tvForks = itemView.findViewById(R.id.tvMergedAt);
            tvIssues = itemView.findViewById(R.id.tvIssues);
        }
    }
}