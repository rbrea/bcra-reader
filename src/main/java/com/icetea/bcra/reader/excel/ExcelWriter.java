package com.icetea.bcra.reader.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.icetea.bcra.reader.utils.DateUtils;

public class ExcelWriter {
	
	private static final ExcelWriter INSTANCE = new ExcelWriter();
	
	private ExcelWriter() {
		super();
	}

	public static ExcelWriter getInstance() {
		return INSTANCE;
	}

	public boolean write(List<ExcelStats> excelStatsList) throws IOException {
		
		List<String> columnHeaders = ColumnHeaderListFactory.instance().create();
		
		Workbook workbook = new XSSFWorkbook();
		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Datos del BCRA");

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Cell cell = headerRow.createCell(0);
		// cell.setCellValue("Fecha");
		// cell.setCellStyle(headerCellStyle);
		// Create cells
		for (int i = 0; i < columnHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnHeaders.get(i));
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (ExcelStats excelStats : excelStatsList) {
			Row row = sheet.createRow(rowNum++);

			Cell nowCell = row.createCell(0);
			nowCell.setCellValue(excelStats.getNow());
			nowCell.setCellStyle(dateCellStyle);
			
			CellCreator.createNumericCell(row, 1, excelStats.getUva());
			CellCreator.createNumericCell(row, 2, excelStats.getUvi());
			CellCreator.createNumericCell(row, 3, excelStats.getReservasInternacionales());
			CellCreator.createNumericCell(row, 4, excelStats.getBaseMonetaria());
			CellCreator.createNumericCell(row, 5, excelStats.getCirculacionMonetaria());
			CellCreator.createNumericCell(row, 6, excelStats.getBilletesMonedasPoderPublico());
			CellCreator.createNumericCell(row, 7, excelStats.getEfectivoEntidadesFinancieras());
			CellCreator.createNumericCell(row, 8, excelStats.getDepositosCtaCte());
			CellCreator.createNumericCell(row, 9, excelStats.getLebacEfectivo());
			CellCreator.createNumericCell(row, 10, excelStats.getLebacNominal());
			CellCreator.createNumericCell(row, 11, excelStats.getDepositoEfectivoEntidadesFinancieras());
			CellCreator.createNumericCell(row, 12, excelStats.getFuco());
			CellCreator.createNumericCell(row, 13, excelStats.getCajaDeAhorros());
			CellCreator.createNumericCell(row, 14, excelStats.getaPlazo());
			CellCreator.createNumericCell(row, 15, excelStats.getM2Privado());
			CellCreator.createNumericCell(row, 16, excelStats.getTasasInteresLebac());
			CellCreator.createNumericCell(row, 17, excelStats.getTasasInteresPaseActivas());
			CellCreator.createNumericCell(row, 18, excelStats.getTasasInteresPasePasivas());
			CellCreator.createNumericCell(row, 19, excelStats.getPrestamoEntidadesFinancierasPrivadas());
			CellCreator.createNumericCell(row, 20, excelStats.getTasasInteresPrestamosEntidadesFinancierasPrivadas());
			CellCreator.createNumericCell(row, 21, excelStats.getTasasInteresDepositos30dias());
			CellCreator.createNumericCell(row, 22, excelStats.getBadlar());
			CellCreator.createNumericCell(row, 23, excelStats.getTm20());
			CellCreator.createNumericCell(row, 24, excelStats.getTipoCambioReferencia());
			CellCreator.createNumericCell(row, 25, excelStats.getCer());
			
			CellCreator.createNumericCell(row, 26, excelStats.getUsdBaseMonetaria());
			CellCreator.createNumericCell(row, 27, excelStats.getParidadUsdBaseMonetaria());
			CellCreator.createNumericCell(row, 28, excelStats.getUsdCircMonetaria());
			CellCreator.createNumericCell(row, 29, excelStats.getParidadUsdCircMonetaria());
			CellCreator.createNumericCell(row, 30, excelStats.getDepositoCajaAhorrosUsd());
			CellCreator.createNumericCell(row, 31, excelStats.getLebacsUsd());
			CellCreator.createNumericCell(row, 32, excelStats.getReservasMenosLebacs());
			CellCreator.createNumericCell(row, 33, excelStats.getUsdBaseMonetariaLebacs());
		}

		final int finalSize = excelStatsList.size() + 1;

		// Resize all columns to fit the content size
//		for (int i = 0; i < finalSize; i++) {
//			sheet.autoSizeColumn(i);
//		}

		// Write the output to a file
		
		DateUtils.nowString();
		
		FileOutputStream fileOut = new FileOutputStream("bcra_stats_" + DateUtils.toDate(DateUtils.now(), DateUtils.FILE_PATTERN)+ ".xlsx");
		workbook.write(fileOut);
		fileOut.close();
		// Closing the workbook
		workbook.close();

		return true;
	}

}
