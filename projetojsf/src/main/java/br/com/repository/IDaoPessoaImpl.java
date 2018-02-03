package br.com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Pessoa;
import br.com.jpautil.JPAutil;

public class IDaoPessoaImpl implements IDaoPessoa {

	@Override
	public Pessoa consultarUsuario(String login, String senha) {
		
		Pessoa pessoa= null;

		EntityManager entiyManager = JPAutil.getEntityManager();
		EntityTransaction entityTransaction= entiyManager.getTransaction();
	    entityTransaction.begin();
 pessoa = (Pessoa) entiyManager.createQuery("select p from Pessoa p where p.login='"+login+"'and p.senha='"+senha+"'").getSingleResult();
	    
	    entityTransaction.commit();
	    entiyManager.clear();
		
		
		return pessoa;
	}

	
	
	
}
