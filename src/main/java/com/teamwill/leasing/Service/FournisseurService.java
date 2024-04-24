package com.teamwill.leasing.Service;

import com.teamwill.leasing.Entity.Fournisseur;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface FournisseurService extends ServiceAbstraction<Fournisseur>{
    public Long getTotal();
    public List<Fournisseur> getAll(Integer pageNo, Integer pageSize, String sortBy, Specification spec);

}
