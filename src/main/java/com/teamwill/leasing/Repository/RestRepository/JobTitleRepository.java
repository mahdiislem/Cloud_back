package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.JobTitle;
import com.teamwill.leasing.Entity.Nationality;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "jobTitle", path = "jobs-title")
public interface JobTitleRepository extends PagingAndSortingRepository<JobTitle,Long> {
}
