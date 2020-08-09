package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{
	public  Commande findById(long id);
}
