package com.val.gerencial.service;

import com.val.gerencial.model.Gerencial;
import com.val.gerencial.model.ResumenGerencialDTO;
import com.val.gerencial.repository.GerencialRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class GerencialService {

    @Autowired
    private GerencialRepository gerencialRepository;

    public void procesarArchivo(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        boolean primeraFila = true;
        for (Row row : sheet) {
            if (primeraFila) {
                primeraFila = false;
                continue;
            }

            Gerencial g = new Gerencial();
            g.setNro_legaj((int) row.getCell(5).getNumericCellValue());
            g.setDesc_apyno(row.getCell(6).getStringCellValue());
            g.setNro_cargo((int) row.getCell(9).getNumericCellValue());
            // completar con más setters si es necesario

            gerencialRepository.save(g);
        }
        workbook.close();
    }

    public ResumenGerencialDTO obtenerResumen() {
        int cantidadCargos = (int) gerencialRepository.count();
        int cantidadDocentes = (int) gerencialRepository.findAll().stream()
                .map(Gerencial::getNro_legaj)
                .distinct()
                .count();
        return new ResumenGerencialDTO(cantidadCargos, cantidadDocentes);
    }

    public List<Gerencial> listarTodo() {
        return gerencialRepository.findAll();
    }
}
