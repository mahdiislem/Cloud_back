package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.ParamPM.ActivityPm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activityPm", path = "activities-pm")
public interface ActivityPmRepository extends PagingAndSortingRepository<ActivityPm,Long> {
}
