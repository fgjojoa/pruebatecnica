package com.linktic.pruebatecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.linktic.pruebatecnica.inventario.repositorio.InventarioRepository;
import com.linktic.pruebatecnica.inventario.servicio.InventarioServicio;
import com.linktic.pruebatecnica.inventario.entidad.Inventario;

@ExtendWith(MockitoExtension.class)
public class InventarioServiceTest {

    @Mock
    private InventarioRepository InventarioRepository;
    
    @InjectMocks
    private InventarioServicio InventarioService;
    
    @Test
    void testObtenerPorId_Existe() {
        Inventario Inventario = new Inventario(1, 150);
        
        try {
            when(InventarioRepository.findById(1)).thenReturn(Inventario);

            Inventario resultado = InventarioService.findById(1);

            assertNotNull(resultado);
            assertEquals(150, resultado.getCantidad());
        } catch (Exception e) {
			e.printStackTrace();
		}
    }    

    @Test
    void testObtenerPorId_NoExiste() {
    	
    	try {
            when(InventarioRepository.findById(99)).thenReturn(null);

            assertThrows(RuntimeException.class, () -> InventarioService.findById(99));
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }    
    
    @Test
    void testObtenerTodos() {
        List<Inventario> lista = Arrays.asList(
                new Inventario(1, 150),
                new Inventario(2, 200)
        );
        
        try {
            when(InventarioRepository.findAll()).thenReturn(lista);

            List<Inventario> resultado = InventarioService.findAll();

            assertEquals(2, resultado.size());
        	
        } catch (Exception e) {
			e.printStackTrace();
		}

    }    
    
    @Test
    void testCrearInventario() {
        Inventario Inventario = new Inventario(1, 150);
        Inventario InventarioGuardado = new Inventario(1, 150);
        
        try {
            when(InventarioRepository.saveOrUpdate(Inventario)).thenReturn(InventarioGuardado);

            Inventario resultado = InventarioService.saveOrUpdate(Inventario);

            assertNotNull(resultado.getId());
            assertEquals(150, resultado.getCantidad());
        	
        } catch (Exception e) {
        	e.printStackTrace();
		}

    }    
    
    @Test
    void testActualizarInventario() {
        Inventario existente = new Inventario(1, 150);
        Inventario actualizado = new Inventario(1,450);
        
        try {
            when(InventarioRepository.findById(1)).thenReturn(existente);
            when(InventarioRepository.saveOrUpdate(existente)).thenAnswer(inv -> inv.getArgument(0));

            Inventario resultado = InventarioService.saveOrUpdate(actualizado);

            assertEquals(450, resultado.getCantidad());
        	
        } catch (Exception e) {
			e.printStackTrace();
		}

    }
    
	
}
