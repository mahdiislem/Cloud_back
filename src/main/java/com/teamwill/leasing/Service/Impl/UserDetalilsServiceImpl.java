package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Authority;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetalilsServiceImpl  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user=userRepository.findByUsername(username);
        if(user==null) throw new UsernameNotFoundException("invalid user");
        System.out.println(user.getAuthorities().size());
        user.getAuthorities().forEach(r->{
            System.out.println(r.getRole());
        });
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getAuthorities().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
