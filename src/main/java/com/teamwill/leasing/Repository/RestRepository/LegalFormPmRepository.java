package com.teamwill.leasing.Repository.RestRepository;

import com.teamwill.leasing.Entity.ParamPM.ActivityPm;
import com.teamwill.leasing.Entity.ParamPM.LegalFormPm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "legalFormPm", path = "legal-forms-pm")
public interface LegalFormPmRepository extends PagingAndSortingRepository<LegalFormPm,Long> {
}
