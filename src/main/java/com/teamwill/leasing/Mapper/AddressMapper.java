package com.teamwill.leasing.Mapper;


import com.teamwill.leasing.Dto.AddressDto;
import com.teamwill.leasing.Entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
    public Address AddressDtoToAddress(AddressDto addressDto){
        Address address=new Address();
        address.setId(addressDto.getId());
        address.setAddress(addressDto.getAddress());
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        address.setPostalCode(addressDto.getPostalCode());
        return address;
    }
}
