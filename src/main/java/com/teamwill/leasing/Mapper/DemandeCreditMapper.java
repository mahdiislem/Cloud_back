package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.DemandeCreditDto;
import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.DemandeDeCredit;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;
import com.teamwill.leasing.Repository.ClientRepository;
import com.teamwill.leasing.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeCreditMapper {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClientRepository clientRepository;
    public DemandeDeCredit DemandeDeCreditDtoToDemandeDeCredit(DemandeCreditDto demandeCreditDto) {
        DemandeDeCredit demandeDeCredit = new DemandeDeCredit();
        demandeDeCredit.setId(demandeCreditDto.getId());
        demandeDeCredit.setName(demandeCreditDto.getName());
        demandeDeCredit.setDuree(demandeCreditDto.getDuree());
        demandeDeCredit.setNbrEcheance(demandeCreditDto.getNbrEcheance());
        demandeDeCredit.setDemandeType(demandeCreditDto.getDemandeType());

        if (demandeCreditDto.getProductId() != null) {
            Product product = productRepository.findById(demandeCreditDto.getProductId()).orElseThrow(() -> new IllegalArgumentException("no produit with id" + demandeCreditDto.getProductId()));
            demandeDeCredit.setProduct(product);
        }

        if (demandeCreditDto.getClientId() != null) {
            Client client = clientRepository.findById(demandeCreditDto.getClientId()).orElseThrow(() -> new IllegalArgumentException("no client with id" + demandeCreditDto.getClientId()));
            demandeDeCredit.setClient(client);
        }
        return demandeDeCredit;
    }
}
