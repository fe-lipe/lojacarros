/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.felipe.ifnmg.objeto.utillll;

import br.felipe.ifnmg.objeto.exception.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class FabricaConexao {
    
    
    
    public static Connection conexao;
    private static final String URL_CONEXAO="jdbc:mysql://localhost:3306/toyota";
    private static final String USUARIO="root";
    private static final String SENHA= null;

    public static Connection getConexao() throws ErroSistema {
        
        
        
        if(conexao==null){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao= DriverManager.getConnection(URL_CONEXAO,USUARIO,SENHA);
            } catch (SQLException ex) {
        //lanca um erro
          throw new ErroSistema("Nao foi possivel conectar ao banco", ex);
            } catch (ClassNotFoundException ex) {
         throw new ErroSistema("O driver do banco nao foi encontrado", ex);

            }
            
        }
        
        
        return conexao;
    }
    
    public static void fecharConexao() throws ErroSistema{
        
        if(conexao!=null){
            try {
                conexao.close();
                conexao=null;
            } catch (SQLException ex) {
           throw new ErroSistema("Erro  ao fechar conexao", ex);

            }
            
        }
        
        
        
        
    }
    
    
    
    
    
}
