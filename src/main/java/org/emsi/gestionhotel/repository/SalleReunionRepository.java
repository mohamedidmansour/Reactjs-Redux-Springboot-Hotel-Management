package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.entity.SalleReunion;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleReunionRepository extends JpaRepository<SalleReunion, Integer>{
	
	public  SalleReunion findById(long id);
}
