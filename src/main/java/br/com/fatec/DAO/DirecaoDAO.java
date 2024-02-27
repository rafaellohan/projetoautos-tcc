package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Direcao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DirecaoDAO implements DAO <Direcao>{
    
    private Direcao direcoes;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Direcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Direcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean altera(Direcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direcao buscaID(Direcao dado) throws SQLException {
        direcoes = null;
        //Comando SELECT
        String sql = "SELECT * FROM direcao WHERE Cod_Direcao = ?";
        
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
            direcoes = new Direcao();
            //move os dados do resultSet para o objeto proprietario
            direcoes.setCodigo(rs.getInt("Cod_Direcao"));
            direcoes.setNome(rs.getString("Nome_Direcao"));
        }
        
        Banco.desconectar();
        
        return direcoes;
    }

    @Override
    public Collection<Direcao> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Direcao> listagem = new ArrayList<>();
        
        direcoes = null;
        //Comando SELECT
        String sql = "SELECT * FROM direcao ";
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
            direcoes = new Direcao();
            //move os dados do resultSet para o objeto veiculo
            direcoes.setCodigo(rs.getInt("Cod_Direcao"));
            direcoes.setNome(rs.getString("Nome_Direcao"));
            
            //adicionar na coleção
            listagem.add(direcoes);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
