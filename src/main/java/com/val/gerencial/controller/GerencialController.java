package com.val.gerencial.controller;

import com.val.gerencial.model.Gerencial;
import com.val.gerencial.model.ResumenGerencialDTO;
import com.val.gerencial.service.GerencialService;
import com.val.gerencial.service.ImputacionService;
import com.val.gerencial.service.LiquidacionService;
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
@RequestMapping("/api/gerencial")
@CrossOrigin(origins = "http://localhost:4200")
public class GerencialController {

    private final Logger log = LoggerFactory.getLogger(GerencialController.class);

    @Autowired
    private GerencialService gerencialService;

    @Autowired
    PersonaService personaService;

    @Autowired
    CargoService cargoService;

    @Autowired
    LiquidacionService liquidacionService;

    @Autowired
    ImputacionService imputacionService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> subirArchivo(@RequestParam("file") MultipartFile file) {
        try {
            log.info("Comienzo Procesamiento Archivo: {}",file.getOriginalFilename());
            gerencialService.procesarArchivo(file);
            log.info("Comienzo Procesamiento Personas");
            personaService.updatePersona();
            log.info("Comienzo Procesamiento Cargos");
            cargoService.updateCargo();
            log.info("Comienzo Procesamiento Liquidaciones");
            liquidacionService.updateLiquidacion();
            log.info("Comienzo Procesamiento Imputaciones");
            imputacionService.updateImputacion();
            return ResponseEntity.ok("Archivo procesado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al procesar archivo: " + e.getMessage());
        }
    }

    @GetMapping("/resumen")
    public ResumenGerencialDTO obtenerResumen() {
        return gerencialService.obtenerResumen();
    }

    @GetMapping("/lista")
    public List<Gerencial> listarTodo() {
        return gerencialService.listarTodo();
    }
}
