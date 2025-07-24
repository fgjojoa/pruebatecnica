package com.linktic.pruebatecnica.producto.contralador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linktic.pruebatecnica.generic.repositorio.ParametroItem;
import com.linktic.pruebatecnica.generic.repositorio.Parametros;
import com.linktic.pruebatecnica.generic.response.GenericoResponse;
import com.linktic.pruebatecnica.producto.entidad.Producto;
import com.linktic.pruebatecnica.producto.servicio.ProductoServicio;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    ProductoServicio productoServicio;

    @PostMapping("/guardar")
    public @ResponseBody GenericoResponse guardarProducto(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre,@RequestParam("precio") Double precio,@RequestParam(name = "descripcion", required = false) String descripcion ) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
        		Parametros parametros = new Parametros();
        		parametros.add(Producto.PROP_FIELD_NOMBRE, nombre.trim());
        		parametros.add(Producto.PROP_FIELD_ID,id,ParametroItem.OPERADOR_DIFERRENT);
        		
        		List<Producto> lst = this.productoServicio.findByParametros(parametros);
    			if(lst == null || lst.isEmpty()) {
    				prd.setNombre(nombre);
    				prd.setPrecio(precio);
    				prd.setDescripcion(descripcion);
    				prd = this.productoServicio.saveOrUpdate(prd);
    				dto.setData(prd);
    			} else {
    	    		dto.setCode("300");
    	    		dto.setMessage("Ya existe un producto con el nombre indicado");
    			}
    			dto.setData(prd);        		
    		} else {
        		dto.setCode("300");
        		dto.setMessage("El id del producto no existe");
    		}    		
    	} catch (Exception e) {
			e.printStackTrace();
    		dto.setCode("500");
    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
			dto.setData(e.getStackTrace());
		}
    	
    	return dto;
    }    

    @GetMapping("/listado")
    public @ResponseBody GenericoResponse listadoProducto() {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		List<Producto> lst = this.productoServicio.findAll();
    		dto.setData(lst);    		
    	} catch (Exception e) {
			e.printStackTrace();
    		dto.setCode("500");
    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
			dto.setData(e.getStackTrace());
		}
    	
    	return dto;
    }    
    
    @GetMapping("/eliminar")
    public @ResponseBody GenericoResponse eliminarProducto(@RequestParam("id") Integer id ) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
    			this.productoServicio.deleteByObject(prd);
    		} else {
        		dto.setCode("300");
        		dto.setMessage("El id del producto no existe");
    		}
    	} catch (Exception e) {
			e.printStackTrace();
    		dto.setCode("500");
    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
			dto.setData(e.getStackTrace());
		}
    	
    	return dto;
    }    
    
    @GetMapping("/editar")
    public @ResponseBody GenericoResponse editarProducto(@RequestParam("id") Integer id ) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
        		dto.setData(prd);
    		} else {
        		dto.setCode("300");
        		dto.setMessage("El id del producto no existe");
    		}
    	} catch (Exception e) {
			e.printStackTrace();
    		dto.setCode("500");
    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
			dto.setData(e.getStackTrace());
		}
    	
    	return dto;
    }    
    
    @GetMapping("/nuevo")
    public @ResponseBody GenericoResponse addProducto(@RequestParam("nombre") String nombre,@RequestParam("precio") Double precio,@RequestParam(name = "descripcion", required = false) String descripcion) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	if(nombre == null || nombre.trim().isEmpty()) {
    		dto.setCode("300");
    		if(precio == null || precio.doubleValue() < 0.1) {
        		dto.setMessage("Los datos de nombre y precio son invalidos");
    		} else {
        		dto.setMessage("No se indico el nombre");
    		}
    	} else if(precio == null || precio.doubleValue() < 0.1) {
    		dto.setCode("300");
    		dto.setMessage("El precio debe ser mayor a 0");
    	} else {
    		Parametros parametros = new Parametros();
    		parametros.add(Producto.PROP_FIELD_NOMBRE, nombre.trim());
    		try {
        		List<Producto> lst = this.productoServicio.findByParametros(parametros);
    			if(lst == null || lst.isEmpty()) {
    				Producto prd = new Producto();
    				prd.setNombre(nombre);
    				prd.setPrecio(precio);
    				prd.setDescripcion(descripcion);
    				prd = this.productoServicio.saveOrUpdate(prd);
    				dto.setData(prd);
    			} else {
    	    		dto.setCode("300");
    	    		dto.setMessage("Ya existe un producto con el nombre indicado");
    			}
    		} catch (Exception e) {
				e.printStackTrace();
	    		dto.setCode("500");
	    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
				dto.setData(e.getStackTrace());
			}
    		
    	}
    	
    	return dto;
    }
}
