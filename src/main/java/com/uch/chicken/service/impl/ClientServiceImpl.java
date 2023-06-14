package com.uch.chicken.service.impl;

import com.uch.chicken.entity.Client;
import com.uch.chicken.repository.ClientRepository;
import com.uch.chicken.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Integer idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Integer idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }
}
