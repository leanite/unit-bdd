package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.DataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Entity;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface DataModelMapper<T extends Entity, U extends DataModel> {
    T toEntity(U dataModel);
    List<T> toEntityList(List<U> dataModels);
    U toDataModel(T entity);
    List<U> toDataModelList(List<T> entity);
}
