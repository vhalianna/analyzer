package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.CargoRepository;
import com.val.gerencial.repository.GerencialRepository;
import com.val.gerencial.repository.LiquidacionRepository;
import com.val.gerencial.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiquidacionService {

  @Autowired
  private PersonaRepository personaRepository;

  @Autowired
  private CargoRepository cargoRepository;

  @Autowired
  private GerencialRepository gerencialRepository;

  @Autowired
  private LiquidacionRepository liquidacionRepository;

  public List<Liquidacion> findByPersonaId(Long id){
    return liquidacionRepository.findByPersonaId(id);
  }

  public void updateLiquidacion() {
    List<Gerencial> datosGerencial  = gerencialRepository.findAll();
    //Get all Diferent Personas insert into personas

    for (Gerencial g : datosGerencial) {
      // Verificamos si ya existe una persona con ese nro_legaj
      Optional<Persona> persona = personaRepository.findByNroLegaj(g.getNro_legaj());

      if (persona.isPresent()) {
        boolean existeLiquidacion = liquidacionRepository.existsByNroLiquidacionAndPersonaId(g.getNro_liqui(), persona.get().getId());
        if(!existeLiquidacion) {
          Liquidacion l = new Liquidacion();
          l.setPersona(persona.get());
          l.setAnoLiqui(l.getAnoLiqui());
          l.setMesLiqui(l.getMesLiqui());
          l.setNroLiqui(l.getNroLiqui());
          l.setDiasTrab(l.getDiasTrab());
          l.setRemCApor(l.getRemCApor());
          l.setRemSApor(l.getRemSApor());
          l.setPorcAplic(l.getPorcAplic());
          l.setEnBanco(l.getEnBanco());
          l.setCodigoBanco(l.getCodigoBanco());
          liquidacionRepository.save(l);
        }
      }
    }
  }

}
