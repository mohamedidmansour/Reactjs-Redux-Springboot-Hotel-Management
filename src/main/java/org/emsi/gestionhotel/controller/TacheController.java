package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.repository.TacheRepository;
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
@RequestMapping("/tache")
@CrossOrigin(origins = "http://localhost:3000")
public class TacheController {
	@Autowired
	private TacheRepository tacheRepository;
	
	@GetMapping("/all")
	public List<Tache> findAll(){
		return tacheRepository.findAll();
	}
	
	@PostMapping("/save")
	public Tache save(@RequestBody Tache tache){
		return  tacheRepository.save(tache); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Tache tache){
		if(tacheRepository.findById(tache.getId()) != null) {
			tacheRepository.save(tache);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(tacheRepository.findById(Long.parseLong(id)) != null) {
			tacheRepository.delete(tacheRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
