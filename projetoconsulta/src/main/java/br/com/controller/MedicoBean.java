package br.com.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dao.DaoGenerics;
import br.com.model.entidade.Medico;


@ManagedBean
@SessionScoped
public class MedicoBean {
	
	
private Medico medico= new Medico();
	
private DaoGenerics<Medico> daoGenerics= new DaoGenerics<Medico>();

private ArrayList<Medico> medicos= new ArrayList<Medico>();
	

	
 public  String  salvar(){
	 
	medico= daoGenerics.merge(medico);
	carregarMedicos();
	 
	 
	 return"";
 }
 
 public String novo(){
	 
	 medico= new Medico();
	 
	
	return "";
	
 }
 
 public String  delete(){

	 
	 daoGenerics.deletePorId(medico);
	 medico= new Medico();
	 carregarMedicos();
	 
	 return"";
 }
 
 public void carregarMedicos(){
	 
	  medicos= (ArrayList<Medico>) daoGenerics.getListyEntity(Medico.class);
	 
	 
	 
	 
 }
 
 
 
 


public ArrayList<Medico> getMedicos() {
	return medicos;
}

public void setMedicos(ArrayList<Medico> medicos) {
	this.medicos = medicos;
}

public Medico getMedico() {
	return medico;
}


public void setMedico(Medico medico) {
	this.medico = medico;
}


public DaoGenerics<Medico> getDaoGenerics() {
	return daoGenerics;
}


public void setDaoGenerics(DaoGenerics<Medico> daoGenerics) {
	this.daoGenerics = daoGenerics;
}


 
 




	
	
	
}
