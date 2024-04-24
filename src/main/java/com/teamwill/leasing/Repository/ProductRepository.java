package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    long countByIsDeletedEquals(Boolean isDeleted);
    Product findByName(String name);

}
