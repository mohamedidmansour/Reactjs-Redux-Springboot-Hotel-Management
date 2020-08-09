package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Produit;
import org.emsi.gestionhotel.entity.Table;
import org.emsi.gestionhotel.repository.ProduitRepository;
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
@RequestMapping("/produit")
@CrossOrigin(origins = "http://localhost:3000")
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping("/all")
	public List<Produit> findAll(){
		return produitRepository.findAll();
	}
	
	@PostMapping("/save")
	public Produit save(@RequestBody Produit re){
		return  produitRepository.save(re); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Produit re){
		if(produitRepository.findById((int) re.getId()) != null) {
			produitRepository.save(re);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(produitRepository.findById(Long.parseLong(id)) != null) {
			produitRepository.delete(produitRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
