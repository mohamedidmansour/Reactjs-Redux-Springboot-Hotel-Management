package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.entity.TypeMessage;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMessageRepository extends JpaRepository<TypeMessage, Integer>{
	public  TypeMessage findById(long id);
}
