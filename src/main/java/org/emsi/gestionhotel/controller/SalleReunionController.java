package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.entity.SalleReunion;
import org.emsi.gestionhotel.repository.EspaceRepository;
import org.emsi.gestionhotel.repository.SalleReunionRepository;
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
@RequestMapping("/salleReunion")
@CrossOrigin(origins = "http://localhost:3000")
public class SalleReunionController {
	@Autowired
	private SalleReunionRepository salleReunionRepository;
	
	@GetMapping("/all")
	public List<SalleReunion> findAll(){
		return salleReunionRepository.findAll();
	}
	
	@PostMapping("/save")
	public SalleReunion save(@RequestBody SalleReunion s){
		return  salleReunionRepository.save(s); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody SalleReunion s){
		if(salleReunionRepository.findById((int) s.getId()) != null) {
			salleReunionRepository.save(s);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(salleReunionRepository.findById(Long.parseLong(id)) != null) {
			salleReunionRepository.delete(salleReunionRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
