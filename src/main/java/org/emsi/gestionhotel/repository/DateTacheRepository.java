package org.emsi.gestionhotel.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.emsi.gestionhotel.entity.DateTache;
import org.emsi.gestionhotel.entity.DateTacheKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DateTacheRepository extends JpaRepository<DateTache, DateTacheKey>{
	// JPQL
	
	@Query("SELECT 1 FROM DateTache da WHERE da.tache = :idT AND da.employe = :idP")
	public Boolean isExist(@Param("idT") long idT,@Param("idP") long idP);
	
	@Query("SELECT da FROM DateTache da WHERE da.tache = :idT AND da.employe = :idP")
	public DateTache findByID(@Param("idT") long idT,@Param("idP") long idP);
	
	@Modifying(clearAutomatically = true)
    @Transactional
	@Query(value = "INSERT INTO `date_tache`(`duree_tache`, `etat`, `tache_id`, `employe_id`) VALUES (:d,:e,:t,:p)",nativeQuery = true)
	public void insert(@Param("d") String d,@Param("e") Boolean e,@Param("t") long t,@Param("p") long p);
	
	
	@Query("SELECT da.employe FROM DateTache da ")
	public Collection<?> findData();
}
