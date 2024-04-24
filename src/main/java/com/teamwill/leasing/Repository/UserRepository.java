package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Address;
import com.teamwill.leasing.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByEmailEquals(String email);

    long countByIsDeletedEquals(Boolean isDeleted);

    Page<User> findByIsDeletedEquals(Boolean isDeleted, Pageable pageable);

    User findByUsername(String username);

    <T> Page<User> findAll(Specification<T> where,Pageable pageable);
}
