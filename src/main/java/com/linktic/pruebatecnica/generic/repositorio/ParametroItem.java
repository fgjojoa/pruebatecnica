package com.linktic.pruebatecnica.generic.repositorio;

import com.linktic.pruebatecnica.generic.entidad.Persistente;

public class ParametroItem extends Persistente {

	private static final long serialVersionUID = 3015939230284047462L;
	
	public static final String OPERADOR_EQUALS = " = ";
	public static final String OPERADOR_DIFERRENT = " != ";

	private String field;
	private Object value;
	private String operador = OPERADOR_EQUALS;

	public ParametroItem() {
		super();
	}

	public ParametroItem(String field, Object value, String operador) {
		super();
		this.field = field;
		this.value = value;
		this.operador = operador;
	}

	
	public ParametroItem(String field, Object value) {
		super();
		this.field = field;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

}
