package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	public  Utilisateur findByUsername(String username);
	public  Utilisateur findById(long id);
}
