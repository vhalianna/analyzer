package com.val.gerencial.repository;

import com.val.gerencial.model.Liquidacion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Long> {
  boolean existsByNroLiquidacionAndPersonaId(int nroLiqui, Long personaId);
  Optional<Liquidacion> findByNroLiquidacionAndPersonaId(int nroLiqui, Long personaId);
  List<Liquidacion> findByPersonaId(Long personaId);
}
