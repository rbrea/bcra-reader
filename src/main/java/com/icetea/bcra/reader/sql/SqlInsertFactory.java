package com.icetea.bcra.reader.sql;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.icetea.bcra.reader.excel.ExcelStats;
import com.icetea.bcra.reader.utils.NumberUtils;

public class SqlInsertFactory {
	
	private static final SqlInsertFactory INSTANCE = new SqlInsertFactory();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	
	private SqlInsertFactory() {
		super();
	}

	public static SqlInsertFactory getInstance() {
		return INSTANCE;
	}
	
	public String create(ExcelStats input) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO bcra_data.BCRA_STATS\n" + 
				"(FECHA,UVA,UVI,RESERVAS_INTERNACIONALES,BASE_MONETARIA,CIRCULACION_MONETARIA,BILLETES_MONEDAS_PODER_PUBLICO,EFECTIVO_ENTIDADES_FINANCIERAS,"
				+ "DEPOSITOS_CTA_CTE,LEBAC_EFECTIVO,LEBAC_NOMINAL,DEPOSITO_EFECTIVO_ENTIDADES_FINANCIERAS,FUCO,CAJA_DE_AHORROS,A_PLAZO,M2_PRIVADO,"
				+ "TASAS_INTERES_LEBAC,TASAS_INTERES_LEBAC_ACTIVAS,TASAS_INTERES_LEBAC_PASIVAS,PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,"
				+ "TASAS_INTERES_PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,TASAS_INTERES_DEPOSITOS_30_DIAS,BADLAR,TM_20,TIPO_CAMBIO_REFERENCIA,CER,"
				+ "USD_BASE_MONETARIA,PARIDAD_USD_BASE_MONETARIA,USD_CIRC_MONETARIA,PARIDAD_USD_CIRC_MONETARIA,DEPOSITO_CAJA_AHORROS_USD,LEBACS_USD,"
				+ "RESERVAS_MENOS_LEBACS,USD_BASE_MONETARIA_LEBACS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		
		
//		
//		this.append(sb, input.getNow());
//		this.append(sb, input.getUva());
//		this.append(sb, input.getUvi());
//		this.append(sb, input.getReservasInternacionales());
//		this.append(sb, input.getBaseMonetaria());
//		this.append(sb, input.getCirculacionMonetaria());
//		this.append(sb, input.getBilletesMonedasPoderPublico());
//		this.append(sb, input.getEfectivoEntidadesFinancieras());
//		this.append(sb, input.getDepositosCtaCte());
//		this.append(sb, input.getLebacEfectivo());
//		this.append(sb, input.getLebacNominal());
//		this.append(sb, input.getDepositoEfectivoEntidadesFinancieras());
//		this.append(sb, input.getFuco());
//		this.append(sb, input.getCajaDeAhorros());
//		this.append(sb, input.getaPlazo());
//		this.append(sb, input.getM2Privado());
//		this.append(sb, input.getTasasInteresLebac());
//		this.append(sb, input.getTasasInteresPaseActivas());
//		this.append(sb, input.getTasasInteresPasePasivas());
//		this.append(sb, input.getPrestamoEntidadesFinancierasPrivadas());
//		this.append(sb, input.getTasasInteresPrestamosEntidadesFinancierasPrivadas());
//		this.append(sb, input.getTasasInteresDepositos30dias());
//		this.append(sb, input.getBadlar());
//		this.append(sb, input.getTm20());
//		this.append(sb, input.getTipoCambioReferencia());
//		this.append(sb, input.getCer());
//		
//		BigDecimal usdBaseMonetaria = NumberUtils.divide(input.getBaseMonetaria(), input.getReservasInternacionales());
//		BigDecimal usdCircMonetaria = NumberUtils.divide(input.getCirculacionMonetaria(), input.getReservasInternacionales());
//		
//		this.append(sb, usdBaseMonetaria); 
//		this.append(sb, NumberUtils.subtract(BigDecimal.ONE, NumberUtils.divide(usdBaseMonetaria, input.getTipoCambioReferencia())));
//		this.append(sb, usdCircMonetaria);
//		this.append(sb, NumberUtils.subtract(BigDecimal.ONE, NumberUtils.divide(usdCircMonetaria, input.getTipoCambioReferencia())));
//		this.append(sb, NumberUtils.divide(input.getCajaDeAhorros(), input.getReservasInternacionales()));
//		this.append(sb, NumberUtils.divide(input.getLebacEfectivo(), input.getReservasInternacionales()));
//		this.append(sb, NumberUtils.subtract(input.getReservasInternacionales(), input.getLebacEfectivo()));
//		
//		this.append(sb, NumberUtils.divide(NumberUtils.add(input.getBaseMonetaria(), input.getLebacEfectivo()), input.getReservasInternacionales()));
//		
//		sb.append(");");
		
		return sb.toString();
	}
	
	private void append(StringBuffer sb, BigDecimal value) {
		sb.append(NumberUtils.toString(value));
	}
	
	private void append(StringBuffer sb, Date value) {
		sb.append("'").append(sdf.format(value)).append("'");
	}

}
