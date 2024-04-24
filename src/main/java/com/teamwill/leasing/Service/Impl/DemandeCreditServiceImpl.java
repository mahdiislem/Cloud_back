package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.DemandeDeCredit;
import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.AddressRepository;
import com.teamwill.leasing.Repository.DemandeDeCreditRepository;
import com.teamwill.leasing.Service.DemandeDeCreditService;
import com.teamwill.leasing.Service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DemandeCreditServiceImpl implements DemandeDeCreditService {
    @Autowired
    DemandeDeCreditRepository demandeDeCreditRepository;

    @Override
    public DemandeDeCredit add(DemandeDeCredit demandeDeCredit) {
        demandeDeCredit.setIsDeleted(false);
        demandeDeCreditRepository.save(demandeDeCredit);
        return demandeDeCredit;
    }

    @Override
    public DemandeDeCredit update(DemandeDeCredit demandeDeCredit, Long id) {
        DemandeDeCredit demandeDeCredit1=demandeDeCreditRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No demande De Credit type with id "+id));
        demandeDeCredit1.setName(demandeDeCredit.getName());
        demandeDeCredit1.setClient(demandeDeCredit.getClient());
        return demandeDeCreditRepository.save(demandeDeCredit1);
    }
    @Override
    public List<DemandeDeCredit> getAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DemandeDeCredit> pagedResult = demandeDeCreditRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }


    }

    @Override
    public DemandeDeCredit get(Long id) {
        return demandeDeCreditRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No demande de credit with id "+id));
    }

    @Override
    public Long getTotal() {
        return demandeDeCreditRepository.countByIsDeletedEquals(false);
    }
    @Override
    public void delete(Long id) {
        DemandeDeCredit demandeDeCredit=demandeDeCreditRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No demande de credit with id "+id));
        demandeDeCreditRepository.delete(demandeDeCredit);
    }
}
