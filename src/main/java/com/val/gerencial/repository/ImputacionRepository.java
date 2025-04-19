package com.val.gerencial.repository;

import com.val.gerencial.model.Imputacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImputacionRepository extends JpaRepository<Imputacion, Long> {
  boolean existsByLiquidacionIdAndPartidaId(Long liquidacionId, Long partidaId);
  List<Imputacion> findByLiquidacionId(Long liquidacionId);
  List<Imputacion> findByPartidaId(Long partidaId);
}
