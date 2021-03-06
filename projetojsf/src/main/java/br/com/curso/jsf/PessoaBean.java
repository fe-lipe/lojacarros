package br.com.curso.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;
import br.com.repository.IDaoPessoa;
import br.com.repository.IDaoPessoaImpl;



@ViewScoped
@ManagedBean
public class PessoaBean {

	
	private  Pessoa pessoa= new Pessoa();
	
	 private   DaoGeneric<Pessoa> daoGeneric= new DaoGeneric<Pessoa>();
	 
	 private List<Pessoa>pessoas = new ArrayList<Pessoa>();
	 
	 private IDaoPessoa iDaoPessoa = new IDaoPessoaImpl(); 
	 
	 
	 
	 public String salvar(){
		pessoa= daoGeneric.merge(pessoa);
		 
		carregarPessoas();  // chama sua  dataTable seo metodo
		 
		 return "";
		 
	 }
	 
	 
	 public String novo(){
		 pessoa = new Pessoa();
		 
		 return "";
	 }

	 public String deletar(){
		 
		 daoGeneric.deletePorId(pessoa);
		 
		 pessoa= new Pessoa();
		 carregarPessoas();   //  carrega sua lista ao deletar
		 
		 return ""; // esse return vazio pra fica na mesma tela
		 
	 }
	 
	    @PostConstruct
		public void carregarPessoas(){
			pessoas = daoGeneric.getListEntity(Pessoa.class);
		}
	 
	 

	 

	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}



	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	 
	 public String logar(){
		
		 
   Pessoa pessoaUser	= iDaoPessoa.consultarUsuario(pessoa.getLogin(),pessoa.getSenha());	 
		 
   if(pessoaUser != null){ // achou o  usuario
	   //  adiciona  usuario na sessao
	   
	   FacesContext context= FacesContext.getCurrentInstance();
	   ExternalContext externalContext = context.getExternalContext();
	   externalContext.getSessionMap().put("usuarioLogado", pessoaUser);
	   
	   
	   return "primeirapagina.jsf";
	   
   }
   
		return "index.jsf"; 
		 
		 
	 }
	 
	 
	

	
	
	
	
	
	
}
