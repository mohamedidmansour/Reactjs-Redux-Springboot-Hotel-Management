package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Receptionniste;
import org.emsi.gestionhotel.entity.Serveur;
import org.emsi.gestionhotel.repository.ServeurRepository;
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
@RequestMapping("/serveur")
@CrossOrigin(origins = "http://localhost:3000")
public class ServeurController {
	@Autowired
	private ServeurRepository serveurRepository;
	
	@GetMapping("/all")
	public List<Serveur> findAll(){
		return serveurRepository.findAll();
	}
	
	@PostMapping("/save")
	public Serveur save(@RequestBody Serveur re){
		return  serveurRepository.save(re); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Serveur re){
		if(serveurRepository.findById((int) re.getId()) != null) {
			serveurRepository.save(re);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(serveurRepository.findById(Long.parseLong(id)) != null) {
			serveurRepository.delete(serveurRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
