/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.felipe.ifnmg.objeto.bean;

import br.felipe.ifnmg.objeto.dao.CarroDAO;
import br.felipe.ifnmg.objeto.entidade.Carro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class CarroBean extends CrudBean<Carro,CarroDAO> {  //passa entidade e CarroDAO

    private CarroDAO carroDAO;
    
    
    @Override
    public CarroDAO getDao() {
       if(carroDAO==null){  // quando for vazio cria ele 
           carroDAO= new CarroDAO();
           
       }
       return carroDAO;   // se nao so devolve
    }

    @Override
    public Carro criarNovaEntidade() {
        return new Carro();
        
    }
    
    
    
    
    
}
