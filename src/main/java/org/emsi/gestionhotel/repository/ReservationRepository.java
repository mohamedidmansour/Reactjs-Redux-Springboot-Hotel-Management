package org.emsi.gestionhotel.repository;

import java.util.Collection;
import java.util.Date;

import org.emsi.gestionhotel.entity.Espace;
import org.emsi.gestionhotel.entity.Reservation;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	public  Reservation findById(long id);
	@Query("SELECT r.espace,r FROM Reservation r where r.client.id = :idclient order by r.dateDebut ASC")
	public Collection<?> allReservation(@Param("idclient") long id);
	
	/*@Query("SELECT e FROM Espace e where e.id NOT IN "
			+ "(SELECT r.espace.id FROM Reservation r WHERE ((r.dateDebut BETWEEN '2020-6-15' AND '2020-6-20') "
			+ "OR (r.dateFin BETWEEN '2020-6-15' AND '2020-6-20'))) and e.id = 2")
	public Espace espaceIsFree(@Param("dateD") Date date,@Param("dateF") Date date2,@Param("idChambre") 
	long idChambre);*/
	
	/*@Query("SELECT e FROM Espace e where e.id IN "
			+ "(SELECT r.espace.id FROM Reservation r WHERE"
			+ "("
			+ "(r.dateDebut BETWEEN ':dateD' AND ':dateF')"
			+ "OR (r.dateFin BETWEEN ':dateD' AND ':dateF') "
			+ "OR (':dateD' BETWEEN r.dateDebut AND r.dateFin) "
			+ "OR (':dateF' BETWEEN r.dateDebut AND r.dateFin)  "
			+ ")"
			+ ") and e.id = :idChambre")*/
	/*@Query("SELECT count(r.id) FROM Reservation r where r.dateDebut = ?1 AND r.dateFin = ?2  AND r.espace.id = ?3")
	public int espaceIsFree(Date d1,Date d2,long idChambre);*/
	
	@Query(value = "SELECT id FROM `espace` WHERE id not IN (\r\n" + 
			"SELECT r.espace_id FROM `Reservation` r WHERE \r\n" + 
			"(r.date_debut BETWEEN ?1 AND ?2) OR\r\n" + 
			"(r.date_fin BETWEEN ?3 AND ?4) OR\r\n" + 
			"(?5 BETWEEN r.date_debut AND r.date_fin) OR\r\n" + 
			"(?6 BETWEEN r.date_debut AND r.date_fin)\r\n" + 
			"\r\n" + 
			"\r\n" + 
			") and  id = ?7", nativeQuery = true)
	public Object espaceIsFree(String d1,String d2,String d3,String d4,String d5,String d6,long idChambre);
	
	
	@Query("SELECT r.id FROM Reservation r WHERE (r.dateDebut BETWEEN '2020-6-15' AND '2020-06-19')")
	public long gettSS(@Param("dateD") String dateD,@Param("dateF") String dateF
			,@Param("idChambre") long idChambre);
	

}
