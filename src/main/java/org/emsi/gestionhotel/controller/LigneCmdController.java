package org.emsi.gestionhotel.controller;

import java.util.Collection;
import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.DateTache;
import org.emsi.gestionhotel.entity.LigneCmd;
import org.emsi.gestionhotel.repository.CommandeRepository;
import org.emsi.gestionhotel.repository.ComptePaypalRepository;
import org.emsi.gestionhotel.repository.DateTacheRepository;
import org.emsi.gestionhotel.repository.LigneCmdRepository;
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
@RequestMapping("/ligneCmd")
@CrossOrigin(origins = "http://localhost:3000")
public class LigneCmdController {
	@Autowired
	private LigneCmdRepository ligneCmdRepository;
	
	@GetMapping("/all")
	public Collection<?> findAll(){
		return  ligneCmdRepository.findData();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody LigneCmd obj){
		 ligneCmdRepository.insert(obj.getQuantite(),obj.getProduit().getId(),obj.getCommande().getId());
	}
	
	@PostMapping("/update")
	public void update(@RequestBody LigneCmd obj){
		if(
			ligneCmdRepository.isExist(
						obj.getCommande().getId(),
						obj.getProduit().getId())) {
			ligneCmdRepository.save(obj);
		}
	}
	
	@DeleteMapping("/delete/{idC}/{idP}")
	public void delete(@PathVariable (required = true) String idC,@PathVariable (required = true) String idP){
		if(ligneCmdRepository.isExist(Long.parseLong(idC),Long.parseLong(idP))) {
			ligneCmdRepository.delete(ligneCmdRepository.findByID(Long.parseLong(idC),Long.parseLong(idP)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
