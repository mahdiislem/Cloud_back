package com.teamwill.leasing.Service;


import com.teamwill.leasing.Entity.Client;


import java.util.List;

public interface ClientService extends ServiceAbstraction<Client> {

    public Long getTotal();
    public List<Client> getAllPhysicalClient(Integer pageNo, Integer pageSize, String sortBy);
    public List<Client> getAllMoralClient(Integer pageNo, Integer pageSize, String sortBy);
    public Client getAllClientByEmail(String email);


}
