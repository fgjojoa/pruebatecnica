package com.linktic.pruebatecnica.inventario.servicio;

import java.io.Serializable;
import java.util.List;

import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.inventario.entidad.Inventario;

public interface InventarioServicio {

	public List<Inventario> findAll() throws Exception;
	
	public Inventario saveOrUpdate(Inventario dto) throws Exception;
	
	public List<Inventario> findByParametros(Parametros parametros) throws Exception;
	
	public void refresh(Inventario dto) throws Exception;
	
	public Inventario findById(Serializable id) throws Exception;
	
	public void deleteByObject(Inventario dto) throws Exception;
	
}
