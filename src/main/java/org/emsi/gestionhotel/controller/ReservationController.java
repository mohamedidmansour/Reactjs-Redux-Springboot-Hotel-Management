package org.emsi.gestionhotel.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.emsi.gestionhotel.dto.ReservationBureauDTO;
import org.emsi.gestionhotel.dto.ReservationDTO;
import org.emsi.gestionhotel.dto.ReservationSalleDTO;
import org.emsi.gestionhotel.entity.Employe;
import org.emsi.gestionhotel.entity.Reservation;
import org.emsi.gestionhotel.entity.Utilisateur;
import org.emsi.gestionhotel.repository.BureauRepository;
import org.emsi.gestionhotel.repository.ChambreRepository;
import org.emsi.gestionhotel.repository.ClientRepository;
import org.emsi.gestionhotel.repository.EmployeRepository;
import org.emsi.gestionhotel.repository.ReservationRepository;
import org.emsi.gestionhotel.repository.SalleReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ChambreRepository repoChambre;
	@Autowired
	private SalleReunionRepository repoSalle;
	@Autowired
	private BureauRepository repoBureau;
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping("/all")
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}
	@GetMapping("/all/byClient/{id}")
	public Collection<?> allReservation(@PathVariable (required = true) String id){
			return reservationRepository.allReservation(Long.parseLong(id));
	}
	
	@PostMapping("/save")
	public Reservation save(@RequestBody ReservationDTO e){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(reservationRepository.espaceIsFree(
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getIdChambre()) != null) {
				Reservation res = new Reservation(0, df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), true, null, 
						repoChambre.findById(e.getIdChambre())
						, null, null, clientRepo.findById(e.getIdClient()) , null, null);
				return reservationRepository.save(res);
			}else {
				return null;
			}
			//System.out.println(reservationRepository.espaceIsFree(2,"2020-06-21"));
			//System.out.println(reservationRepository.gettSS(df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), e.getIdChambre()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.toString());
		return null;
	}
	
	
	@PostMapping("/salle/save")
	public Reservation saveSalleReservation(@RequestBody ReservationSalleDTO e){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(reservationRepository.espaceIsFree(
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getIdEspace()) != null) {
				Reservation res = new Reservation(0, df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), true, null, 
						repoSalle.findById(e.getIdEspace())
						, null, null, clientRepo.findById(e.getIdClient()) , null, null);
				return reservationRepository.save(res);
			}else {
				return null;
			}
			//System.out.println(reservationRepository.espaceIsFree(2,"2020-06-21"));
			//System.out.println(reservationRepository.gettSS(df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), e.getIdChambre()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.toString());
		return null;
	}
	
	@PostMapping("/bureaux/save")
	public Reservation saveBureauReservation(@RequestBody ReservationBureauDTO e){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(reservationRepository.espaceIsFree(
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getCheckInDate(),
					e.getCheckOutDate(),
					e.getIdEspace()) != null) {
				Reservation res = new Reservation(0, df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), true, null, 
						repoBureau.findById(e.getIdEspace())
						, null, null, clientRepo.findById(e.getIdClient()) , null, null);
				return reservationRepository.save(res);
			}else {
				return null;
			}
			//System.out.println(reservationRepository.espaceIsFree(2,"2020-06-21"));
			//System.out.println(reservationRepository.gettSS(df.parse(e.getCheckInDate()), df.parse(e.getCheckOutDate()), e.getIdChambre()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.toString());
		return null;
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Reservation e){
		if(reservationRepository.findById((int) e.getId()) != null) {
			reservationRepository.save(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		if(reservationRepository.findById(Long.parseLong(id)) != null) {
			reservationRepository.delete(reservationRepository.findById(Long.parseLong(id)));
		}
	}
	
	/****************JPQL*****************/
	
	
	
}
