package com.linktic.pruebatecnica.producto.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linktic.pruebatecnica.generic.repositorio.GenericRepository;
import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.producto.entidad.Producto;

@SuppressWarnings("unchecked")
@Repository
public class ProductoRepository {

	@Autowired
	GenericRepository generico;
	
	public List<Producto> findAll() throws Exception {
		return (List<Producto>)this.generico.findAll(Producto.class);
	}
	
	public List<Producto> findByParametros(Parametros parametros) throws Exception {
		return (List<Producto>)this.generico.findByParametros(Producto.class, parametros);
	}
	
	public Producto saveOrUpdate(Producto dto) throws Exception {
		return (Producto)this.generico.saveOrUpdate(dto);
	}
	
	public void refresh(Producto dto) throws Exception  {
		this.generico.refresh(dto);
	}
	
	public Producto findById(Serializable id) throws Exception  {
		return (Producto) this.generico.findById(Producto.class, id);
	}
	
	public void deleteByObject(Producto dto) throws Exception {
		this.generico.deleteByObject(dto);
	}
	
}
