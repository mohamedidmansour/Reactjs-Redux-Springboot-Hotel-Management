package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.Serveur;
import org.emsi.gestionhotel.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Integer>{
	public  Table findById(long id);
}
