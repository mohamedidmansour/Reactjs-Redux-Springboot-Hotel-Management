package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Facturation;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.ChambreRepository;
import org.emsi.gestionhotel.repository.FacturationRepository;
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
@RequestMapping("/facturation")
@CrossOrigin(origins = "http://localhost:3000")
public class FacturationController {
	@Autowired
	private FacturationRepository facturationRepository;
	
	@GetMapping("/all")
	public List<Facturation> findAll(){
		return facturationRepository.findAll();
	}
	
	@PostMapping("/save")
	public Facturation save(@RequestBody Facturation facturation){
		return  facturationRepository.save(facturation); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Facturation facturation){
		if(facturationRepository.findById((int) facturation.getId()) != null) {
			facturationRepository.save(facturation);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(facturationRepository.findById(Long.parseLong(id)) != null) {
			facturationRepository.delete(facturationRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
