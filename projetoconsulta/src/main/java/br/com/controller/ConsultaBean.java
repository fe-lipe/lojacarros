package br.com.controller;

import javax.faces.bean.ManagedBean;

import br.com.dao.DaoGenerics;
import br.com.model.entidade.ConsultasMedica;

@ManagedBean
public class ConsultaBean {

	private ConsultasMedica consultaMedica= new ConsultasMedica();
	
	
	private DaoGenerics<ConsultasMedica> daoGenerics= new DaoGenerics<ConsultasMedica>();

	
	public String save(){
		
		
		consultaMedica= daoGenerics.merge(consultaMedica);
		
		return "index";
		
	}
	
	public String novo(){
		 
		consultaMedica = new ConsultasMedica();
		 
		
		return "";
		

	}

	
	public String  delete(){

		 
		 daoGenerics.deletePorId(consultaMedica);
		 consultaMedica= new ConsultasMedica();
		
		 
		 return"";
	 }
	
	
	
	
	
	
	

	public ConsultasMedica getConsultaMedica() {
		return consultaMedica;
	}

	public void setConsultaMedica(ConsultasMedica consultaMedica) {
		this.consultaMedica = consultaMedica;
	}

	public DaoGenerics<ConsultasMedica> getDaoGenerics() {
		return daoGenerics;
	}

	public void setDaoGenerics(DaoGenerics<ConsultasMedica> daoGenerics) {
		this.daoGenerics = daoGenerics;
	}
	
	
	
	
	
	
	
	
	
	
}
