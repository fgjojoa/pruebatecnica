package com.linktic.pruebatecnica.generic.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.linktic.pruebatecnica.generic.entidad.Persistente;

public class Parametros extends Persistente {

	private static final long serialVersionUID = -6160764582699863665L;

	private List<ParametroItem> items = new ArrayList<ParametroItem>();

	public Parametros() {
		super();
	}
	
	public void add(String field, Object value, String operador) {
		this.items.add(new  ParametroItem(field,value,operador));
	}

	public void add(String field, Object value) {
		this.items.add(new  ParametroItem(field,value));
	}
	
	public String partWhere() {
		String sWhere = "";
		
		for(ParametroItem dto: this.items) {
			if(!sWhere.isEmpty()) sWhere += " and ";
			sWhere += dto.getField();
			if(dto.getOperador().equals(ParametroItem.OPERADOR_EQUALS) || dto.getOperador().equals(ParametroItem.OPERADOR_DIFERRENT)) {
				sWhere += dto.getOperador();
				sWhere += ":" + dto.getField();
			} 
		}
		if(!sWhere.isEmpty()) {
			sWhere = " Where " + sWhere;
		}
		return sWhere;
	}

	public void add(ParametroItem dto) {
		this.items.add(dto);
	}
	
	public List<ParametroItem> getItems() {
		return items;
	}

	public void setItems(List<ParametroItem> items) {
		this.items = items;
	}
	
}
