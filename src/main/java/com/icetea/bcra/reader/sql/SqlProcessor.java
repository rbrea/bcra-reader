package com.icetea.bcra.reader.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.icetea.bcra.reader.excel.ExcelStats;
import com.icetea.bcra.reader.utils.NumberUtils;

public class SqlProcessor {
	
	private static final SqlProcessor INSTANCE = new SqlProcessor();
	
	private static final String URL = "jdbc:mysql://localhost:3306";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "/bcra_data";
	
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public static final SimpleDateFormat SDF_SQL = new SimpleDateFormat("yyyy-MM-dd");
	
	public static SqlProcessor getInstance() {
		return INSTANCE;
	}
	
	private SqlProcessor() {
		super();
	}

	public void insert(ExcelStats excelStats) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(URL + DB_NAME, "root", "admin");
			if(!conn.isClosed()) {
				
				PreparedStatement stmt = conn.prepareStatement(SqlInsertFactory.getInstance().create(excelStats));
				
				stmt.setDate(1, java.sql.Date.valueOf(SDF_SQL.format(excelStats.getNow())));
				stmt.setBigDecimal(2, excelStats.getUva());
				stmt.setBigDecimal(3, excelStats.getUvi());
				stmt.setBigDecimal(4, excelStats.getReservasInternacionales());
				stmt.setBigDecimal(5, excelStats.getBaseMonetaria());
				stmt.setBigDecimal(6, excelStats.getCirculacionMonetaria());
				stmt.setBigDecimal(7, excelStats.getBilletesMonedasPoderPublico());
				stmt.setBigDecimal(8, excelStats.getEfectivoEntidadesFinancieras());
				stmt.setBigDecimal(9, excelStats.getDepositosCtaCte());
				stmt.setBigDecimal(10, excelStats.getLebacEfectivo());
				stmt.setBigDecimal(11, excelStats.getLebacNominal());
				stmt.setBigDecimal(12, excelStats.getDepositoEfectivoEntidadesFinancieras());
				stmt.setBigDecimal(13, excelStats.getFuco());
				stmt.setBigDecimal(14, excelStats.getCajaDeAhorros());
				stmt.setBigDecimal(15, excelStats.getaPlazo());
				stmt.setBigDecimal(16, excelStats.getM2Privado());
				stmt.setBigDecimal(17, excelStats.getTasasInteresLebac());
				stmt.setBigDecimal(18, excelStats.getTasasInteresPaseActivas());
				stmt.setBigDecimal(19, excelStats.getTasasInteresPasePasivas());
				stmt.setBigDecimal(20, excelStats.getPrestamoEntidadesFinancierasPrivadas());
				stmt.setBigDecimal(21, excelStats.getTasasInteresPrestamosEntidadesFinancierasPrivadas());
				stmt.setBigDecimal(22, excelStats.getTasasInteresDepositos30dias());
				stmt.setBigDecimal(23, excelStats.getBadlar());
				stmt.setBigDecimal(24, excelStats.getTm20());
				stmt.setBigDecimal(25, excelStats.getTipoCambioReferencia());
				stmt.setBigDecimal(26, excelStats.getCer());
				
				BigDecimal usdBaseMonetaria = NumberUtils.divide(excelStats.getBaseMonetaria(), excelStats.getReservasInternacionales());
				BigDecimal usdCircMonetaria = NumberUtils.divide(excelStats.getCirculacionMonetaria(), excelStats.getReservasInternacionales());
				
				stmt.setBigDecimal(27, usdBaseMonetaria);
				stmt.setBigDecimal(28, NumberUtils.subtract(BigDecimal.ONE, NumberUtils.divide(usdBaseMonetaria, excelStats.getTipoCambioReferencia())));
				stmt.setBigDecimal(29, usdCircMonetaria);
				stmt.setBigDecimal(30, NumberUtils.subtract(BigDecimal.ONE, NumberUtils.divide(usdCircMonetaria, excelStats.getTipoCambioReferencia())));
				stmt.setBigDecimal(31, NumberUtils.divide(excelStats.getCajaDeAhorros(), excelStats.getReservasInternacionales()));
				stmt.setBigDecimal(32,NumberUtils.divide(excelStats.getLebacEfectivo(), excelStats.getReservasInternacionales()));
				stmt.setBigDecimal(33,  NumberUtils.subtract(excelStats.getReservasInternacionales(), excelStats.getLebacEfectivo()));
				stmt.setBigDecimal(34,NumberUtils.divide(NumberUtils.add(excelStats.getBaseMonetaria(), excelStats.getLebacEfectivo()), excelStats.getReservasInternacionales()));
				
				int r = stmt.executeUpdate();
				
				System.out.println("Inserted count: " + r);
				
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Date getLastProcessedDate() throws ParseException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(URL + DB_NAME, "root", "admin");
			if(!conn.isClosed()) {
				stmt = conn.prepareStatement("SELECT MAX(FECHA) FROM BCRA_STATS;");
				ResultSet r = stmt.executeQuery();
				
				while(r.next()) {
					if(r.wasNull()) {
						return initialDate(); 
					}
					return r.getDate(1);
				}
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return initialDate();
	}
	
	public static Date initialDate() {
		try {
			return SDF.parse("2004-09-01 00:00:00");
		} catch (ParseException e) {
			return null;
		}
	}
	
	public List<ExcelStats> getAll() throws ParseException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		List<ExcelStats> resultList = Lists.newArrayList();
		
		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(URL + DB_NAME, "root", "admin");
			if(!conn.isClosed()) {
				stmt = conn.prepareStatement("SELECT FECHA,UVA,UVI,RESERVAS_INTERNACIONALES,BASE_MONETARIA,CIRCULACION_MONETARIA,BILLETES_MONEDAS_PODER_PUBLICO,EFECTIVO_ENTIDADES_FINANCIERAS,"
						+ "DEPOSITOS_CTA_CTE,LEBAC_EFECTIVO,LEBAC_NOMINAL,DEPOSITO_EFECTIVO_ENTIDADES_FINANCIERAS,FUCO,CAJA_DE_AHORROS,A_PLAZO,M2_PRIVADO,TASAS_INTERES_LEBAC,"
						+ "TASAS_INTERES_LEBAC_ACTIVAS,TASAS_INTERES_LEBAC_PASIVAS,PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,TASAS_INTERES_PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS,"
						+ "TASAS_INTERES_DEPOSITOS_30_DIAS,BADLAR,TM_20,TIPO_CAMBIO_REFERENCIA,CER,"
						+ "USD_BASE_MONETARIA,"
						+ "PARIDAD_USD_BASE_MONETARIA,"
						+ "USD_CIRC_MONETARIA,"
						+ "PARIDAD_USD_CIRC_MONETARIA,"
						+ "DEPOSITO_CAJA_AHORROS_USD,"
						+ "LEBACS_USD,"
						+ "RESERVAS_MENOS_LEBACS,"
						+ "USD_BASE_MONETARIA_LEBACS "
						+ "FROM BCRA_STATS;");
				ResultSet r = stmt.executeQuery();
				
				while(r.next()) {
					
					ExcelStats excelStats = new ExcelStats();
					excelStats.setNow(r.getDate(1));
					excelStats.setUva(r.getBigDecimal(2));
					excelStats.setUvi(r.getBigDecimal(3));
					excelStats.setReservasInternacionales(r.getBigDecimal(4));
					excelStats.setBaseMonetaria(r.getBigDecimal(5));
					excelStats.setCirculacionMonetaria(r.getBigDecimal(6));
					excelStats.setBilletesMonedasPoderPublico(r.getBigDecimal(7));
					excelStats.setEfectivoEntidadesFinancieras(r.getBigDecimal(8));
					excelStats.setDepositosCtaCte(r.getBigDecimal(9));
					excelStats.setLebacEfectivo(r.getBigDecimal(10));
					excelStats.setLebacNominal(r.getBigDecimal(11));
					excelStats.setDepositoEfectivoEntidadesFinancieras(r.getBigDecimal(12));
					excelStats.setFuco(r.getBigDecimal(13));
					excelStats.setCajaDeAhorros(r.getBigDecimal(14));
					excelStats.setaPlazo(r.getBigDecimal(15));
					excelStats.setM2Privado(r.getBigDecimal(16));
					excelStats.setTasasInteresLebac(r.getBigDecimal(17));
					excelStats.setTasasInteresPaseActivas(r.getBigDecimal(18));
					excelStats.setTasasInteresPasePasivas(r.getBigDecimal(19));
					excelStats.setPrestamoEntidadesFinancierasPrivadas(r.getBigDecimal(20));
					excelStats.setTasasInteresPrestamosEntidadesFinancierasPrivadas(r.getBigDecimal(21));
					excelStats.setTasasInteresDepositos30dias(r.getBigDecimal(22));
					excelStats.setBadlar(r.getBigDecimal(23));
					excelStats.setTm20(r.getBigDecimal(24));
					excelStats.setTipoCambioReferencia(r.getBigDecimal(25));
					excelStats.setCer(r.getBigDecimal(26));
					excelStats.setUsdBaseMonetaria(r.getBigDecimal(27));
					excelStats.setParidadUsdBaseMonetaria(r.getBigDecimal(28));
					excelStats.setUsdCircMonetaria(r.getBigDecimal(29));
					excelStats.setParidadUsdCircMonetaria(r.getBigDecimal(30));
					excelStats.setDepositoCajaAhorrosUsd(r.getBigDecimal(31));
					excelStats.setLebacsUsd(r.getBigDecimal(32));
					excelStats.setReservasMenosLebacs(r.getBigDecimal(33));
					excelStats.setUsdBaseMonetariaLebacs(r.getBigDecimal(34));
					
					resultList.add(excelStats);
				}
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultList;
	}
	
}
