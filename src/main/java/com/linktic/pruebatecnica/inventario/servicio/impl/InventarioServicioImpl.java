package com.linktic.pruebatecnica.inventario.servicio.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.inventario.entidad.Inventario;
import com.linktic.pruebatecnica.inventario.repositorio.InventarioRepository;
import com.linktic.pruebatecnica.inventario.servicio.InventarioServicio;

@Service
public class InventarioServicioImpl implements InventarioServicio {
	
	@Autowired
	InventarioRepository repositorio; 
	 
	@Override
	public List<Inventario> findAll() throws Exception {
		return this.repositorio.findAll();
	}

	@Override
	public List<Inventario> findByParametros(Parametros parametros) throws Exception	 {
		return this.repositorio.findByParametros(parametros);
	}
	
	@Override
	public Inventario saveOrUpdate(Inventario dto) throws Exception {
		return this.repositorio.saveOrUpdate(dto);
	}

	@Override
	public void refresh(Inventario dto) throws Exception {
		this.repositorio.refresh(dto);
	}

	@Override
	public Inventario findById(Serializable id) throws Exception {
		return this.repositorio.findById(id);
	}

	@Override
	public void deleteByObject(Inventario dto) throws Exception {
		this.repositorio.deleteByObject(dto);		
	}

}
