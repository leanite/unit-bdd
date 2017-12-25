package org.bitbucket.lcleite.desafioandroid.data.mapper;


import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataModelMapper implements DataModelMapper<PullRequest, PullRequestDataModel> {

    private UserDataModelMapper userDataModelMapper;

    public PullRequestDataModelMapper() {
        userDataModelMapper = new UserDataModelMapper();
    }

    @Override
    public PullRequest toEntity(PullRequestDataModel dataModel) {
        PullRequest pullRequest = new PullRequest();
        User creator = userDataModelMapper.toEntity(dataModel.getCreator());

        pullRequest.setCreator(creator);
        pullRequest.setTitle(dataModel.getTitle());
        pullRequest.setOpen(getStatusOpen(dataModel));
        pullRequest.setBody(dataModel.getBody());
        pullRequest.setUrl(dataModel.getUrl());
        pullRequest.setCreatedAt(getCreationDate(dataModel));
        pullRequest.setMerged(getMergedStatus(dataModel));

        return pullRequest;
    }

    private boolean getStatusOpen(PullRequestDataModel dataModel) {
        return dataModel.getState().equals(PullRequest.State.open.value());
    }

    private Date getCreationDate(PullRequestDataModel dataModel) {
        return DateUtils.createDateFromString(dataModel.getCreatedAt());
    }

    private boolean getMergedStatus(PullRequestDataModel dataModel) {
        return dataModel.getMergedAt() != null;
    }

    @Override
    public List<PullRequest> toEntityList(List<PullRequestDataModel> dataModelList){
        List<PullRequest> pullRequests = new ArrayList<>();

        for(PullRequestDataModel dataModel : dataModelList){
            PullRequest pullRequest = toEntity(dataModel);
            pullRequests.add(pullRequest);
        }

        return pullRequests;
    }

    @Override
    public PullRequestDataModel toDataModel(PullRequest entity) {
        return null;
    }

    @Override
    public List<PullRequestDataModel> toDataModelList(List<PullRequest> entity) {
        return null;
    }
}
