package org.bitbucket.lcleite.desafioandroid.data.mapper;


import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryDataModelMapper implements DataModelMapper<Repository, RepositoryDataModel> {

    private UserDataModelMapper userDataModelMapper;

    public RepositoryDataModelMapper() {
        userDataModelMapper = new UserDataModelMapper();
    }

    @Override
    public Repository toEntity(RepositoryDataModel dataModel) {
        Repository repository = new Repository();
        User owner = userDataModelMapper.toEntity(dataModel.getOwner());

        repository.setOwner(owner);
        repository.setName(dataModel.getName());
        repository.setFullName(dataModel.getFullName());
        repository.setUrl(dataModel.getUrl());
        repository.setDescription(dataModel.getDescription());
        repository.setForks(dataModel.getForks());
        repository.setStars(dataModel.getStars());
        repository.setIssues(dataModel.getIssues());

        return repository;
    }

    @Override
    public List<Repository> toEntityList(List<RepositoryDataModel> dataModelList){
        List<Repository> repositories = new ArrayList<>();

        for(RepositoryDataModel dataModel : dataModelList){
            Repository repository = toEntity(dataModel);
            repositories.add(repository);
        }

        return repositories;
    }

    @Override
    public RepositoryDataModel toDataModel(Repository entity) {
        return null;
    }

    @Override
    public List<RepositoryDataModel> toDataModelList(List<Repository> entity) {
        return null;
    }
}
