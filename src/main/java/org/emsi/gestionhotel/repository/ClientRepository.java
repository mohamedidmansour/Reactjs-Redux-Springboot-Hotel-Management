package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Client;
import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	public  Client findById(long id);
	public  Client findByUsername(String username);
	
}
