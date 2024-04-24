package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.IdentityType;
import com.teamwill.leasing.Entity.JobTitle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "identityType", path = "identity-types")
public interface IdentityTypeRepository extends PagingAndSortingRepository<IdentityType,Long> {
}
