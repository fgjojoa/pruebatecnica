package com.linktic.pruebatecnica.producto.servicio;

import java.io.Serializable;
import java.util.List;

import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.producto.entidad.Producto;

public interface ProductoServicio {

	public List<Producto> findAll() throws Exception;
	
	public Producto saveOrUpdate(Producto dto) throws Exception;
	
	public List<Producto> findByParametros(Parametros parametros) throws Exception;
	
	public void refresh(Producto dto) throws Exception;
	
	public Producto findById(Serializable id) throws Exception;
	
	public void deleteByObject(Producto dto) throws Exception;
}
