package com.teamwill.leasing.Service;

import com.teamwill.leasing.Entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AccountService extends ServiceAbstraction<User> {
    public User loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);
    public Long getTotal();
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy, Specification spec);


}
