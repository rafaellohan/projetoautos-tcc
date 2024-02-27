package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Cambio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CambioDAO implements DAO <Cambio>{
    
    private Cambio cambios;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Cambio dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Cambio dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean altera(Cambio dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cambio buscaID(Cambio dado) throws SQLException {
        cambios = null;
        //Comando SELECT
        String sql = "SELECT * FROM cambio WHERE Cod_Cambio = ?";
        
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
            cambios = new Cambio();
            //move os dados do resultSet para o objeto proprietario
            cambios.setCodigo(rs.getInt("Cod_Cambio"));
            cambios.setNome(rs.getString("Nome_Cambio"));
        }
        
        Banco.desconectar();
        
        return cambios;
    }

    @Override
    public Collection<Cambio> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Cambio> listagem = new ArrayList<>();
        
        cambios = null;
        //Comando SELECT
        String sql = "SELECT * FROM cambio ";
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
            cambios = new Cambio();
            //move os dados do resultSet para o objeto veiculo
            cambios.setCodigo(rs.getInt("Cod_Cambio"));
            cambios.setNome(rs.getString("Nome_Cambio"));
            
            //adicionar na coleção
            listagem.add(cambios);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
