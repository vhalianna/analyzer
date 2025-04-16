package com.val.gerencial.service;

import com.val.gerencial.model.*;
import com.val.gerencial.repository.GerencialRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            System.out.println("✅ 222B1");

            //g.setNro_liqui(row.getCell(27).getStringCellValue());
            g.setNro_liqui(obtenerTextoDeCelda(row.getCell(27)));

            System.out.println("✅ 222B1");

            g.setTipo_estad(row.getCell(28).getStringCellValue());

            System.out.println("✅ 222B2");

            //g.setCuil(row.getCell(29).getStringCellValue());
            g.setCuil(obtenerTextoDeCelda(row.getCell(29)));
            
            System.out.println("✅ 222C");
            
            g.setHs_catedra((int) row.getCell(30).getNumericCellValue());
            g.setDias_trab((int) row.getCell(31).getNumericCellValue());

            System.out.println("✅ 333");

            g.setRem_c_apor(row.getCell(32).getNumericCellValue());
            g.setOtr_no_rem(row.getCell(33).getNumericCellValue());
            g.setRem_s_apor(row.getCell(34).getNumericCellValue());
            g.setPorc_aplic(row.getCell(35).getNumericCellValue());

            System.out.println("✅ 333A");

            //g.setCoddependesemp((int) row.getCell(36).getNumericCellValue());
            g.setCoddependesemp(obtenerEnteroDeCelda(row.getCell(36)));

            System.out.println("✅ 333A1");

            g.setCod_clasif_cargo(row.getCell(37).getStringCellValue());

            System.out.println("✅ 333B");

            g.setTipo_carac(TipoCaracter.valueOf(row.getCell(38).getStringCellValue()));
            g.setEn_banco(row.getCell(39).getStringCellValue());
            System.out.println("✅ 333C");
            g.setCodigo_banco((int) row.getCell(40).getNumericCellValue());

            gerencialRepository.save(g);
        }
        workbook.close();
    }

    public void procesarCsv(MultipartFile file) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        String linea;
        boolean primeraFila = true;

        while ((linea = reader.readLine()) != null) {
            if (primeraFila) {
                primeraFila = false;
                continue;
            }

            String[] columnas = linea.split(",");

            Gerencial g = new Gerencial();
            g.setCodn_fuent(Integer.parseInt(columnas[0]));
            g.setCodn_depen(Integer.parseInt(columnas[1]));
            g.setCodn_imput(columnas[2]);
            g.setNro_inciso(Integer.parseInt(columnas[3]));
            g.setNro_legaj(Integer.parseInt(columnas[4]));
            g.setDesc_apyno(columnas[5]);
            g.setCant_anios(Integer.parseInt(columnas[6]));
            g.setAno_antig(Integer.parseInt(columnas[7]));
            g.setMes_antig(Integer.parseInt(columnas[8]));
            g.setNro_cargo(Integer.parseInt(columnas[9]));
            g.setCodc_categ(Categoria.valueOf(columnas[10]));
            g.setCodc_dedic(Dedicacion.valueOf(columnas[11]));
            g.setTipo_escal(columnas[12]);
            g.setCodc_carac(Caracter.valueOf(columnas[13]));
            g.setCodc_uacad(Integer.parseInt(columnas[14]));
            g.setCodc_regio(columnas[15]);
            g.setFec_alta(LocalDate.parse(columnas[16]));
            g.setFec_baja(LocalDate.parse(columnas[17]));
            g.setPorc_imput(Double.parseDouble(columnas[18]));
            g.setImp_gasto(Double.parseDouble(columnas[19]));
            g.setImp_bruto(Double.parseDouble(columnas[20]));
            g.setImp_netos(Double.parseDouble(columnas[21]));
            g.setImp_dctos(Double.parseDouble(columnas[22]));
            g.setImp_aport(Double.parseDouble(columnas[23]));
            g.setImp_fliar(Double.parseDouble(columnas[24]));
            g.setAno_liqui(Integer.parseInt(columnas[25]));
            g.setMes_liqui(Integer.parseInt(columnas[26]));
            g.setNro_liqui(columnas[27]);
            g.setTipo_estad(columnas[28]);
            g.setCuil(columnas[29]);
            g.setHs_catedra(Integer.parseInt(columnas[30]));
            g.setDias_trab(Integer.parseInt(columnas[31]));
            g.setRem_c_apor(Double.parseDouble(columnas[32]));
            g.setOtr_no_rem(Double.parseDouble(columnas[33]));
            g.setRem_s_apor(Double.parseDouble(columnas[34]));
            g.setPorc_aplic(Double.parseDouble(columnas[35]));
            g.setCoddependesemp(Integer.parseInt(columnas[36]));
            g.setCod_clasif_cargo(columnas[37]);
            g.setTipo_carac(TipoCaracter.valueOf(columnas[38]));
            g.setEn_banco(columnas[39]);
            g.setCodigo_banco(Integer.parseInt(columnas[40]));

            gerencialRepository.save(g);
        }
    }
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
