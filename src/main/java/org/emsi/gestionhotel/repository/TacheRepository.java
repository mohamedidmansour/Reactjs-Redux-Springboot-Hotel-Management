package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Integer>{
	public  Tache findById(long id);
}
