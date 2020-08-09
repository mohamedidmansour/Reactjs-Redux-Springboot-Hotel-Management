package org.emsi.gestionhotel.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.emsi.gestionhotel.entity.CategorieChambre;
import org.emsi.gestionhotel.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChambreRepository extends JpaRepository<Chambre, Integer>{
	public  Chambre findById(long id);
	// les chambres  : 
	@Query("SELECT cat.libelle,c.description,c.prix FROM Chambre c JOIN c.categorieC cat")
	public Collection<?> getCategories();
	@Query("SELECT cat FROM Chambre c JOIN c.categorieC cat WHERE c.id = :idChambre")
	public CategorieChambre getCategorieByNumeroChambre(@Param("idChambre") long idChambre);
	@Query("SELECT e FROM Espace e where e.id NOT IN "
			+ "(SELECT r.espace.id FROM Reservation r WHERE ((r.dateDebut BETWEEN ':dateD' AND ':dateF') "
			+ "OR (r.dateFin BETWEEN ':dateD' AND ':dateF')) ) AND e.prix <= :prix AND e.categorieC.id = :categorie")
	public List<Chambre> findAllFree(@Param("dateD") Date d1,@Param("dateF") Date d2,@Param("prix") float prix,@Param("categorie") long cat);
}
