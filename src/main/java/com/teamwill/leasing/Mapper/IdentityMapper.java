package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.IdentityDto;
import com.teamwill.leasing.Entity.Identity;
import org.springframework.stereotype.Service;

@Service

public class IdentityMapper {
    public Identity IdentityDtoToIdentity(IdentityDto identityDto){
        Identity identity=new Identity();
        identity.setId(identityDto.getId());
        identity.setIdentityNumber(identityDto.getNumeroIdentity());
        identity.setExpirationDate(identityDto.getExpirationDate());
        identity.setDateOfIssue(identityDto.getDateOfIssue());
        //PlaceOfIssue
        identity.setPlaceOfIssue(identityDto.getPlaceOfIssue());
        return identity;
    }

}
