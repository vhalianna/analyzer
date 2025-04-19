package com.val.gerencial.repository;

import com.val.gerencial.model.Liquidacion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Long> {
  boolean existsByNroLiquiAndPersonaIdAndCargoId(int nroLiqui, Long personaId, Long cargoId);
  Optional<Liquidacion> findByNroLiquiAndPersonaId(int nroLiqui, Long personaId);
  List<Liquidacion> findByPersonaId(Long personaId);
}
