package com.linktic.pruebatecnica.inventario.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linktic.pruebatecnica.generic.repositorio.GenericRepository;
import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.inventario.entidad.Inventario;

@SuppressWarnings("unchecked")
@Repository
public class InventarioRepository {
	
	@Autowired
	GenericRepository generico;
	
	public List<Inventario> findAll() throws Exception {
		return (List<Inventario>)this.generico.findAll(Inventario.class);
	}
	
	public List<Inventario> findByParametros(Parametros parametros) throws Exception {
		return (List<Inventario>)this.generico.findByParametros(Inventario.class, parametros);
	}
	
	public Inventario saveOrUpdate(Inventario dto) throws Exception {
		return (Inventario)this.generico.saveOrUpdate(dto);
	}
	
	public void refresh(Inventario dto) throws Exception  {
		this.generico.refresh(dto);
	}
	
	public Inventario findById(Serializable id) throws Exception  {
		return (Inventario) this.generico.findById(Inventario.class, id);
	}
	
	public void deleteByObject(Inventario dto) throws Exception {
		this.generico.deleteByObject(dto);
	}

}
