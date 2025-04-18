package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.GerencialRepository;
import com.val.gerencial.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private GerencialRepository gerencialRepository;

    public List<Persona> getPersonas () {
        return personaRepository.findAll();
    }

    public void updatePersona() {
        List<Gerencial> datosGerencial  = gerencialRepository.findAll();
        //Get all Diferent Personas iinsert into personas

        for (Gerencial g : datosGerencial) {
            // Verificamos si ya existe una persona con ese nro_legaj
            boolean existe = personaRepository.existsByNroLegaj(g.getNro_legaj());
            if (!existe) {
                Persona p = new Persona();
                p.setNroLegaj(g.getNro_legaj());
                p.setDescApyno(g.getDesc_apyno());
                p.setCuil(g.getCuil());
                p.setCantAnios(g.getCant_anios());
                p.setAnoAntig(g.getAno_antig());
                p.setMesAntig(g.getMes_antig());
                p.setTipoEscal(g.getTipo_escal());

                personaRepository.save(p);
            }
        }
    }
    
}
