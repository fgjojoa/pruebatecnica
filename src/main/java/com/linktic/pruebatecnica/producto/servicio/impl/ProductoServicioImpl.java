package com.linktic.pruebatecnica.producto.servicio.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.producto.entidad.Producto;
import com.linktic.pruebatecnica.producto.repositorio.ProductoRepository;
import com.linktic.pruebatecnica.producto.servicio.ProductoServicio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	ProductoRepository repositorio; 
	 
	@Override
	public List<Producto> findAll() throws Exception {
		return this.repositorio.findAll();
	}

	@Override
	public List<Producto> findByParametros(Parametros parametros) throws Exception	 {
		return this.repositorio.findByParametros(parametros);
	}
	
	@Override
	public Producto saveOrUpdate(Producto dto) throws Exception {
		return this.repositorio.saveOrUpdate(dto);
	}

	@Override
	public void refresh(Producto dto) throws Exception {
		this.repositorio.refresh(dto);
	}

	@Override
	public Producto findById(Serializable id) throws Exception {
		return this.repositorio.findById(id);
	}

	@Override
	public void deleteByObject(Producto dto) throws Exception {
		this.repositorio.deleteByObject(dto);		
	}
}
