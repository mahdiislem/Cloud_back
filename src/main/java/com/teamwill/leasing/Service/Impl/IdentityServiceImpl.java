package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Identity;
import com.teamwill.leasing.Repository.IdentityRepository;
import com.teamwill.leasing.Service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IdentityServiceImpl implements IdentityService {
    @Autowired
    IdentityRepository identityRepository;

    @Override
    public Identity add(Identity identity) {
        return identityRepository.save(identity);
    }

    @Override
    public Identity update(Identity identity, Long id) {
        return null;
      }

    @Override
    public List<Identity> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Identity> pagedResult = identityRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
    @Override
    public Identity get(Long id) {
        return identityRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No identity with id "+id));
    }

    @Override
    public void delete(Long id) {
        Identity identity=identityRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No identity with id "+id));
        identityRepository.delete(identity);
    }
}
