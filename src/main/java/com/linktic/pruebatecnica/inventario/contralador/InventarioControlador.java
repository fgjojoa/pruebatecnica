package com.linktic.pruebatecnica.inventario.contralador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linktic.pruebatecnica.generic.response.GenericoResponse;
import com.linktic.pruebatecnica.inventario.entidad.Inventario;
import com.linktic.pruebatecnica.inventario.servicio.InventarioServicio;
import com.linktic.pruebatecnica.producto.entidad.Producto;
import com.linktic.pruebatecnica.producto.servicio.ProductoServicio;

@Controller
@RequestMapping("/inventario")
public class InventarioControlador {

    @Autowired
    InventarioServicio inventarioServicio;

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/listado")
    public @ResponseBody GenericoResponse listadoInventario() {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		List<Inventario> lst = this.inventarioServicio.findAll();
    		dto.setData(lst);    		
    	} catch (Exception e) {
			e.printStackTrace();
    		dto.setCode("500");
    		dto.setMessage("Ha ocurido un error en el servidor, por favor comuniquese con el administrador");
			dto.setData(e.getStackTrace());
		}
    	
    	return dto;
    }    
    
    
    @GetMapping("/consultar")
    public @ResponseBody GenericoResponse consultarInventario(@RequestParam("producto_id") Integer id ) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
    			Inventario inventario = this.inventarioServicio.findById(id);
    			if(inventario != null) {
    				dto.setData(inventario);
    			} else {
            		dto.setCode("300");
            		dto.setMessage("No hay inventario para ese producto");
    			}
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
    
    @GetMapping("/retirarcantidad")
    public @ResponseBody GenericoResponse retirarCantidad(@RequestParam("producto_id") Integer id,@RequestParam("cantidad") Integer cantidad) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
    			if(cantidad != null && cantidad > 0) {
        			Inventario inventario = this.inventarioServicio.findById(id);
        			if(inventario != null) {
        				if(inventario.getCantidad().intValue() >= cantidad.intValue()) {
        					inventario.delete(cantidad);
        					inventario = this.inventarioServicio.saveOrUpdate(inventario);
        					dto.setData(inventario);
        				} else {
                    		dto.setCode("300");
                    		dto.setMessage("La cantidad supera el disponible");
        				}
        				
        			} else {
                		dto.setCode("300");
                		dto.setMessage("No se ha creado el inventario para ese producto");
        			}
    			} else {
            		dto.setCode("300");
            		dto.setMessage("La cantidad no es valida");
    			}
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
    
    @GetMapping("/addcantidad")
    public @ResponseBody GenericoResponse addCantidad(@RequestParam("producto_id") Integer id,@RequestParam("cantidad") Integer cantidad) {
    	GenericoResponse dto = new GenericoResponse();
    	
    	try {
    		Producto prd = this.productoServicio.findById(id);
    		if(prd != null) {
    			if(cantidad != null && cantidad > 0) {
    				Inventario inventario = null;
    				try {
            			inventario = this.inventarioServicio.findById(id);        			
    				} catch (Exception e) {
						e.printStackTrace();
					}
    				
        			if(inventario == null) {
        				inventario = new Inventario(id,cantidad);
        			} else {
        				inventario.add(cantidad);
        			}
        			inventario = this.inventarioServicio.saveOrUpdate(inventario);
        			dto.setData(inventario);
    			} else {
            		dto.setCode("300");
            		dto.setMessage("La cantidad no es valida");
    			}
    			
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
    
}
