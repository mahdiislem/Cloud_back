package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.FournisseurDto;
import com.teamwill.leasing.Dto.IdentityDto;
import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.Identity;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class FournisseurMapper {

    public Fournisseur FournisseurDtoToFournisseur(FournisseurDto fournisseurDto){
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setLastName(fournisseurDto.getLastName());
        fournisseur.setFirstName(fournisseurDto.getFirstName());
        fournisseur.setBirthDate(fournisseurDto.getBirthDate());
        fournisseur.setBirthPlace(fournisseurDto.getBirthPlace());
        fournisseur.setPhoneNumber(fournisseurDto.getPhoneNumber());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setVille(fournisseurDto.getVille());
        return fournisseur;
    }
}
