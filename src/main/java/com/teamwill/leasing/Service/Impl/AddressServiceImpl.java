package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Address;
import com.teamwill.leasing.Repository.AddressRepository;
import com.teamwill.leasing.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address, Long id) {
        return null;
    }

    @Override
    public List<Address> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Address> pagedResult = addressRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Address get(Long id) {
        return addressRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Address with id "+id));
    }

    @Override
    public void delete(Long id) {
        Address address=addressRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Address with id "+id));
        addressRepository.delete(address);

    }
}
