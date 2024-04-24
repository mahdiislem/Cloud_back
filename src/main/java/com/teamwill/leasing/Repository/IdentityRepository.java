package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Identity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IdentityRepository extends PagingAndSortingRepository<Identity,Long> {
}
