package org.emsi.gestionhotel.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.emsi.gestionhotel.entity.DateTache;
import org.emsi.gestionhotel.entity.DateTacheKey;
import org.emsi.gestionhotel.entity.LigneCmd;
import org.emsi.gestionhotel.entity.LigneCmdKey;
import org.emsi.gestionhotel.model.LigneCmdDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneCmdRepository extends JpaRepository<LigneCmd, LigneCmdKey>{
	// JPQL
	@Query("SELECT 1 FROM LigneCmd da WHERE da.commande.id = :idC AND da.produit.id = :idP")
	public Boolean isExist(@Param("idC") long idCommande,@Param("idP") long idProduit);
	
	@Query("SELECT da FROM LigneCmd da WHERE da.commande.id = :idC AND da.produit.id = :idP")
	public LigneCmd findByID(@Param("idC") long idCommande,@Param("idP") long idProduit);
	
	@Modifying(clearAutomatically = true)
    @Transactional
	@Query(value = "INSERT INTO `ligne_cmd`(`quantite`, `produit_id`, `commande_id`) VALUES (:q,:p,:c)",nativeQuery = true)
	public void insert(@Param("q") int quantite,@Param("p") long produit,@Param("c") long commande);
	
	
	@Query("SELECT da FROM LigneCmd da")
	public Collection<?> findData();
}
