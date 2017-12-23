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
 * Created by leandro on 23/12/2017.
 */

public class RepositoryListAdapter extends RecyclerView.Adapter<RepositoryListAdapter.ViewHolder> {

    private List<Repository> repositories;
    private OnItemClickListener onItemClickListener;

    public RepositoryListAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_generic, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Repository repository = repositories.get(position);

        setViews(repository, holder);
    }

    private void setViews(Repository repository, ViewHolder holder){
        holder.tvTitle.setText(repository.getFullName());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}