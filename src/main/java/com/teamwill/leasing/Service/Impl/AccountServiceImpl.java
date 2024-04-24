package com.teamwill.leasing.Service.Impl;


import com.teamwill.leasing.Config.Search.SearchCriteria;
import com.teamwill.leasing.Config.Search.SearchOperation;
import com.teamwill.leasing.Config.Search.UserSpecification;
import com.teamwill.leasing.Entity.Authority;
import com.teamwill.leasing.Entity.DemandeDeCredit;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.RestRepository.AuthorityRepository;
import com.teamwill.leasing.Repository.UserRepository;
import com.teamwill.leasing.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepository appUserRepository;
    @Autowired
    AuthorityRepository appRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;






    public User loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public void addRoleToUser(String username, String rolename) {
        User appUser=appUserRepository.findByUsername(username);
        Authority appRole=appRoleRepository.findByRole(rolename);
        appUser.getAuthorities().add(appRole);
    }

    @Override
    public Long getTotal() {
        return appUserRepository.countByIsDeletedEquals(false);
    }

    @Override
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy, Specification spec) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = appUserRepository.findAll(Specification.where(spec),paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public User add(User us) {
        User user=appUserRepository.findByUsername(us.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        //if(!us.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        us.setIsEnabled(true);
        us.setIsDeleted(false);
        us.setCreationDate(new Date());
        us.setPassword(bCryptPasswordEncoder.encode(us.getPassword()));
        appUserRepository.save(us);
        return us;
    }

    @Override
    public User update(User user, Long id) {
        User user1=appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No demande De Credit type with id "+id));
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setUsername(user.getUsername());
        user1.setBirthDate(user.getBirthDate());
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        return appUserRepository.save(user1);
    }

    @Override
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        UserSpecification spec = new UserSpecification(
                new SearchCriteria("lastName", SearchOperation.NEGATION, "Jallali"));
        UserSpecification spec1 = new UserSpecification(
                new SearchCriteria("firstName", SearchOperation.NEGATION, "Jallali"));
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = appUserRepository.findAll(Specification.where(spec),paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public User get(Long id) {
        return appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No user with id "+id));
    }

    @Override
    public void delete(Long id) {
        User user= appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No user with id "+id));
        user.setIsDeleted(true);
        appUserRepository.delete(user);
    }
}