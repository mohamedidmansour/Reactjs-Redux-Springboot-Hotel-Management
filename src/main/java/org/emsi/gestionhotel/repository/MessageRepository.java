package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Image;
import org.emsi.gestionhotel.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	public  Message findById(long id);
}
