package br.com.controller;

import javax.faces.bean.ManagedBean;

import br.com.model.entidade.Usuario;


@ManagedBean
public class LoginBean {
	
	Usuario usuario= new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
  public String doLogin(){
	  
if("felipe".equals(usuario.getUsuario())&& "123".equals(usuario.getSenha())){
		  
		  return"Acesso.xhtml";
	  }
	  
	  return null;
	  
  }
	
	
	
	
	
}
