package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.AddressType;
import com.teamwill.leasing.Entity.IdentityType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressType", path = "address-types")
public interface AddressTypeRepository extends PagingAndSortingRepository<AddressType,Long> {
}
