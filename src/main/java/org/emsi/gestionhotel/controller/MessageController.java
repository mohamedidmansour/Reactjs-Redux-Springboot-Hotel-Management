package org.emsi.gestionhotel.controller;

import java.util.List;

import org.emsi.gestionhotel.dto.MessageDTO;
import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Message;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.MessageRepository;
import org.emsi.gestionhotel.repository.TypeMessageRepository;
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
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UtilisateurRepository repo;
	@Autowired
	private TypeMessageRepository typeRepo;
	
	@GetMapping("/all")
	public List<Message> findAll(){
		return messageRepository.findAll();
	}
	
	@PostMapping("/save")
	public Message save(@RequestBody MessageDTO messageDTO){
		if(repo.findByUsername(messageDTO.getEmailto()) != null && repo.findByUsername(messageDTO.getEmailfrom()) != null
				&& typeRepo.findById(Integer.parseInt(messageDTO.getSelectedOption())) != null) {
			Message msg = new Message();
			msg.setBody(messageDTO.getMessageBody());
			msg.setDate(messageDTO.getDate());
			msg.setTypeMessage(typeRepo.findById(Integer.parseInt(messageDTO.getSelectedOption())));
			msg.setFromUtilisateur(repo.findByUsername(messageDTO.getEmailfrom()));
			msg.setToUtilisateur(repo.findByUsername(messageDTO.getEmailto()));
			msg.setEtat(true);
			return  messageRepository.save(msg); // return id
		}
		return null;
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Message m){
		if(messageRepository.findById((int) m.getId()) != null) {
			messageRepository.save(m);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(messageRepository.findById(Long.parseLong(id)) != null) {
			messageRepository.delete(messageRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
