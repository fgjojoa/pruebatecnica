package com.linktic.pruebatecnica.generic.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linktic.pruebatecnica.generic.entidad.Persistente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class GenericRepository {

	@PersistenceContext
	private EntityManager em;

	public List<? extends Persistente> findAll(Class<? extends Persistente> classz) throws Exception {
		List<Persistente> lst = new ArrayList<Persistente>();

		lst.addAll(em.createQuery("Select t from " + classz.getSimpleName() + " t").getResultList());
		
		return lst;
	}
	
	public List<? extends Persistente> findByParametros(Class<? extends Persistente> classz, Parametros parametros) throws Exception {

		List<Persistente> lst = new ArrayList<Persistente>();
		
		Query query = em.createQuery("Select t from " + classz.getSimpleName() + " t " + parametros.partWhere());

		for(ParametroItem item: parametros.getItems()) {
			query.setParameter(item.getField(), item.getValue());
		}
		
		lst.addAll(query.getResultList());
		
		return lst;
	}

	public Persistente saveOrUpdate(Persistente dto) throws Exception {
		return em.merge(dto);
	}
	
	public  void refresh(Persistente dto) throws Exception {
		em.refresh(dto);
	}
	
	public Persistente findById(Class<? extends Persistente> classz, Serializable id) throws Exception {
		Persistente dto = em.find(classz, id); 
		return dto;
	}
	
	public void deleteByObject(Persistente object) throws Exception {
		em.remove(object);
	}

	public EntityManager getEm() {
		return em;
	}	
	
	
}
