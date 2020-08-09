package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Bureau;
import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.repository.BureauRepository;
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
@RequestMapping("/bureau")
@CrossOrigin(origins = "http://localhost:3000")
public class BureauController {
	@Autowired
	private BureauRepository bureauRepository;
	
	@GetMapping("/all")
	public List<Bureau> findAll(){
		return bureauRepository.findAll();
	}
	
	@PostMapping("/save")
	public Bureau save(@RequestBody Bureau bureau){
		return  bureauRepository.save(bureau); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Bureau bureau){
		if(bureauRepository.findById(bureau.getId()) != null) {
			bureauRepository.save(bureau);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(bureauRepository.findById(Long.parseLong(id)) != null) {
			bureauRepository.delete(bureauRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
