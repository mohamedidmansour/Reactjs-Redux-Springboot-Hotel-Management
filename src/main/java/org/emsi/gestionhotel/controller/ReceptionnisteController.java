package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.emsi.gestionhotel.entity.Receptionniste;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.ChambreRepository;
import org.emsi.gestionhotel.repository.ReceptionnisteRepository;
import org.emsi.gestionhotel.repository.UtilisateurRepository;
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
@RequestMapping("/receptionniste")
@CrossOrigin(origins = "http://localhost:3000")
public class ReceptionnisteController {
	@Autowired
	private ReceptionnisteRepository receptionnisteRepository;
	
	@GetMapping("/all")
	public List<Receptionniste> findAll(){
		return receptionnisteRepository.findAll();
	}
	
	@PostMapping("/save")
	public Receptionniste save(@RequestBody Receptionniste re){
		return  receptionnisteRepository.save(re); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Receptionniste re){
		if(receptionnisteRepository.findById((int) re.getId()) != null) {
			receptionnisteRepository.save(re);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(receptionnisteRepository.findById(Long.parseLong(id)) != null) {
			receptionnisteRepository.delete(receptionnisteRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
