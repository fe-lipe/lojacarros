package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAutil;



public class DaoGenerics<T> {
	
	
	public T merge(T entidade){
		
		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
		
	   T retorno= entiyManager.merge(entidade);
		
	    entityTransaction.commit();
	    entiyManager.clear();
		
	    return retorno;
		
		
		
	}
public void deletePorId(T entidade){
		
		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
		
	    Object id= JPAutil.getPrimaryKey(entidade);
	    
	   entiyManager.createQuery("delete from "+entidade.getClass().getCanonicalName()+"where id ="+id).executeUpdate();
		
	   
	    entityTransaction.commit();
	    entiyManager.clear();
			
	
}

            public List<T> getListyEntity(Class<T> entidade){
            	
            	
            	EntityManager entiyManager = JPAutil.getEntityManager();
        		EntityTransaction entityTransaction= entiyManager.getTransaction();
        	    entityTransaction.begin();
        	    
   List<T> retorno= entiyManager.createQuery("select from  "+entidade.getName()).getResultList();
        	    
        	    
        	    entityTransaction.commit();
        	    entiyManager.clear();
        			
        	    return retorno;
        	    
            	
            }









}
