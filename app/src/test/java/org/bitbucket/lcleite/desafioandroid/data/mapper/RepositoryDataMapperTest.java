package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryDataMapperTest {

    private RepositoryDataModelMapper repositoryDataModelMapper;
    private UserDataModelMapper userDataModelMapper;

    @Before
    public void setup(){
        repositoryDataModelMapper = new RepositoryDataModelMapper();
        userDataModelMapper = new UserDataModelMapper();
    }

    @Test
    public void itShould_mapRepositoryDataModelToRepositoryEntity(){
        RepositoryDataModel repositoryDataModel = getRepositoryDataModelMock();
        Repository repository = repositoryDataModelMapper.toEntity(repositoryDataModel);

        assertTrue(repository.equals(getExpectedRepository()));
    }

    private RepositoryDataModel getRepositoryDataModelMock(){
        RepositoryDataModel repositoryDataModel = new RepositoryDataModel();
        UserDataModel owner = getOwnerDataModelMock();

        repositoryDataModel.setOwner(owner);
        repositoryDataModel.setName("repoName");
        repositoryDataModel.setFullName("user/repoName");
        repositoryDataModel.setUrl("http://repo.com");
        repositoryDataModel.setDescription("Description");
        repositoryDataModel.setForks(20);
        repositoryDataModel.setStars(100);
        repositoryDataModel.setIssues(10);

        return repositoryDataModel;
    }

    private UserDataModel getOwnerDataModelMock(){
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setId(1);
        userDataModel.setUsername("user");
        userDataModel.setName("Repo User");
        userDataModel.setAvatarUrl("http://user.com/avatar");

        return userDataModel;
    }

    private Repository getExpectedRepository(){
        Repository repository = new Repository();
        User owner = userDataModelMapper.toEntity(getOwnerDataModelMock());

        repository.setOwner(owner);
        repository.setName("repoName");
        repository.setFullName("user/repoName");
        repository.setUrl("http://repo.com");
        repository.setDescription("Description");
        repository.setForks(20);
        repository.setStars(100);
        repository.setIssues(10);

        return repository;
    }
}
