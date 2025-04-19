package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.CargoRepository;
import com.val.gerencial.repository.GerencialRepository;
import com.val.gerencial.repository.ImputacionRepository;
import com.val.gerencial.repository.LiquidacionRepository;
import com.val.gerencial.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImputacionService {

  @Autowired
  private PersonaRepository personaRepository;

  @Autowired
  private ImputacionRepository imputacionRepository;

  @Autowired
  private LiquidacionRepository liquidacionRepository;

  @Autowired
  private GerencialRepository gerencialRepository;

  public List<Imputacion> findByLiquidacionId(Long id){
    return imputacionRepository.findByLiquidacionId(id);
  }

  public void updateImputacion() {
    List<Gerencial> datosGerencial  = gerencialRepository.findAll();
    //Get all Diferent Personas insert into personas

    for (Gerencial g : datosGerencial) {
      // Verificamos si ya existe una persona con ese nro_legaj
      Optional<Persona> persona = personaRepository.findByNroLegaj(g.getNro_legaj());

      if (persona.isPresent()) {
        Optional<Liquidacion> liquidacion = liquidacionRepository.findByNroLiquidacionAndPersonaId(g.getNro_liqui(), persona.get().getId());
        if(liquidacion.isPresent()) {
        boolean existeImputacion = imputacionRepository.existsByLiquidacionIdAndCodnImput(liquidacion.get().getId(), g.getCodn_imput());
          if(!existeImputacion)
          {
            Imputacion i = new Imputacion();
          i.setLiquidacion(liquidacion.get());
          i.setCodnImput(i.getCodnImput());
          i.setCodnFuent(i.getCodnFuent());
          i.setCodnDepen(i.getCodnDepen());
          i.setNroInciso(i.getNroInciso());
          i.setPorcImput(i.getPorcImput());
          i.setImpGasto(i.getImpGasto());
          i.setImpBruto(i.getImpBruto());
          i.setImpNetos(i.getImpNetos());
          i.setImpDctos(i.getImpDctos());
          i.setImpAport(i.getImpAport());
          i.setImpFliar(i.getImpFliar());

          imputacionRepository.save(i);
          }          
        }
      }
    }
  }
}

