package com.icetea.bcra.reader.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;
import com.icetea.bcra.reader.dto.PieceDTO;
import com.icetea.bcra.reader.utils.StringUtils;

public class DocumentHelper {
	
	private static final DocumentHelper INSTANCE = new DocumentHelper();
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static DocumentHelper getInstance() {
		return INSTANCE;
	}
	
	private DocumentHelper() {
		super();
	}

	public List<PieceDTO> buildDocument(Date date) throws IOException {
		List<PieceDTO> pieces = Lists.newArrayList();
		
		String dateFormatted = this.sdf.format(date);
		String url = "http://www.bcra.gov.ar/PublicacionesEstadisticas/Principales_variables.asp?FechaCons=" + dateFormatted;
		System.out.println("calling to Url: " + url);
		Document doc = Jsoup.connect(url).get();
		Elements tableElements = doc.select("table");
		for(Element tableElement: tableElements) {
			if(tableElement.hasClass("table-BCRA")) {
				Elements tbodys = tableElement.select("tbody");
				Element tbody = tbodys.get(0);
				Elements trList = tbody.select("tr");
				for(Element tr : trList) {
					Elements tdList = tr.getAllElements();
					String columnName = tdList.get(0).text();
					String valueName = tdList.get(3).text();
					if(StringUtils.contains(columnName, "Reservas Internacionales del BCRA ")) {
						if(StringUtils.contains(valueName, "N/D")) {
							return Lists.newArrayList();
						}
					}
					pieces.add(new PieceDTO(columnName, valueName));
				}
				break;
			}
		}
		
		return pieces;
	}
	
}
