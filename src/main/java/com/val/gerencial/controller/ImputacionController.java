package com.val.gerencial.controller;

import com.val.gerencial.model.Imputacion;

import com.val.gerencial.service.ImputacionService;
import com.val.gerencial.service.LiquidacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imputaciones")
@CrossOrigin(origins = "http://localhost:4200") // o el frontend real
public class ImputacionController {

    @Autowired
    private ImputacionService imputacionService;

    /*@GetMapping("/persona/{id}")
    public List<Imputacion> obtenerImputacionesPorLiquidacion(@PathVariable("id") Long id) {
        return imputacionService.findByPersonaId(id);
    }*/
}