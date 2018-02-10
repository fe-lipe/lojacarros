
package br.felipe.ifnmg.objeto.dao;

import br.felipe.ifnmg.objeto.entidade.Carro;
import br.felipe.ifnmg.objeto.exception.ErroSistema;
import br.felipe.ifnmg.objeto.utillll.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



//implemento os metodos passando a entidade
public   class CarroDAO implements CrudDAO<Carro> {
    
    @Override
    public void salvar(Carro carro) throws ErroSistema{
        
        try {
            Connection conexao=FabricaConexao.getConexao(); // pegando minha conexao
             PreparedStatement ps;
            if(carro.getId()== null){
              ps=conexao.prepareStatement("insert into carr(nome,fabricante,cor)values (?,?,?);");

            }else{
                ps=conexao.prepareStatement("update carr set nome=?, fabricante=?, cor=? where id=?");
                ps.setInt(4, carro.getId());
            }
            ps.setString(1, carro.getNome());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
       throw new ErroSistema("Erro  ao tentar salvar", ex);

        }
        
           
    }
    @Override
    public void deletar(Carro carro) throws ErroSistema{
        
        try {
            Connection conexao=FabricaConexao.getConexao();
            
            PreparedStatement ps=conexao.prepareStatement("delete from carr where id=?");
            ps.setInt(1, carro.getId());
            ps.execute();
        } catch (SQLException ex) {
         throw new ErroSistema("Erro  ao deletar o carro", ex);

        }
        
        
        
    }
    
    
    public List<Carro> listar() throws ErroSistema{
        
        try {
            Connection conexao=FabricaConexao.getConexao();
            PreparedStatement ps=conexao.prepareStatement("select * from carr");
            ResultSet resultSet=ps.executeQuery();
            List<Carro>carros= new ArrayList<>();
           
            while(resultSet.next()){
                Carro carro= new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setNome(resultSet.getString("nome"));
                carro.setFabricante(resultSet.getString("fabricante"));
               carro.setCor(resultSet.getString("cor"));
               carros.add(carro);
               
            }
            FabricaConexao.fecharConexao();
            return carros;
            
            
        } catch (SQLException ex) {
            
                      throw new ErroSistema("Erro  ao buscar", ex);

        }
        
        
        
    }

    
    
   
    
    
    
    
    
    
    
    
}
