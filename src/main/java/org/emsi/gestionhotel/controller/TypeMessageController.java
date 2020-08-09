package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.entity.TypeMessage;
import org.emsi.gestionhotel.repository.TacheRepository;
import org.emsi.gestionhotel.repository.TypeMessageRepository;
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
@RequestMapping("/typeMessage")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeMessageController {
	@Autowired
	private TypeMessageRepository typeMessageRepository;
	
	@GetMapping("/all")
	public List<TypeMessage> findAll(){
		return typeMessageRepository.findAll();
	}
	
	@PostMapping("/save")
	public TypeMessage save(@RequestBody TypeMessage t){
		return  typeMessageRepository.save(t); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TypeMessage t){
		if(typeMessageRepository.findById(t.getId()) != null) {
			typeMessageRepository.save(t);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(typeMessageRepository.findById(Long.parseLong(id)) != null) {
			typeMessageRepository.delete(typeMessageRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
}
