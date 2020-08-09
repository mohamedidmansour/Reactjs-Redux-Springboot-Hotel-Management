package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Facturation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturationRepository extends JpaRepository<Facturation, Integer>{
	
	public  Facturation findById(long id);
}
