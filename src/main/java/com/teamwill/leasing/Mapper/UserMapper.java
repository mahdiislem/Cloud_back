package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.UserDto;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.RestRepository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserMapper {
    @Autowired
    private AuthorityRepository authorityRepository;
    public User UserDtoToUser(UserDto userDto){
        User user =new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        if (user.getAuthorities()==null){
            user.setAuthorities(new ArrayList<>());
        }
        if(userDto.getAuthoritiesId()!=null){
            userDto.getAuthoritiesId().forEach(aut->{
                user.getAuthorities().add(authorityRepository.findById(Long.valueOf(aut)).get());
            });
        }

        return user;
    }
}
