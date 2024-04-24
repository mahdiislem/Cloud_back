package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.ParamPM.RegimePm;
import com.teamwill.leasing.Entity.ParamPM.TypePm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "typePm", path = "types-pm")
public interface TypePmRepository extends PagingAndSortingRepository<TypePm,Long> {
}
