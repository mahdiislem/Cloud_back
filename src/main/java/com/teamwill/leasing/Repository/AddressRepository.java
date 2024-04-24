package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address,Long> {
}
