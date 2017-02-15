package com.lamu.lamuApp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lamu.lamuApp.dao.ClientDao;
import com.lamu.lamuApp.model.Client;

@Component
public class AplicationSetUp {

	@Autowired
	ClientDao clientDao;
	
	//@PostConstruct
	public void setUp(){
		Client client = new Client("santiago123", "123", "santiago", "santiago@mi.com", "3125845");
		clientDao.save(client);
	}
}
