package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieChambreRepository extends JpaRepository<CategorieChambre, Integer>{
	public  CategorieChambre findById(long id);
}
