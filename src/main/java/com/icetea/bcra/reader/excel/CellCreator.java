package com.icetea.bcra.reader.excel;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.icetea.bcra.reader.utils.NumberUtils;

public class CellCreator {
	
	public static Cell createNumericCell(Row row, int columnIndex, BigDecimal value) {

		Cell cell = row.createCell(columnIndex);
        cell.setCellValue(NumberUtils.toDouble(NumberUtils.toString(value)));
        cell.setCellType(CellType.NUMERIC);
        
        return cell;
	}
	
	public static Cell createDateCell(Row row, int columnIndex, CellStyle cellStyle, Date date) {
		Cell cell = row.createCell(0);
        cell.setCellValue(date);
        cell.setCellStyle(cellStyle);
        
        return cell;
	}
	
}
