package com.ghamanager.relatorio;

import com.ghamanager.persistencia.Equipamento;
import com.ghamanager.persistencia.Funcionario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;

public class Relatorio {

    public void relatorioFuncionario(List<Funcionario> funcionarios, String caminhoArquivo) throws IOException {

        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {

            Sheet sheetFunc = workbook.createSheet("Relatório de Funcionários");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);

            Row headerRow = sheetFunc.createRow(0);
            String[] colunasFunc = {"Nome", "Matrícula", "Função", "Setor"};

            for (int i = 0; i < colunasFunc.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(colunasFunc[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Funcionario func : funcionarios) {
                Row row = sheetFunc.createRow(rowNum++);

                row.createCell(0).setCellValue(func.getNome() != null ? func.getNome() : "");
                row.createCell(1).setCellValue(func.getMatricula() != null ? func.getMatricula() : "");
                row.createCell(2).setCellValue(func.getFuncao() != null ? func.getFuncao() : "");
                row.createCell(3).setCellValue(func.getSetor() != null ? func.getSetor() : "");

                row.createCell(4).setCellValue(String.valueOf(func.getDemitido()));
            }

            for (int i = 0; i < colunasFunc.length; i++) {
                sheetFunc.autoSizeColumn(i);
            }

            workbook.write(fileOut);

        }
    }

      public void relatorioEquipamentos(List<Equipamento> equipamento, String caminhoArquivo) throws IOException {

        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {

            Sheet sheetFunc = workbook.createSheet("Relatório de Equipamento");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);

            Row headerRow = sheetFunc.createRow(0);
            String[] colunasFunc = {"Patrimônio", "Tipo do Equipamento", "Em uso", "Transferido"};

            for (int i = 0; i < colunasFunc.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(colunasFunc[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Equipamento eqp : equipamento) {
                Row row = sheetFunc.createRow(rowNum++);

                row.createCell(0).setCellValue(eqp.getPatrimonio());
                row.createCell(1).setCellValue(eqp.getTipoDoEquipamento());
                row.createCell(2).setCellValue(eqp.getEmUso());
                row.createCell(3).setCellValue(eqp.getTransferido());
            }

            for (int i = 0; i < colunasFunc.length; i++) {
                sheetFunc.autoSizeColumn(i);
            }

            workbook.write(fileOut);

        }
    }
    
}
