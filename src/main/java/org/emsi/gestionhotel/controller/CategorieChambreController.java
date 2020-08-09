package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.repository.CategorieChambreRepository;
import org.emsi.gestionhotel.repository.ChambreRepository;
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
@RequestMapping("/categorieChambre")
@CrossOrigin(origins = "http://localhost:3000")
public class CategorieChambreController {
	@Autowired
	private CategorieChambreRepository categorieChambreRepository;
	
	@GetMapping("/all")
	public List<CategorieChambre> findAll(){
		return categorieChambreRepository.findAll();
	}
	
	@PostMapping("/save")
	public CategorieChambre save(@RequestBody CategorieChambre categorieChambre){
		return  categorieChambreRepository.save(categorieChambre); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody CategorieChambre categorieChambre){
		if(categorieChambreRepository.findById(categorieChambre.getId()) != null) {
			categorieChambreRepository.save(categorieChambre);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(categorieChambreRepository.findById(Long.parseLong(id)) != null) {
			categorieChambreRepository.delete(categorieChambreRepository.findById(Long.parseLong(id)));
		}
	}
	
	
}
