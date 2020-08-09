package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.repository.EspaceRepository;
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
@RequestMapping("/espace")
@CrossOrigin(origins = "http://localhost:3000")
public class EspaceController {
	@Autowired
	private EspaceRepository espaceRepository;
	
	@GetMapping("/all")
	public List<Espace> findAll(){
		return espaceRepository.findAll();
	}
	
	@PostMapping("/save")
	public Espace save(@RequestBody Espace e){
		return  espaceRepository.save(e); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Espace e){
		if(espaceRepository.findById((int) e.getId()) != null) {
			espaceRepository.save(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(espaceRepository.findById(Long.parseLong(id)) != null) {
			espaceRepository.delete(espaceRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
