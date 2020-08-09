package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Receptionniste;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionnisteRepository extends JpaRepository<Receptionniste, Integer>{
	public  Receptionniste findById(long id);
}
