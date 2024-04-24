package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.Enum.TypePersonne;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Repository.ClientRepository;
import com.teamwill.leasing.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client add(Client cl) {
        Client client=clientRepository.findByEmail(cl.getEmail());
        if(client!=null) throw new RuntimeException("client already exists");
        //if(!us.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        cl.setIsDeleted(false);
        System.out.println("hello");
        cl.setCreationDate(new Date());
        clientRepository.save(cl);
        return cl;
    }

    @Override
    public Client update(Client client, Long id) {
        Client client1=clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No client type with id "+id));
        client.setFirstName(client1.getFirstName());
        return clientRepository.save(client1);
    }

    @Override
    public List<Client> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Client> pagedResult = clientRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }    }

    @Override
    public Client get(Long id) {
        return clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No client type with id "+id));
    }


    @Override
    public void delete(Long id) {
        Client client=clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No client type with id "+id));
        clientRepository.delete(client);

    }

    @Override
    public Long getTotal() {
        return clientRepository.countByIsDeletedEquals(false);
    }


    @Override
    public List<Client> getAllPhysicalClient(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Client> pagedResult =  clientRepository.findByType(TypePersonne.physicalPerson,paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
        public List<Client> getAllMoralClient(Integer pageNo, Integer pageSize, String sortBy) {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<Client> pagedResult =  clientRepository.findByType(TypePersonne.MoralPerson,paging);
            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<>();
            }    }

    @Override
    public Client getAllClientByEmail(String email) {
        Client c= clientRepository.findByEmail(email);
        return  c;
    }

}
