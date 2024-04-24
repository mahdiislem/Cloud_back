package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository  extends PagingAndSortingRepository<Fournisseur,Long> {
    long countByIsDeletedEquals(Boolean isDeleted);
    <T> Page<Fournisseur> findAll(Specification<T> where, Pageable pageable);
    Fournisseur findByEmail(String email);

}