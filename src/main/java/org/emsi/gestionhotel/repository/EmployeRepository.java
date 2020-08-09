package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{
	public  Employe findById(long id);
	public  Employe findByUsername(String username);
}
