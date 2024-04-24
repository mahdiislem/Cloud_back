package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.MaritalStatus;
import com.teamwill.leasing.Entity.Nationality;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "maritalStatus", path = "marital-status")
public interface MaritalStatusRepository extends PagingAndSortingRepository<MaritalStatus,Long> {
}
