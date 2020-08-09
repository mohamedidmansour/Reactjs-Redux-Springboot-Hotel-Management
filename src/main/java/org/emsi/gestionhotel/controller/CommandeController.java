package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.repository.CommandeRepository;
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
@RequestMapping("/commande")
@CrossOrigin(origins = "http://localhost:3000")
public class CommandeController {
	@Autowired
	private CommandeRepository commandeRepository;
	
	@GetMapping("/all")
	public List<Commande> findAll(){
		return commandeRepository.findAll();
	}
	
	@PostMapping("/save")
	public Commande save(@RequestBody Commande commande){
		return  commandeRepository.save(commande); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Commande commande){
		if(commandeRepository.findById(commande.getId()) != null) {
			commandeRepository.save(commande);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(commandeRepository.findById(Long.parseLong(id)) != null) {
			commandeRepository.delete(commandeRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
