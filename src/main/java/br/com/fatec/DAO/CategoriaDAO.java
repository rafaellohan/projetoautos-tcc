package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class CategoriaDAO implements DAO <Categoria>{
    
    private Categoria categorias;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Categoria dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Categoria dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean altera(Categoria dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria buscaID(Categoria dado) throws SQLException {
        categorias = null;
        //Comando SELECT
        String sql = "SELECT * FROM categoria WHERE Cod_Categoria = ?";
        
        //conecta ao banco
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //troca a ?
        pst.setInt(1, dado.getCodigo());
        
        //Executa o comando SELECT
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto proprietario
            categorias = new Categoria();
            //move os dados do resultSet para o objeto proprietario
            categorias.setCodigo(rs.getInt("Cod_Categoria"));
            categorias.setNome(rs.getString("Nome_Categoria"));
        }
        
        Banco.desconectar();
        
        return categorias;
    }

    @Override
    public Collection<Categoria> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Categoria> listagem = new ArrayList<>();
        
        categorias = null;
        //Comando SELECT
        String sql = "SELECT * FROM categoria ";
        //colocar filtro ou nao
        if(filtro.length() != 0) {
            sql += "WHERE " + filtro;
        }
        
        //conecta ao banco
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //Executa o comando SELECT
        rs = pst.executeQuery();
        
        //le o próximo regitro
        while(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            categorias = new Categoria();
            //move os dados do resultSet para o objeto veiculo
            categorias.setCodigo(rs.getInt("Cod_Categoria"));
            categorias.setNome(rs.getString("Nome_Categoria"));
            
            //adicionar na coleção
            listagem.add(categorias);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
