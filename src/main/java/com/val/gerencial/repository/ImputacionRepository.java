package com.val.gerencial.repository;

import com.val.gerencial.model.Imputacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImputacionRepository extends JpaRepository<Imputacion, Long> {
  boolean existsByLiquidacionIdAndCodnImput(Long liquidacionId, String codnImput);
  List<Imputacion> findByLiquidacionId(Long liquidacionId);
}
