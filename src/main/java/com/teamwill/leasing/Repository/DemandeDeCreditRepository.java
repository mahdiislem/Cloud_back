package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.DemandeDeCredit;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDeCreditRepository extends PagingAndSortingRepository<DemandeDeCredit,Long> {

    long countByIsDeletedEquals(Boolean isDeleted);

}
