package com.lamu.lamuApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lamu.lamuApp.model.Client;

public interface ClientDao extends CrudRepository<Client, Long>{
	
	Client findById(Long id);
	
	List<Client> findAll();
	
	List<Client> findByNameContaining(String name);

}
