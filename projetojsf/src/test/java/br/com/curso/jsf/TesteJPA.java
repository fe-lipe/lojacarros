package br.com.curso.jsf;

import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("projetojsf");
		
		
		
	}

}
