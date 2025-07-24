package com.linktic.pruebatecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.linktic.pruebatecnica.producto.entidad.Producto;
import com.linktic.pruebatecnica.producto.repositorio.ProductoRepository;
import com.linktic.pruebatecnica.producto.servicio.ProductoServicio;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;
    
    @InjectMocks
    private ProductoServicio productoService;
    
    @Test
    void testObtenerPorId_Existe() {
        Producto producto = new Producto(1, "Producto 1", 150.0);
        
        try {
            when(productoRepository.findById(1)).thenReturn(producto);

            Producto resultado = productoService.findById(1);

            assertNotNull(resultado);
            assertEquals("Producto 1", resultado.getNombre());
        } catch (Exception e) {
			e.printStackTrace();
		}
    }    

    @Test
    void testObtenerPorId_NoExiste() {
    	
    	try {
            when(productoRepository.findById(99)).thenReturn(null);

            assertThrows(RuntimeException.class, () -> productoService.findById(99));
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }    
    
    @Test
    void testObtenerTodos() {
        List<Producto> lista = Arrays.asList(
                new Producto(1, "Producto 1", 150.0),
                new Producto(2, "Producto 2", 500.0)
        );
        
        try {
            when(productoRepository.findAll()).thenReturn(lista);

            List<Producto> resultado = productoService.findAll();

            assertEquals(2, resultado.size());
        	
        } catch (Exception e) {
			e.printStackTrace();
		}

    }    
    
    @Test
    void testCrearProducto() {
        Producto producto = new Producto(null, "Producto 1", 80.0);
        Producto productoGuardado = new Producto(1, "Producto 1", 80.0);
        
        try {
            when(productoRepository.saveOrUpdate(producto)).thenReturn(productoGuardado);

            Producto resultado = productoService.saveOrUpdate(producto);

            assertNotNull(resultado.getId());
            assertEquals("Mouse", resultado.getNombre());
        	
        } catch (Exception e) {
        	e.printStackTrace();
		}

    }    
    
    @Test
    void testActualizarProducto() {
        Producto existente = new Producto(1, "Proucto 1", 300.0);
        Producto actualizado = new Producto(1, "Producto 2", 450.0);
        
        try {
            when(productoRepository.findById(1)).thenReturn(existente);
            when(productoRepository.saveOrUpdate(existente)).thenAnswer(inv -> inv.getArgument(0));

            Producto resultado = productoService.saveOrUpdate(actualizado);

            assertEquals("Producto 2", resultado.getNombre());
            assertEquals(450.0, resultado.getPrecio());
        	
        } catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    @Test
    void testEliminarProducto() {
        Producto existente = new Producto(1, "Proucto 1", 300.0);
        
        try {
            doNothing().when(productoRepository).deleteByObject(existente);

            productoService.deleteByObject(existente);

            verify(productoRepository, times(1)).deleteByObject(existente);
        } catch (Exception e) {
			e.printStackTrace();
		}
    }    
}
