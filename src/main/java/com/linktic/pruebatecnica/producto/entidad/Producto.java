package com.linktic.pruebatecnica.producto.entidad;

import java.util.Objects;

import com.linktic.pruebatecnica.generic.entidad.Persistente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto extends Persistente {

	private static final long serialVersionUID = -6839210837860505300L;
	public static final String PROP_FIELD_ID = "id";
	public static final String PROP_FIELD_NOMBRE = "nombre";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private Double precio;

	@Column(name = "descripcion", nullable = true)
	private String descripcion;

	public Producto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.linktic.pruebatecnica.producto.entidad.Producto))
			return false;
		else {
			com.linktic.pruebatecnica.producto.entidad.Producto ref = (com.linktic.pruebatecnica.producto.entidad.Producto) obj;
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
