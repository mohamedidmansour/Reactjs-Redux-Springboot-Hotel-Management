package org.emsi.gestionhotel.repository;

import org.emsi.gestionhotel.entity.RoleUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur, Integer> {
	RoleUtilisateur findByRoleName(String roleName);
}
