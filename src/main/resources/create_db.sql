use bcra_data;

create table BCRA_STATS( 
	ID bigint AUTO_INCREMENT,
	FECHA datetime,
    UVA BIGINT(20),
    UVI BIGINT(20),
    RESERVAS_INTERNACIONALES BIGINT(20),
	BASE_MONETARIA BIGINT(20),
    CIRCULACION_MONETARIA DECIMAL(14,2),
    BILLETES_MONEDAS_PODER_PUBLICO DECIMAL(14,2),
    EFECTIVO_ENTIDADES_FINANCIERAS DECIMAL(14,2),
    DEPOSITOS_CTA_CTE DECIMAL(14,2),
    LEBAC_EFECTIVO DECIMAL(14,2),
    LEBAC_NOMINAL DECIMAL(14,2),
    DEPOSITO_EFECTIVO_ENTIDADES_FINANCIERAS DECIMAL(14,2),
    FUCO DECIMAL(14,2),
    CAJA_DE_AHORROS DECIMAL(14,2),
    A_PLAZO DECIMAL(14,2),
    M2_PRIVADO DECIMAL(14,2),
    TASAS_INTERES_LEBAC DECIMAL(14,2),
    TASAS_INTERES_LEBAC_ACTIVAS DECIMAL(14,2),
    TASAS_INTERES_LEBAC_PASIVAS DECIMAL(14,2),
    PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS DECIMAL(14,2),
    TASAS_INTERES_PRESTAMO_ENTIDADES_FINANCIERAS_PRIVADAS DECIMAL(14,2),
    TASAS_INTERES_DEPOSITOS_30_DIAS DECIMAL(14,2),
    BADLAR DECIMAL(14,2),
    TM_20 DECIMAL(14,2),
    TIPO_CAMBIO_REFERENCIA DECIMAL(14,2),
    CER DECIMAL(14,2),
    USD_BASE_MONETARIA DECIMAL(14,2),
    PARIDAD_USD_BASE_MONETARIA DECIMAL(14,2),
    USD_CIRC_MONETARIA DECIMAL(14,2),
    PARIDAD_USD_CIRC_MONETARIA DECIMAL(14,2),
    DEPOSITO_CAJA_AHORROS_USD DECIMAL(14,2),
    LEBACS_USD DECIMAL(14,2),
    RESERVAS_MENOS_LEBACS DECIMAL(14,2),
    USD_BASE_MONETARIA_LEBACS DECIMAL(14,2),
    primary key(ID)
) ENGINE=InnoDB;

ALTER TABLE BCRA_STATS ADD UNIQUE INDEX BCRA_STATS_IDX (FECHA);