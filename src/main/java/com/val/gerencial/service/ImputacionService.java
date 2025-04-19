package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.CargoRepository;
import com.val.gerencial.repository.GerencialRepository;
import com.val.gerencial.repository.ImputacionRepository;
import com.val.gerencial.repository.LiquidacionRepository;
import com.val.gerencial.repository.PersonaRepository;
import com.val.gerencial.repository.PartidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImputacionService {

  @Autowired
  private PersonaRepository personaRepository;

  @Autowired
  private CargoRepository cargoRepository;

  @Autowired
  private ImputacionRepository imputacionRepository;

  @Autowired
  private LiquidacionRepository liquidacionRepository;

  @Autowired
  private GerencialRepository gerencialRepository;

  @Autowired 
  private PartidaRepository partidaRepository;

  public List<Imputacion> findByLiquidacionId(Long id){
    return imputacionRepository.findByLiquidacionId(id);
  }

  public void updateImputacion() {
    List<Gerencial> datosGerencial  = gerencialRepository.findAll();
    //Get all Diferent Personas insert into personas

    for (Gerencial g : datosGerencial) {
      // Verificamos si ya existe una persona con ese nro_legaj
      Optional<Persona> persona = personaRepository.findByNroLegaj(g.getNro_legaj());
      Optional<Cargo> cargo = cargoRepository.findByNroCargo(g.getNro_cargo());

      if (persona.isPresent() && cargo.isPresent()) {
        
        Optional<Partida> partida = partidaRepository.findByCodigo(g.getCodn_imput());
        Partida p = new Partida();
        if(!partida.isPresent() ) {
          p = new Partida(g.getCodn_imput());
          p = partidaRepository.save(p);
        } else {
          p = partida.get();
        }

        Optional<Liquidacion> liquidacion = liquidacionRepository.findByNroLiquiAndPersonaIdAndCargoId(g.getNro_liqui(), persona.get().getId(),cargo.get().getId());
        if(liquidacion.isPresent() ) {
        boolean existeImputacion = imputacionRepository.existsByLiquidacionIdAndPartidaId(liquidacion.get().getId(), p.getId());
          if(!existeImputacion)
          {
            Imputacion i = new Imputacion();
          i.setLiquidacion(liquidacion.get());
          i.setPartida(p);
          i.setCodnFuent(g.getCodn_fuent());
          i.setCodnDepen(g.getCodn_depen());
          i.setNroInciso(g.getNro_inciso());
          i.setPorcImput(g.getPorc_imput());
          i.setImpGasto(g.getImp_gasto());
          i.setImpBruto(g.getImp_bruto());
          i.setImpNetos(g.getImp_netos());
          i.setImpDctos(g.getImp_dctos());
          i.setImpAport(g.getImp_aport());
          i.setImpFliar(g.getImp_fliar());
          imputacionRepository.save(i); 
          }          
        }
      }
    }
  }
}

