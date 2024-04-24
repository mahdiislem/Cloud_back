package com.teamwill.leasing.Repository;

import com.teamwill.leasing.Entity.Authority;
import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.Enum.TypePersonne;
import com.teamwill.leasing.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client,Long> {
    Page<Client> findByType(TypePersonne type,Pageable pageable);
    long countByIsDeletedEquals(Boolean isDeleted);
    Client findByEmail(String email);

}
