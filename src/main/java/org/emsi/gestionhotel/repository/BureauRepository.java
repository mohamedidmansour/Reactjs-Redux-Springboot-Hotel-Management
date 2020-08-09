package org.emsi.gestionhotel.repository;

import java.util.Collection;

import org.emsi.gestionhotel.entity.Bureau;
import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BureauRepository extends JpaRepository<Bureau, Integer>{
	public  Bureau findById(long id);
}
