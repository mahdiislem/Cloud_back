package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType,Long> {
}
