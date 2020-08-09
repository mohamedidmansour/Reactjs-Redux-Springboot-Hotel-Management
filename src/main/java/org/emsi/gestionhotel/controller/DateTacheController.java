package org.emsi.gestionhotel.controller;

import java.util.Collection;
import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.DateTache;
import org.emsi.gestionhotel.repository.CommandeRepository;
import org.emsi.gestionhotel.repository.ComptePaypalRepository;
import org.emsi.gestionhotel.repository.DateTacheRepository;
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
@RequestMapping("/dateTache")
@CrossOrigin(origins = "http://localhost:3000")
public class DateTacheController {
	@Autowired
	private DateTacheRepository dateTacheRepository;
	
	@GetMapping("/all")
	public Collection<?> findAll(){
		return  dateTacheRepository.findData();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody DateTache dateTache){
		 dateTacheRepository.insert(dateTache.getDureeTache(), dateTache.getEtat(), dateTache.getTache().getId(), dateTache.getEmploye().getId());
	}
	
	@PostMapping("/update")
	public void update(@RequestBody DateTache dateTache){
		if(
			dateTacheRepository.isExist(
						dateTache.getEmploye().getId(),
						dateTache.getEmploye().getId())) {
			dateTacheRepository.save(dateTache);
		}
	}
	
	@DeleteMapping("/delete/{idT}/{idP}")
	public void delete(@PathVariable (required = true) String idT,@PathVariable (required = true) String idP){
		if(dateTacheRepository.isExist(Long.parseLong(idT),Long.parseLong(idP))) {
			dateTacheRepository.delete(dateTacheRepository.findByID(Long.parseLong(idT),Long.parseLong(idP)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
