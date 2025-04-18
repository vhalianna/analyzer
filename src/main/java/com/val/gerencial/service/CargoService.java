package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.CargoRepository;
import com.val.gerencial.repository.GerencialRepository;
import com.val.gerencial.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

  @Autowired
  private PersonaRepository personaRepository;

  @Autowired
  private CargoRepository cargoRepository;

  @Autowired
  private GerencialRepository gerencialRepository;

  public void updateCargo() {
    List<Gerencial> datosGerencial  = gerencialRepository.findAll();
    //Get all Diferent Personas insert into personas

    for (Gerencial g : datosGerencial) {
      // Verificamos si ya existe una persona con ese nro_legaj
      Optional<Persona> persona = personaRepository.findByNroLegaj(g.getNro_legaj());

      if (persona.isPresent()) {
        boolean existeCargo = cargoRepository.existsByNroCargo(g.getNro_cargo());
        if(!existeCargo)
          {


        Cargo c = new Cargo();
        c.setNroCargo(c.getNroCargo());
        c.setCodcCateg(c.getCodcCateg());
        c.setCodcCarac(c.getCodcCarac());
        c.setTipoCarac(c.getTipoCarac());
        c.setFecAlta(c.getFecAlta());
        c.setFecBaja(c.getFecBaja());
        c.setTipoEstad(c.getTipoEstad());
        c.setHsCatedra(c.getHsCatedra());
        c.setPersona(persona.get());
        cargoRepository.save(c);

          }
      }
    }
  }

}
