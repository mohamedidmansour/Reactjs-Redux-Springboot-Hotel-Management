package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.repository.CommandeRepository;
import org.emsi.gestionhotel.repository.ComptePaypalRepository;
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
@RequestMapping("/comptePaypal")
@CrossOrigin(origins = "http://localhost:3000")
public class ComptePaypalController {
	@Autowired
	private ComptePaypalRepository comptePaypalRepository;
	
	@GetMapping("/all")
	public List<ComptePaypal> findAll(){
		return comptePaypalRepository.findAll();
	}
	
	@PostMapping("/save")
	public ComptePaypal save(@RequestBody ComptePaypal comptePaypal){
		return  comptePaypalRepository.save(comptePaypal); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ComptePaypal comptePaypal){
		if(comptePaypalRepository.findById(comptePaypal.getId()) != null) {
			comptePaypalRepository.save(comptePaypal);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(comptePaypalRepository.findById(Long.parseLong(id)) != null) {
			comptePaypalRepository.delete(comptePaypalRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
