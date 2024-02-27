package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MarcaDAO implements DAO <Marca>{
    
    private Marca marcas;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Marca dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Marca dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean altera(Marca dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Marca buscaID(Marca dado) throws SQLException {
        marcas = null;
        //Comando SELECT
        String sql = "SELECT * FROM marca WHERE Cod_Marca = ?";
        
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
            marcas = new Marca();
            //move os dados do resultSet para o objeto proprietario
            marcas.setCodigo(rs.getInt("Cod_Marca"));
            marcas.setNome(rs.getString("Nome_Marca"));
        }
        
        Banco.desconectar();
        
        return marcas;
    }

    @Override
    public Collection<Marca> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Marca> listagem = new ArrayList<>();
        
        marcas = null;
        //Comando SELECT
        String sql = "SELECT * FROM marca ";
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
            marcas = new Marca();
            //move os dados do resultSet para o objeto veiculo
            marcas.setCodigo(rs.getInt("Cod_Marca"));
            marcas.setNome(rs.getString("Nome_Marca"));
            
            //adicionar na coleção
            listagem.add(marcas);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
