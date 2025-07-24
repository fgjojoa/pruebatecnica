package com.linktic.pruebatecnica.generic.entidad;

import java.io.Serializable;

/**
 * Clase base para las entidades
 */
public class Persistente implements Serializable, Cloneable{

	private static final long serialVersionUID = -970970945431231929L;
	
	public Persistente() {
		super();
	}

	public Persistente clone(){
		Persistente obj=null;
		try{
			obj=(Persistente) super.clone();
		}catch(CloneNotSupportedException ex){
			System.out.println("No se puede duplicar");
		}
		return obj;
	}	
}
