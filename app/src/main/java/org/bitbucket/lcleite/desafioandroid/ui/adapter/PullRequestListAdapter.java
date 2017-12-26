package org.bitbucket.lcleite.desafioandroid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.utils.DateUtils;

import java.util.Date;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by leandro on 23/12/2017.
 */

public class PullRequestListAdapter extends RecyclerView.Adapter<PullRequestListAdapter.ViewHolder> {

    private List<PullRequest> pullRequests;
    private OnItemClickListener onItemClickListener;

    public PullRequestListAdapter(List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_pull_request, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        PullRequest pullRequest = pullRequests.get(position);

        setViews(pullRequest, holder);
    }

    private void setViews(PullRequest pullRequest, ViewHolder holder){
        loadImage(pullRequest.getCreator().getAvatarUrl(), holder.ivUserProfile);
        getMergedDate(pullRequest.getMergedAt(), holder);
        holder.tvTitle.setText(pullRequest.getTitle());
        holder.tvBody.setText(pullRequest.getBody());
        holder.tvCreatedAt.setText(DateUtils.getStringFromDate(pullRequest.getCreatedAt()));
    }

    private void loadImage(String url, ImageView ivUserProfile) {
        Picasso.with(ivUserProfile.getContext())
                .load(url)
                .placeholder(R.drawable.downloading_placeholder)
//                .error(R.drawable.error) FIXME: add error image
                .resizeDimen(R.dimen.profile_pic, R.dimen.profile_pic)
                .transform(new CropCircleTransformation())
                .into(ivUserProfile);
    }

    private void getMergedDate(Date mergedAt, ViewHolder holder) {
        if(mergedAt == null)
            holder.ivMerged.setVisibility(View.GONE);
        else
            holder.tvMergedAt.setText(DateUtils.getStringFromDate(mergedAt));
    }

    @Override
    public int getItemCount() {
        return pullRequests.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivUserProfile;
        public ImageView ivMerged;
        public TextView tvTitle;
        public TextView tvBody;
        public TextView tvCreatedAt;
        public TextView tvMergedAt;



        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            ivUserProfile = itemView.findViewById(R.id.ivUserProfile);
            ivMerged = itemView.findViewById(R.id.ivMerged);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvText);
            tvCreatedAt = itemView.findViewById(R.id.tvCreatedAt);
            tvMergedAt = itemView.findViewById(R.id.tvMergedAt);
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