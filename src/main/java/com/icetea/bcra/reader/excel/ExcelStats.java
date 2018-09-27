package com.icetea.bcra.reader.excel;

import java.math.BigDecimal;
import java.util.Date;

import com.icetea.bcra.reader.dto.BasicDTO;

public class ExcelStats extends BasicDTO {

	private static final long serialVersionUID = 1L;

	private Date now;
	private BigDecimal uva;
	private BigDecimal uvi;
	private BigDecimal reservasInternacionales;
	private BigDecimal baseMonetaria;
	private BigDecimal circulacionMonetaria;
	private BigDecimal billetesMonedasPoderPublico;
	private BigDecimal efectivoEntidadesFinancieras;
	private BigDecimal depositosCtaCte;
	private BigDecimal lebacEfectivo;
	private BigDecimal lebacNominal;
	private BigDecimal depositoEfectivoEntidadesFinancieras;
	private BigDecimal fuco;
	private BigDecimal cajaDeAhorros;
	private BigDecimal aPlazo;
	private BigDecimal m2Privado;
	private BigDecimal tasasInteresLebac;
	private BigDecimal tasasInteresPaseActivas;
	private BigDecimal tasasInteresPasePasivas;
	private BigDecimal prestamoEntidadesFinancierasPrivadas;
	private BigDecimal tasasInteresPrestamosEntidadesFinancierasPrivadas;
	private BigDecimal tasasInteresDepositos30dias;
	private BigDecimal badlar;
	private BigDecimal tm20;
	private BigDecimal tipoCambioReferencia;
	private BigDecimal cer;
	private BigDecimal usdBaseMonetaria;
	private BigDecimal paridadUsdBaseMonetaria;
	private BigDecimal usdCircMonetaria;
	private BigDecimal paridadUsdCircMonetaria;
	private BigDecimal depositoCajaAhorrosUsd;
	private BigDecimal lebacsUsd;
	private BigDecimal reservasMenosLebacs;
	private BigDecimal usdBaseMonetariaLebacs;
	
	public ExcelStats() {
		super();
	}
	
