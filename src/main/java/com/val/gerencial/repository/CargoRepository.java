package com.val.gerencial.repository;

import com.val.gerencial.model.Cargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
  boolean existsByNroCargo(int nro_cargo);
  List<Cargo> findByPersonaId(Long personaId);
}
