package org.emsi.gestionhotel.controller;

import java.util.Collection;
import java.util.List;

import org.emsi.gestionhotel.dto.ChambreFilter;
import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
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
@RequestMapping("/chambre")
@CrossOrigin(origins = "http://localhost:3000")
public class ChambreController {
	@Autowired
	private ChambreRepository chambreRepository;
	
	@PostMapping("/allFree")
	public List<Chambre> findAllFree(@RequestBody ChambreFilter c){
		System.out.println(c.toString());
		return chambreRepository.
				findAllFree(c.getDateDebut(),
								 c.getDateFin(),
								 c.getPrix(),
								 c.getCategorie());
	}
	/*@GetMapping("/allFree")
	public Collection<?> findAllFree(){
		return chambreRepository.findAllFree();//chambreRepository.findAllFree(null,null);
	}*/
	@GetMapping("/all")
	public List<Chambre> findAll(){
		return chambreRepository.findAll();
	}
	@PostMapping("/save")
	public Chambre save(@RequestBody Chambre chambre){
		return  chambreRepository.save(chambre); // return id
	}
	@PostMapping("/update")
	public void update(@RequestBody Chambre chambre){
		if(chambreRepository.findById(chambre.getId()) != null) {
			chambreRepository.save(chambre);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(chambreRepository.findById(Long.parseLong(id)) != null) {
			chambreRepository.delete(chambreRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	@GetMapping("/categories")
	public List<CategorieChambre> getCategories(){
		return (List<CategorieChambre>) chambreRepository.getCategories();
	}
	
	@GetMapping("/categorie/{id}")
	public CategorieChambre getCategorieByNumeroChambre(@PathVariable (required = true) String id){
		return chambreRepository.getCategorieByNumeroChambre(Long.parseLong(id)); 
	}
	
}
