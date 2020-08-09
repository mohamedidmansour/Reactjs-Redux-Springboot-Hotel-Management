package org.emsi.gestionhotel.controller;

import org.emsi.gestionhotel.entity.Client;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.model.RegisterForm;
import org.emsi.gestionhotel.repository.ClientRepository;
import org.emsi.gestionhotel.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
	@Autowired
	private ClientRepository clientRepository;
	
	
	@PostMapping("/signUp")
	public long register(@RequestBody Client client) {
	    if(client == null || clientRepository.findByUsername(client.getUsername()) != null) return -1;
		else {
			return clientRepository.save(client).getId();
		}
	}
	@PostMapping("/signIn")
	public Client login(@RequestBody Client client) {
		if(clientRepository.findByUsername(client.getUsername()) == null) return null;
		else if(!clientRepository.findByUsername(client.getUsername()).getPassword().equals(client.getPassword()))
			return null;
		else
			return clientRepository.findByUsername(client.getUsername());
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Client client){
		if(clientRepository.findById(client.getId()) != null) {
			clientRepository.save(client);
		}
		
	}
}