	public BigDecimal getUva() {
		return uva;
	}
	public void setUva(BigDecimal uva) {
		this.uva = uva;
	}
	public BigDecimal getUvi() {
		return uvi;
	}
	public void setUvi(BigDecimal uvi) {
		this.uvi = uvi;
	}
	public BigDecimal getReservasInternacionales() {
		return reservasInternacionales;
	}
	public void setReservasInternacionales(BigDecimal reservasInternacionales) {
		this.reservasInternacionales = reservasInternacionales;
	}
	public BigDecimal getBaseMonetaria() {
		return baseMonetaria;
	}
	public void setBaseMonetaria(BigDecimal baseMonetaria) {
		this.baseMonetaria = baseMonetaria;
	}
	public BigDecimal getCirculacionMonetaria() {
		return circulacionMonetaria;
	}
	public void setCirculacionMonetaria(BigDecimal circulacionMonetaria) {
		this.circulacionMonetaria = circulacionMonetaria;
	}
	public BigDecimal getBilletesMonedasPoderPublico() {
		return billetesMonedasPoderPublico;
	}
	public void setBilletesMonedasPoderPublico(BigDecimal billetesMonedasPoderPublico) {
		this.billetesMonedasPoderPublico = billetesMonedasPoderPublico;
	}
	public BigDecimal getEfectivoEntidadesFinancieras() {
		return efectivoEntidadesFinancieras;
	}
	public void setEfectivoEntidadesFinancieras(BigDecimal efectivoEntidadesFinancieras) {
		this.efectivoEntidadesFinancieras = efectivoEntidadesFinancieras;
	}
	public BigDecimal getDepositosCtaCte() {
		return depositosCtaCte;
	}
	public void setDepositosCtaCte(BigDecimal depositosCtaCte) {
		this.depositosCtaCte = depositosCtaCte;
	}
	public BigDecimal getLebacEfectivo() {
		return lebacEfectivo;
	}
	public void setLebacEfectivo(BigDecimal lebacEfectivo) {
		this.lebacEfectivo = lebacEfectivo;
	}
	public BigDecimal getLebacNominal() {
		return lebacNominal;
	}
	public void setLebacNominal(BigDecimal lebacNominal) {
		this.lebacNominal = lebacNominal;
	}
	public BigDecimal getDepositoEfectivoEntidadesFinancieras() {
		return depositoEfectivoEntidadesFinancieras;
	}
	public void setDepositoEfectivoEntidadesFinancieras(BigDecimal depositoEfectivoEntidadesFinancieras) {
		this.depositoEfectivoEntidadesFinancieras = depositoEfectivoEntidadesFinancieras;
	}
	public BigDecimal getFuco() {
		return fuco;
	}
	public void setFuco(BigDecimal fuco) {
		this.fuco = fuco;
	}
	public BigDecimal getCajaDeAhorros() {
		return cajaDeAhorros;
	}
	public void setCajaDeAhorros(BigDecimal cajaDeAhorros) {
		this.cajaDeAhorros = cajaDeAhorros;
	}
	public BigDecimal getaPlazo() {
		return aPlazo;
	}
	public void setaPlazo(BigDecimal aPlazo) {
		this.aPlazo = aPlazo;
	}
	public BigDecimal getM2Privado() {
		return m2Privado;
	}
	public void setM2Privado(BigDecimal m2Privado) {
		this.m2Privado = m2Privado;
	}
	public BigDecimal getTasasInteresLebac() {
		return tasasInteresLebac;
	}
	public void setTasasInteresLebac(BigDecimal tasasInteresLebac) {
		this.tasasInteresLebac = tasasInteresLebac;
	}
	public BigDecimal getTasasInteresPaseActivas() {
		return tasasInteresPaseActivas;
	}
	public void setTasasInteresPaseActivas(BigDecimal tasasInteresPaseActivas) {
		this.tasasInteresPaseActivas = tasasInteresPaseActivas;
	}
	public BigDecimal getTasasInteresPasePasivas() {
		return tasasInteresPasePasivas;
	}
	public void setTasasInteresPasePasivas(BigDecimal tasasInteresPasePasivas) {
		this.tasasInteresPasePasivas = tasasInteresPasePasivas;
	}
	public BigDecimal getPrestamoEntidadesFinancierasPrivadas() {
		return prestamoEntidadesFinancierasPrivadas;
	}
	public void setPrestamoEntidadesFinancierasPrivadas(BigDecimal prestamoEntidadesFinancierasPrivadas) {
		this.prestamoEntidadesFinancierasPrivadas = prestamoEntidadesFinancierasPrivadas;
	}
	public BigDecimal getTasasInteresDepositos30dias() {
		return tasasInteresDepositos30dias;
	}
	public void setTasasInteresDepositos30dias(BigDecimal tasasInteresDepositos30dias) {
		this.tasasInteresDepositos30dias = tasasInteresDepositos30dias;
	}
	public BigDecimal getBadlar() {
		return badlar;
	}
	public void setBadlar(BigDecimal badlar) {
		this.badlar = badlar;
	}
	public BigDecimal getTm20() {
		return tm20;
	}
	public void setTm20(BigDecimal tm20) {
		this.tm20 = tm20;
	}
	public BigDecimal getTipoCambioReferencia() {
		return tipoCambioReferencia;
	}
	public void setTipoCambioReferencia(BigDecimal tipoCambioReferencia) {
		this.tipoCambioReferencia = tipoCambioReferencia;
	}
	public BigDecimal getCer() {
		return cer;
	}
	public void setCer(BigDecimal cer) {
		this.cer = cer;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public BigDecimal getTasasInteresPrestamosEntidadesFinancierasPrivadas() {
		return tasasInteresPrestamosEntidadesFinancierasPrivadas;
	}

	public void setTasasInteresPrestamosEntidadesFinancierasPrivadas(
			BigDecimal tasasInteresPrestamosEntidadesFinancierasPrivadas) {
		this.tasasInteresPrestamosEntidadesFinancierasPrivadas = tasasInteresPrestamosEntidadesFinancierasPrivadas;
	}

	public BigDecimal getUsdBaseMonetaria() {
		return usdBaseMonetaria;
	}

	public void setUsdBaseMonetaria(BigDecimal usdBaseMonetaria) {
		this.usdBaseMonetaria = usdBaseMonetaria;
	}

	public BigDecimal getParidadUsdBaseMonetaria() {
		return paridadUsdBaseMonetaria;
	}

	public void setParidadUsdBaseMonetaria(BigDecimal paridadUsdBaseMonetaria) {
		this.paridadUsdBaseMonetaria = paridadUsdBaseMonetaria;
	}

	public BigDecimal getUsdCircMonetaria() {
		return usdCircMonetaria;
	}

	public void setUsdCircMonetaria(BigDecimal usdCircMonetaria) {
		this.usdCircMonetaria = usdCircMonetaria;
	}

	public BigDecimal getParidadUsdCircMonetaria() {
		return paridadUsdCircMonetaria;
	}

	public void setParidadUsdCircMonetaria(BigDecimal paridadUsdCircMonetaria) {
		this.paridadUsdCircMonetaria = paridadUsdCircMonetaria;
	}

	public BigDecimal getDepositoCajaAhorrosUsd() {
		return depositoCajaAhorrosUsd;
	}

	public void setDepositoCajaAhorrosUsd(BigDecimal depositoCajaAhorrosUsd) {
		this.depositoCajaAhorrosUsd = depositoCajaAhorrosUsd;
	}

	public BigDecimal getLebacsUsd() {
		return lebacsUsd;
	}

	public void setLebacsUsd(BigDecimal lebacsUsd) {
		this.lebacsUsd = lebacsUsd;
	}

	public BigDecimal getReservasMenosLebacs() {
		return reservasMenosLebacs;
	}

	public void setReservasMenosLebacs(BigDecimal reservasMenosLebacs) {
		this.reservasMenosLebacs = reservasMenosLebacs;
	}

	public BigDecimal getUsdBaseMonetariaLebacs() {
		return usdBaseMonetariaLebacs;
	}

	public void setUsdBaseMonetariaLebacs(BigDecimal usdBaseMonetariaLebacs) {
		this.usdBaseMonetariaLebacs = usdBaseMonetariaLebacs;
	}
	
}
