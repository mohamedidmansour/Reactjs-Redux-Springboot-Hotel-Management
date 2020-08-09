package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.EmployeRepository;
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
@RequestMapping("/employe")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeController {
	@Autowired
	private EmployeRepository employeRepository;
	
	@GetMapping("/all")
	public List<Employe> findAll(){
		return employeRepository.findAll();
	}
	
	@PostMapping("/save")
	public Utilisateur save(@RequestBody Employe e){
		return  employeRepository.save(e); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Employe e){
		if(employeRepository.findById((int) e.getId()) != null) {
			employeRepository.save(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(employeRepository.findById(Long.parseLong(id)) != null) {
			employeRepository.delete(employeRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
