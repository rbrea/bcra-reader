package com.icetea.bcra.reader;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.HttpStatusException;

import com.google.common.collect.Lists;
import com.icetea.bcra.reader.dto.PieceDTO;
import com.icetea.bcra.reader.excel.ExcelStats;
import com.icetea.bcra.reader.excel.ExcelWriter;
import com.icetea.bcra.reader.helper.DocumentHelper;
import com.icetea.bcra.reader.sql.SqlProcessor;
import com.icetea.bcra.reader.transformer.PieceTransformer;

public class BcraReader {

	public static void main(String[] args) throws IOException, ParseException {
		
		DocumentHelper documentHelper = DocumentHelper.getInstance();

//		Date date = DateUtils.addDays(new Date(), -20);
		
		Date date = SqlProcessor.getInstance().getLastProcessedDate();
		if(date == null) {
			date = SqlProcessor.initialDate();
		} else {
			date = DateUtils.addDays(date, 1);
		}
		Date now = new Date();
		Date toTransformDate = null;
		
		while(date.before(now)) {
			try {
				List<PieceDTO> pieces = documentHelper.buildDocument(date);

				toTransformDate = date;

				if(CollectionUtils.isEmpty(pieces)) {
					continue;
				}
				
				ExcelStats excelStats = PieceTransformer.getInstance().transform(pieces, toTransformDate);
				
				SqlProcessor.getInstance().insert(excelStats);
			} catch (HttpStatusException e) {
				System.out.println("error 500 de conexion: " + e.getMessage());
			}

			date = DateUtils.addDays(date, 1);
			
		}
		System.out.println("to write excel file.");
		
		List<ExcelStats> excelStatsList = SqlProcessor.getInstance().getAll();
		
		ExcelWriter.getInstance().write(excelStatsList);
		
		System.out.println("the END");
	}
	
}
