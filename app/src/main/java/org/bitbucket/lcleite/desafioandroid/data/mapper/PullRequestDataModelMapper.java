package org.bitbucket.lcleite.desafioandroid.data.mapper;


import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.utils.DateUtils;

import java.util.Date;

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
        pullRequest.setCreatedAt(getCreationDate(dataModel));
        pullRequest.setMerged(getMergedStatus(dataModel));

        return pullRequest;
    }

    private boolean getStatusOpen(PullRequestDataModel dataModel) {
        return dataModel.getStatus().equals("open");
    }

    private Date getCreationDate(PullRequestDataModel dataModel) {
        return DateUtils.createDateFromString(dataModel.getCreatedAt());
    }

    private boolean getMergedStatus(PullRequestDataModel dataModel) {
        return dataModel.getMergedAt() != null;
    }

    @Override
    public PullRequestDataModel toDataModel(PullRequest entity) {
        return null;
    }
}
