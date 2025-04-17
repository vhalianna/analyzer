package com.val.gerencial.repository;

import com.val.gerencial.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByNroLegaj(int nro_legaj);
}
