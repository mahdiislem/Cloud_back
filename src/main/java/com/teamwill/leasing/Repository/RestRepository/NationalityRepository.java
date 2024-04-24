package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.Nationality;
import com.teamwill.leasing.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "nationalities", path = "nationalities")
public interface NationalityRepository extends PagingAndSortingRepository<Nationality,Long> {
}
