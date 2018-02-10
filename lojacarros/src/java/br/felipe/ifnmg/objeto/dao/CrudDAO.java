/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.felipe.ifnmg.objeto.dao;

import br.felipe.ifnmg.objeto.exception.ErroSistema;
import java.util.List;


//interface serve como forma de quem for implementa! pode se crias varias classes
public interface  CrudDAO<E> { //representa minha entidade
    
    
 public void salvar(E entidade)throws ErroSistema; //recebeu a entidade //  metodos que serao desenvolvidos em outra classe
 public void deletar(E entidade)throws ErroSistema;
  public List<E> listar()throws ErroSistema;
     
    
    
     
    
}
