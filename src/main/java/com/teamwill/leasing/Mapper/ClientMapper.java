package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.AddressDto;
import com.teamwill.leasing.Dto.MoralClientDto;
import com.teamwill.leasing.Dto.PhysicalClientDto;
import com.teamwill.leasing.Entity.*;
import com.teamwill.leasing.Entity.Enum.Gender;
import com.teamwill.leasing.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Service
public class ClientMapper {
    public Client MoralClientDtoToClient(MoralClientDto moralClientDto){
        Client client=new Client();
        client.setId(moralClientDto.getId());
        client.setPhoneNumber(moralClientDto.getPhoneNumber());
        client.setLandLine(moralClientDto.getLandLine());
        client.setEmail(moralClientDto.getEmail());
        client.setResident(moralClientDto.getResident());
        client.setPassword(moralClientDto.getPassword());

        client.setCommercialRegisterNumber(moralClientDto.getCommercialRegisterNumber());
        client.setFiscalNumber(moralClientDto.getFiscalNumber());
        client.setCompanyName(moralClientDto.getCompanyName());
        client.setLogo(moralClientDto.getLogo());


        client.setLegalStatusDate(moralClientDto.getLegalStatusDate());
        client.setWebSite(moralClientDto.getWebSite());
        return client;
    }
    public Client PhysicalClientDtoToClient(PhysicalClientDto physicalClientDto) {
        Client client = new Client();
        client.setId(physicalClientDto.getId());
        client.setLastName(physicalClientDto.getLastName());
        client.setFirstName(physicalClientDto.getFirstName());
        client.setPhoneNumber(physicalClientDto.getPhoneNumber());
        client.setLegalStatusPm(physicalClientDto.getLegalStatusPm());
        client.setCreationDate(physicalClientDto.getCreationDate());
        client.setNationality(physicalClientDto.getNationality());
        client.setMaritalStatus(physicalClientDto.getMaritalStatus());
        client.setJobTitle(physicalClientDto.getJobTitle());
        client.setLandLine(physicalClientDto.getLandLine());
        client.setEmail(physicalClientDto.getEmail());
        client.setSalaire(physicalClientDto.getSalaire());
        client.setResident(physicalClientDto.getResident());
        client.setPassword(physicalClientDto.getPassword());
        client.setGender(physicalClientDto.getGender());
        client.setBirthDate(physicalClientDto.getBirthDate());
        client.setBirthplace(physicalClientDto.getBirthplace());
        client.setDocument(physicalClientDto.getDocument());
        return client;

    }
}



