package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspaceRepository extends JpaRepository<Espace, Integer>{
	
	public  Espace findById(long id);
}
