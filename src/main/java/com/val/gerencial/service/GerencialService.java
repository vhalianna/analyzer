package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.GerencialRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class GerencialService {

    @Autowired
    private GerencialRepository gerencialRepository;

    private String obtenerTextoDeCelda(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue()); // sin decimales
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula(); // opcional según tu uso
            default -> "";
        };
    }

    private int obtenerEnteroDeCelda(Cell cell) {
        if (cell == null) return 0;
        return switch (cell.getCellType()) {
            case NUMERIC -> (int) cell.getNumericCellValue();
            case STRING -> {
                String texto = cell.getStringCellValue().trim();
                yield texto.isEmpty() ? 0 : Integer.parseInt(texto);
            }
            default -> 0;
        };
    }

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

            g.setCodn_fuent((int) row.getCell(0).getNumericCellValue());
            g.setCodn_depen((int) row.getCell(1).getNumericCellValue());
            g.setCodn_imput(row.getCell(2).getStringCellValue());
            g.setNro_inciso((int) row.getCell(3).getNumericCellValue());
            g.setNro_legaj((int) row.getCell(4).getNumericCellValue());
            g.setDesc_apyno(row.getCell(5).getStringCellValue());
            g.setCant_anios((int) row.getCell(6).getNumericCellValue());
            g.setAno_antig((int) row.getCell(7).getNumericCellValue());
            g.setMes_antig((int) row.getCell(8).getNumericCellValue());
            g.setNro_cargo((int) row.getCell(9).getNumericCellValue());

            g.setCodc_categ(Categoria.valueOf(row.getCell(10).getStringCellValue()));
            g.setCodc_dedic(Dedicacion.valueOf(row.getCell(11).getStringCellValue()));
            g.setTipo_escal(row.getCell(12).getStringCellValue());

            g.setCodc_carac(Caracter.valueOf(row.getCell(13).getStringCellValue()));
            String valorCrudo = row.getCell(14).getStringCellValue().trim();
            g.setCodc_uacad(Integer.parseInt(valorCrudo));
            g.setCodc_regio(row.getCell(15).getStringCellValue());

            String fechaAltaStr = row.getCell(16).getStringCellValue().trim();
            if (!fechaAltaStr.isEmpty()) {
                g.setFec_alta(LocalDate.parse(fechaAltaStr));
            }
            
            String fechaBajaStr = row.getCell(17).getStringCellValue().trim();
            if (!fechaBajaStr.isEmpty()) {
                g.setFec_baja(LocalDate.parse(fechaBajaStr));
            }

            g.setPorc_imput(row.getCell(18).getNumericCellValue());

            g.setImp_gasto(row.getCell(19).getNumericCellValue());
            g.setImp_bruto(row.getCell(20).getNumericCellValue());
            g.setImp_netos(row.getCell(21).getNumericCellValue());

            g.setImp_dctos(row.getCell(22).getNumericCellValue());
            g.setImp_aport(row.getCell(23).getNumericCellValue());
            g.setImp_fliar(row.getCell(24).getNumericCellValue());

            g.setAno_liqui((int) row.getCell(25).getNumericCellValue());
            g.setMes_liqui((int) row.getCell(26).getNumericCellValue());

            //g.setNro_liqui(row.getCell(27).getStringCellValue());
            g.setNro_liqui(obtenerTextoDeCelda(row.getCell(27)));

            g.setTipo_estad(row.getCell(28).getStringCellValue());

            //g.setCuil(row.getCell(29).getStringCellValue());
            g.setCuil(obtenerTextoDeCelda(row.getCell(29)));
            
            g.setHs_catedra((int) row.getCell(30).getNumericCellValue());
            g.setDias_trab((int) row.getCell(31).getNumericCellValue());

            g.setRem_c_apor(row.getCell(32).getNumericCellValue());
            g.setOtr_no_rem(row.getCell(33).getNumericCellValue());
            g.setRem_s_apor(row.getCell(34).getNumericCellValue());
            g.setPorc_aplic(row.getCell(35).getNumericCellValue());

            //g.setCoddependesemp((int) row.getCell(36).getNumericCellValue());
            g.setCoddependesemp(obtenerEnteroDeCelda(row.getCell(36)));

            g.setCod_clasif_cargo(row.getCell(37).getStringCellValue());

            g.setTipo_carac(TipoCaracter.valueOf(row.getCell(38).getStringCellValue()));
            g.setEn_banco(row.getCell(39).getStringCellValue());

            g.setCodigo_banco((int) row.getCell(40).getNumericCellValue());

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
