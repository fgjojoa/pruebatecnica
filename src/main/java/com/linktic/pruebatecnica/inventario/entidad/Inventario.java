package com.linktic.pruebatecnica.inventario.entidad;

import java.util.Objects;

import com.linktic.pruebatecnica.generic.entidad.Persistente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario extends Persistente {

	private static final long serialVersionUID = -7330833126116255658L;

	@Id
	@Column(name = "producto_id", nullable = false)
	private Integer id;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Inventario() {
		super();
	}
	
	public void add(Integer cantidad) {
		this.cantidad += cantidad;
	}
	
	public void delete(Integer cantidad) {
		this.cantidad -= cantidad;
	}

	public Inventario(Integer id, Integer cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.linktic.pruebatecnica.inventario.entidad.Inventario))
			return false;
		else {
			com.linktic.pruebatecnica.inventario.entidad.Inventario ref = (com.linktic.pruebatecnica.inventario.entidad.Inventario) obj;
			if (null == this.getId() || null == ref.getId())
				return false;
			else
				return (this.getId().equals(ref.getId()));
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}		
	
}
