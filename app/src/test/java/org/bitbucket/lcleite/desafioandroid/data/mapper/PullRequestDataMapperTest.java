package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataMapperTest {

    private PullRequestDataModelMapper pullRequestDataModelMapper;
    private UserDataModelMapper userDataModelMapper;

    @Before
    public void setup(){
        pullRequestDataModelMapper = new PullRequestDataModelMapper();
        userDataModelMapper = new UserDataModelMapper();
    }

    @Test
    public void itShould_mapPullRequestDataModelToPullRequestEntity(){
        PullRequestDataModel pullRequestDataModel = getPullRequestDataModelMock();
        PullRequest pullRequest = pullRequestDataModelMapper.toEntity(pullRequestDataModel);

        assertTrue(pullRequest.equals(getExpectedPullRequest()));
    }

    private PullRequestDataModel getPullRequestDataModelMock(){
        PullRequestDataModel pullRequestDataModel = new PullRequestDataModel();
        UserDataModel creator = getUserDataModelMock();

        pullRequestDataModel.setCreator(creator);
        pullRequestDataModel.setTitle("Pull Request #17");
        pullRequestDataModel.setState("open");
        pullRequestDataModel.setBody("Pull Request body");
        pullRequestDataModel.setCreatedAt("2013-01-08T20:11:48Z");
        pullRequestDataModel.setMergedAt(null);

        return pullRequestDataModel;
    }

    private UserDataModel getUserDataModelMock(){
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setId(1);
        userDataModel.setUsername("user");
        userDataModel.setName("Repo User");
        userDataModel.setAvatarUrl("http://user.com/avatar");

        return userDataModel;
    }

    private PullRequest getExpectedPullRequest(){
        PullRequest pullRequest = new PullRequest();
        User creator = userDataModelMapper.toEntity(getUserDataModelMock());

        pullRequest.setCreator(creator);
        pullRequest.setTitle("Pull Request #17");
        pullRequest.setOpen(true);
        pullRequest.setBody("Pull Request body");
        pullRequest.setCreatedAt(DateUtils.createDateFromString("2013-01-08T20:11:48Z"));
        pullRequest.setMerged(false);

        return pullRequest;
    }
}
