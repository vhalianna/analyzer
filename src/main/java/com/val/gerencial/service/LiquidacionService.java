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
  private GerencialRepository gerencialRepository;

  @Autowired
  private CargoRepository cargoRepository;

  @Autowired
  private LiquidacionRepository liquidacionRepository;

  public List<Liquidacion> findByPersonaId(Long id){
    return liquidacionRepository.findByPersonaId(id);
  }
  
  public List<Liquidacion> findByCargoId(Long id){
    return liquidacionRepository.findByCargoId(id);
  }
  

  public void updateLiquidacion() {
    List<Gerencial> datosGerencial  = gerencialRepository.findAll();
    //Get all Diferent Personas insert into personas

    for (Gerencial g : datosGerencial) {
      // Verificamos si ya existe una persona con ese nro_legaj
      Optional<Persona> persona = personaRepository.findByNroLegaj(g.getNro_legaj());
      Optional<Cargo> cargo = cargoRepository.findByNroCargo(g.getNro_cargo());

      if (persona.isPresent() && cargo.isPresent()) {
        boolean existeLiquidacion = liquidacionRepository.existsByNroLiquiAndPersonaIdAndCargoId(g.getNro_liqui(), persona.get().getId(),cargo.get().getId());
        if(!existeLiquidacion) {
          Liquidacion l = new Liquidacion();
          l.setPersona(persona.get());
          l.setCargo(cargo.get());
          l.setAnoLiqui(g.getAno_liqui());
          l.setMesLiqui(g.getMes_liqui());
          l.setNroLiqui(g.getNro_liqui());
          l.setDiasTrab(g.getDias_trab());
          l.setRemCApor(g.getRem_c_apor());
          l.setRemSApor(g.getRem_s_apor());
          l.setPorcAplic(g.getPorc_aplic());
          l.setEnBanco(g.getEn_banco());
          l.setCodigoBanco(g.getCodigo_banco());
          liquidacionRepository.save(l);
        }
      }
    }
  }

}
