package com.icetea.bcra.reader.transformer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.icetea.bcra.reader.dto.PieceDTO;
import com.icetea.bcra.reader.excel.ExcelStats;
import com.icetea.bcra.reader.utils.NumberUtils;

public class PieceTransformer {
	
	private static final PieceTransformer INSTANCE = new PieceTransformer();
	
	public static PieceTransformer getInstance() {
		return INSTANCE;
	}

	private PieceTransformer() {
		super();
	}
	
	public ExcelStats transform(List<PieceDTO> pieces, Date date) {
		ExcelStats model = new ExcelStats();
		model.setNow(date);
		
		for(PieceDTO p : pieces) {
			
			if(StringUtils.contains(p.getColumnName(), "Unidad de Valor Adquisitivo (UVA)")) {
				try {
					model.setUva(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setUva(BigDecimal.ZERO);
				}
			}
			if(StringUtils.contains(p.getColumnName(), "Unidad de Vivienda (UVI)")) {
				try {
					model.setUvi(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setUvi(BigDecimal.ZERO);
				}
			}
			if(StringUtils.contains(p.getColumnName(), "Reservas Internacionales del BCRA")) {
				try {
					model.setReservasInternacionales(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setReservasInternacionales(BigDecimal.ZERO);
				}
			}
			if(StringUtils.contains(p.getColumnName(), "Base monetaria (en millones de pesos)")) {
				try {
					model.setBaseMonetaria(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setBaseMonetaria(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Circulación monetaria (en millones de pesos)")) {
				try {
					model.setCirculacionMonetaria(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setCirculacionMonetaria(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Billetes y monedas en poder del ")) {
				try {
					model.setBilletesMonedasPoderPublico(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setBilletesMonedasPoderPublico(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Efectivo en entidades financieras")) {
				try {
					model.setEfectivoEntidadesFinancieras(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setEfectivoEntidadesFinancieras(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), " de los bancos en cta. cte. en pesos en el BCRA ")) {
				try {
					model.setDepositosCtaCte(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setDepositosCtaCte(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "LEBAC (valor efectivo de colocación)")) {
				try {
					model.setLebacEfectivo(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setLebacEfectivo(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "LEBAC (valor nominal de colocación)")) {
				try {
					model.setLebacNominal(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setLebacNominal(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Depósitos en efectivo en las entidades financieras ")) {
				try {
					model.setDepositoEfectivoEntidadesFinancieras(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setDepositoEfectivoEntidadesFinancieras(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "En cuentas corrientes (neto de utilización FUCO)")) {
				try {
					model.setFuco(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setFuco(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "En Caja de ahorros (en millones de pesos)")) {
				try {
					model.setCajaDeAhorros(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setCajaDeAhorros(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "A plazo (incluye inversiones y excluye CEDROS)")) {
				try {
					model.setaPlazo(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setaPlazo(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "M2 privado, promedio móvil de 30 días")) {
				try {
					model.setM2Privado(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setM2Privado(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tasas de interés de LEBAC, a 35 días de plazo")) {
				try {
					model.setTasasInteresLebac(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setTasasInteresLebac(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tasas de interés de las operaciones de pase activas para el BCRA")) {
				try {
					model.setTasasInteresPaseActivas(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setTasasInteresPaseActivas(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tasas de interés de las operaciones de pase pasivas para el BCRA")) {
				try {
					model.setTasasInteresPasePasivas(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setTasasInteresPasePasivas(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Préstamos de las entidades financieras al sector privado")) {
				try {
					model.setPrestamoEntidadesFinancierasPrivadas(NumberUtils.toBigDecimal(p.getValue()));
				} catch (NumberFormatException e) {
					model.setPrestamoEntidadesFinancierasPrivadas(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tasas de interés por préstamos entre entidades financiera privadas")) {
				try {
					model.setTasasInteresPrestamosEntidadesFinancierasPrivadas(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setTasasInteresPrestamosEntidadesFinancierasPrivadas(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tasas de interés por depósitos a 30 días de plazo en entidades financieras")) {
				try {
					model.setTasasInteresDepositos30dias(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setTasasInteresDepositos30dias(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "BADLAR en pesos de bancos privados")) {
				try {
					model.setBadlar(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setBadlar(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "TM20 en pesos de bancos privados")) {
				try {
					model.setTm20(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setTm20(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "Tipo de cambio de referencia")) {
				try {
					model.setTipoCambioReferencia(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setTipoCambioReferencia(BigDecimal.ZERO);
				}
			}
			
			if(StringUtils.contains(p.getColumnName(), "CER")) {
				try {
					model.setCer(NumberUtils.toBigDecimal(p.getValue(), false));
				} catch (NumberFormatException e) {
					model.setCer(BigDecimal.ZERO);
				}
			}
		}
		
		return model;
	}
	
}
