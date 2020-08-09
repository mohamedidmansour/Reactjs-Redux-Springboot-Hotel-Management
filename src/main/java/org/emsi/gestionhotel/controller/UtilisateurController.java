package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Client;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.ClientRepository;
import org.emsi.gestionhotel.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/all")
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	@PostMapping("/save")
	public Utilisateur save(@RequestBody Utilisateur utilisateur){
		return  utilisateurRepository.save(utilisateur); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Utilisateur utilisateur){
		if(utilisateurRepository.findById(utilisateur.getId()) != null) {
			utilisateurRepository.save(utilisateur);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(utilisateurRepository.findById(Long.parseLong(id)) != null) {
			utilisateurRepository.delete(utilisateurRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
