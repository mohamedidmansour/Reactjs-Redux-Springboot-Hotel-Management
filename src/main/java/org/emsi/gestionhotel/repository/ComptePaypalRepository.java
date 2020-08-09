package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.ComptePaypal;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComptePaypalRepository extends JpaRepository<ComptePaypal, Integer>{
	public  ComptePaypal findById(long id);
}
