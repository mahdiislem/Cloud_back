package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.ParamPM.LegalFormPm;
import com.teamwill.leasing.Entity.ParamPM.LegalStatusPm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "legalStatusPm", path = "legal-status-pm")
public interface LegalStatusPmRepository extends PagingAndSortingRepository<LegalStatusPm,Long> {
}
