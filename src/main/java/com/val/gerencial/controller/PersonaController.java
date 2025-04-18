
package com.val.gerencial.controller;

import com.val.gerencial.model.Persona;
import com.val.gerencial.model.ResumenGerencialDTO;
import com.val.gerencial.service.GerencialService;
import com.val.gerencial.service.CargoService;

import com.val.gerencial.service.PersonaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    private final Logger log = LoggerFactory.getLogger(GerencialController.class);

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

}
