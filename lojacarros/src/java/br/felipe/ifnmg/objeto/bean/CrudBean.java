/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.felipe.ifnmg.objeto.bean;

import br.felipe.ifnmg.objeto.dao.CrudDAO;
import br.felipe.ifnmg.objeto.exception.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author wesle

 */
public abstract class CrudBean <E, D extends CrudDAO> {   // e entidade,d DAO que recebe
                                                          // D e extends de CrudDAO
    
    private String estadoTela = "busca";      //  inseri,edita,busca  os 3 estados
    
    private E entidade;     // atributos
    private List<E> entidades;
    
    
    
    public void novo(){ //metodo
        entidade=criarNovaEntidade(); //cria uma nova entidade toda vez ele 0 e chama o estado da tela inseri
        mudarParaInseri();
        
        
        
    }
    public void salvar(){ //metodo
        try {
            getDao().salvar(entidade);  //salva por que ele  extends getDAO
            entidade=criarNovaEntidade(); // nova entidade
            adicionarMensagem("Salvo Com Sucesso", FacesMessage.SEVERITY_INFO); // adiciona mensagem
            mudarParaBusca();  //  muda tela busca
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
          adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);

        }
        
    }
    public void editar(E entidade){ //metodo
        this.entidade=entidade;  // this fala que e dessa classe
        mudarParaEdita();  // muda tela
        
    }
     public void deletar(E entidade){ //metodo
        try {
            getDao().deletar(entidade);// getDAO deletar passou a entidade
           entidades.remove(entidade);  //removeu a entidade
    adicionarMensagem("Deletado Com Sucesso", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
       adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);

        }
        
    }
     public void buscar(){  //metodo
         if(isBusca() == false){  // se buscar for igual a falso  esta inserindo ou editando
             mudarParaBusca();   //mudar pra busca
                return;
             
         }
        try {
            entidades=getDao().listar(); // chama o metodo e armazena na entidades
            if(entidades==null || entidades.size() <1){   // se for null nao tem nada cadastrado
         adicionarMensagem("Nao Existe", FacesMessage.SEVERITY_WARN);  //avizo
           
                
            }
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
       adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);

        }
         
     }
    public void adicionarMensagem(String mensagem,FacesMessage.Severity tipoErro){
        
        FacesMessage fm=new FacesMessage(tipoErro, mensagem, null);
                                        //tipo erro, mensagem , detalhe
        
        
      FacesContext.getCurrentInstance().addMessage(null, fm);  //  adiciona la no JSF a mensagem
     
        
    }

    // pega e  inseri
    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    
    
    
    // responsavel por criar os metodos na classe bean
    public abstract D getDao();  //getDAO
    
    public abstract E criarNovaEntidade();  // para limpa
    
    
    
    public boolean  isInseri(){
        return "inseri".equals(estadoTela);  //se for inseri
        
        
    }
    
     public boolean  isEdita(){                 //se for edita
        return "edita".equals(estadoTela);
        
        
    }
     
     public boolean  isBusca(){              // se for busca
        return "busca".equals(estadoTela);
        
        
    }
         // quando quizer mudar o estado da tela  so chama o metodo
     
     public void mudarParaInseri(){
         estadoTela="inseri";
         
         
     }  
     
     public void mudarParaEdita(){
         estadoTela="edita";
         
         
     }   
         
      public void mudarParaBusca(){
         estadoTela="busca";
         
         
     }   
         
         
         
         
         
         
    
    
}
