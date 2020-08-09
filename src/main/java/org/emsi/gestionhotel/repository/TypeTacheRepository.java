package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Tache;
import org.emsi.gestionhotel.entity.TypeTache;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeTacheRepository extends JpaRepository<TypeTache, Integer>{
	public  TypeTache findById(long id);
}
