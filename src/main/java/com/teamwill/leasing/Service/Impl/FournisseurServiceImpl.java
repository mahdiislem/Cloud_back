package com.teamwill.leasing.Service.Impl;


import com.teamwill.leasing.Config.Search.SearchCriteria;
import com.teamwill.leasing.Config.Search.SearchOperation;
import com.teamwill.leasing.Config.Search.UserSpecification;
import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.FournisseurRepository;
import com.teamwill.leasing.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur add(Fournisseur fou) {
        Fournisseur fournisseur=fournisseurRepository.findByEmail(fou.getEmail());
        if(fournisseur!=null) throw new RuntimeException("fournisseur already exists");
    //if(!us.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        fou.setIsDeleted(false);
        fou.setCreationDate(new Date());
        fournisseurRepository.save(fou);
        return fou;
}
    @Override
    public Fournisseur update(Fournisseur fournisseur, Long id) {
        Fournisseur fournisseur1=fournisseurRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No fournisseur  with id "+id));
        fournisseur.setFirstName(fournisseur1.getFirstName());
        fournisseur.setLastName(fournisseur1.getLastName());
        fournisseur.setBirthDate(fournisseur1.getBirthDate());
        fournisseur.setEmail(fournisseur1.getEmail());
        fournisseur.setPhoneNumber(fournisseur1.getPhoneNumber());
        fournisseur.setVille(fournisseur1.getVille());
        return fournisseurRepository.save(fournisseur1);
    }

    @Override
    public List<Fournisseur> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        UserSpecification spec = new UserSpecification(
                new SearchCriteria("lastName", SearchOperation.NEGATION, "mahdi"));
        UserSpecification spec1 = new UserSpecification(
                new SearchCriteria("firstName", SearchOperation.NEGATION, "islem"));
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Fournisseur> pagedResult = fournisseurRepository.findAll(Specification.where(spec),paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }    }

    @Override
    public List<Fournisseur> getAll(Integer pageNo, Integer pageSize, String sortBy, Specification spec) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Fournisseur> pagedResult = fournisseurRepository.findAll(Specification.where(spec),paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Fournisseur get(Long id) {
        return fournisseurRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No fournisseur type with id "+id));
    }
    @Override
    public void delete(Long id) {
        Fournisseur fournisseur=fournisseurRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No fournisseur type with id "+id));
        fournisseurRepository.delete(fournisseur);
    }
    @Override
    public Long getTotal() {
        return fournisseurRepository.countByIsDeletedEquals(false);
    }

}




//baya jebir 8
