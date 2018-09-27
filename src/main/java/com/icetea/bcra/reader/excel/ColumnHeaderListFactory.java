package com.icetea.bcra.reader.excel;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

public final class ColumnHeaderListFactory {

	private static final ColumnHeaderListFactory INSTANCE = new ColumnHeaderListFactory();

	private ColumnHeaderListFactory() {
		super();
	}

	public static ColumnHeaderListFactory instance() {
		return INSTANCE;
	}
	
	public List<String> create(){
		
		String columns = "FECHA,UVA,UVI,RESERVAS_INTERNACIONALES,BASE_MONETARIA,CIRCULACION_MONETARIA,BILLETES_MONEDAS_PODER_PUBLICO,EFECTIVO_ENTIDADES_FINANCIERAS,"
				+ "DEPOSITOS_CTA_CTE,LEBAC_EFECTIVO,LEBAC_NOMINAL,DEPOSITO_EFECTIVO_ENTIDADES_FINANCIERAS,FUCO,CAJA_DE_AHORROS,A_PLAZO,M2_PRIVADO,TASAS_INTERES_LEBAC,"
				+ "TASAS_INTERES_LEBAC_ACTIVAS,TASAS_INTERES_LEBAC_PASIVAS,PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,TASAS_INTERES_PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,"
				+ "TASAS_INTERES_DEPOSITOS_30_DIAS,BADLAR,TM_20,TIPO_CAMBIO_REFERENCIA,CER,USD_BASE_MONETARIA,PARIDAD_USD_BASE_MONETARIA,"
				+ "USD_CIRC_MONETARIA,PARIDAD_USD_CIRC_MONETARIA,DEPOSITO_CAJA_AHORROS_USD,LEBACS_USD,RESERVAS_MENOS_LEBACS,USD_BASE_MONETARIA_LEBACS";
		
		String[] splitted = StringUtils.split(columns, ",");
		
		return Lists.newArrayList(splitted);
	}
	
}
