package com.icetea.bcra.reader.dto;

public class PieceDTO extends BasicDTO {

	private static final long serialVersionUID = 1L;
	
	private String columnName;
	private String value;

	public PieceDTO() {
		super();
	}

	public PieceDTO(String columnName, String value) {
		super();
		this.columnName = columnName;
		this.value = value;
	}
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
