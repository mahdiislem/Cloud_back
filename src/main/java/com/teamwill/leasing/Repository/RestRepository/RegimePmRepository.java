package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.ParamPM.ActivityPm;
import com.teamwill.leasing.Entity.ParamPM.RegimePm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "regimePm", path = "regimes-pm")
public interface RegimePmRepository extends PagingAndSortingRepository<RegimePm,Long> {
}
