package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAutil;



public class DaoGeneric<E> {

	
	public void salvar(E entidade){
		
		
		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
		
	    entiyManager.persist(entidade);
		
	    entityTransaction.commit();
	    entiyManager.clear();
		
	    
	     
		
	}
	public E merge(E entidade){
		
		
		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
		
	   E retorno = entiyManager.merge(entidade);
		
	    entityTransaction.commit();
	    entiyManager.clear();
		
	    return retorno;
	    
	    
		
	}
	
	
	
     public void delete(E entidade){
		
		
		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
		
	    entiyManager.remove(entidade);
		
	    entityTransaction.commit();
	    entiyManager.clear();
		
	    
	     
		
	}
	

 	public void deletePorId(E entidade){
		EntityManager entityManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAutil.getPrimaryKey(entidade);
		entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
	}
 	
 	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
 	
 	
	
	
}

