package com.uch.chicken.service;

import com.uch.chicken.entity.Category;
import com.uch.chicken.entity.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);

    Client update(Client client);

    void delete(Integer idClient);

    List<Client> findAll();

    Client findById(Integer idClient);
}
