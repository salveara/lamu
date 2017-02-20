package com.lamu.lamuApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamu.lamuApp.business.ClientBusiness;
import com.lamu.lamuApp.dao.ClientDao;
import com.lamu.lamuApp.model.Client;
import com.lamu.lamuApp.util.WebException;

@RestController
public class ClientController {

	@Autowired
	ClientDao clientDao;
	
	ClientBusiness clientBusiness = new ClientBusiness();

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Client>> allClients(
			@RequestParam(value = "name", required = false) String name) {
		if (name == null) {
			return new ResponseEntity<List<Client>>(clientDao.findAll(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Client>>(clientDao.findByNameContaining(name), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public ResponseEntity<Client> addClient(HttpServletRequest request, @RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "phone", required = false) String phone) {
		if (user != null && password != null) {
			
			try {
				
				clientBusiness.CheckPassword(password);
				
				Client client = new Client(user, password, name, email, phone);
				clientDao.save(client);
				return new ResponseEntity<Client>(client, HttpStatus.CREATED);
				
			} catch (WebException webEx) {
				System.out.println(webEx.getTechnicalMessage());
				//esto hay que cambiarlo por un mensaje de error!!
				return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}
	}

}
