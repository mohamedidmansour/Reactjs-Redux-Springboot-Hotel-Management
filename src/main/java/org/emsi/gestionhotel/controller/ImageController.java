package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.entity.Image;
import org.emsi.gestionhotel.repository.ImageRepository;
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
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping("/all")
	public List<Image> findAll(){
		return imageRepository.findAll();
	}
	
	@PostMapping("/save")
	public Image save(@RequestBody Image i){
		return  imageRepository.save(i); // return id
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Image i){
		if(imageRepository.findById((int) i.getId()) != null) {
			imageRepository.save(i);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(imageRepository.findById(Long.parseLong(id)) != null) {
			imageRepository.delete(imageRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
