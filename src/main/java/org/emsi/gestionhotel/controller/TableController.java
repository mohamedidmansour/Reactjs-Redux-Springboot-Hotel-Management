package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Receptionniste;
import org.emsi.gestionhotel.entity.Serveur;
import org.emsi.gestionhotel.entity.Table;
import org.emsi.gestionhotel.repository.ServeurRepository;
import org.emsi.gestionhotel.repository.TableRepository;
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
@RequestMapping("/table")
@CrossOrigin(origins = "http://localhost:3000")
public class TableController {
	@Autowired
	private TableRepository tableRepository;
	
	@GetMapping("/all")
	public List<Table> findAll(){
		return tableRepository.findAll();
	}
	
	@PostMapping("/save")
	public Table save(@RequestBody Table re){
		return  tableRepository.save(re); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Table re){
		if(tableRepository.findById((int) re.getId()) != null) {
			tableRepository.save(re);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(tableRepository.findById(Long.parseLong(id)) != null) {
			tableRepository.delete(tableRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
