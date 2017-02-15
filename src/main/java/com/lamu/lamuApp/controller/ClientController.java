package com.lamu.lamuApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamu.lamuApp.dao.ClientDao;
import com.lamu.lamuApp.model.Client;

@RestController
public class ClientController {

	@Autowired
	ClientDao clientDao;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Client>> allClients(@RequestParam(value = "name", required = false) String name) {
		if (name == null) {
			return new ResponseEntity<List<Client>>(clientDao.findAll(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Client>>(clientDao.findByNameContaining(name), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Client> addClient(@RequestBody Client client) {
		if (client != null) {
			clientDao.save(client);
			return new ResponseEntity<Client>(client, HttpStatus.CREATED);
		}
		return new ResponseEntity<Client>(client, HttpStatus.BAD_REQUEST);
	}
}
