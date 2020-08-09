package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.entity.TypeTache;
import org.emsi.gestionhotel.repository.TacheRepository;
import org.emsi.gestionhotel.repository.TypeTacheRepository;
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
@RequestMapping("/typeTache")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeTacheController {
	@Autowired
	private TypeTacheRepository typeTacheRepository;
	
	@GetMapping("/all")
	public List<TypeTache> findAll(){
		return typeTacheRepository.findAll();
	}
	
	@PostMapping("/save")
	public TypeTache save(@RequestBody TypeTache t){
		return  typeTacheRepository.save(t); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TypeTache t){
		if(typeTacheRepository.findById(t.getId()) != null) {
			typeTacheRepository.save(t);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(typeTacheRepository.findById(Long.parseLong(id)) != null) {
			typeTacheRepository.delete(typeTacheRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
