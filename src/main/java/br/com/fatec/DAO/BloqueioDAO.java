package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Bloqueio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class BloqueioDAO implements DAO <Bloqueio>{

    private Bloqueio block;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean insere(Bloqueio dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO bloqueado (CPFCNPJ) "
                   + "VALUE (?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);
        
        // Colocar dados no PST
        pst.setString(1, dado.getCPFCNPJ());
        
        // Executar
        if(pst.executeUpdate() > 0) {
            inseriu = true;
        } 
        else {
            inseriu = false;
        }
        
        Banco.desconectar();

        return inseriu;
    }

    @Override
    public boolean remove(Bloqueio dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM bloqueado WHERE CPFCNPJ = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getCPFCNPJ());
        
        // Executar
        if(pst.executeUpdate() > 0) {
            removeu = true;
        } 
        else {
            removeu = false;
        }

        Banco.desconectar();

        return removeu;
    }

    @Override
    public boolean altera(Bloqueio dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bloqueio buscaID(Bloqueio dado) throws SQLException {
        block = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM bloqueado WHERE CPFCNPJ = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Troca a ? 
        pst.setString(1, dado.getCPFCNPJ()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            block = new Bloqueio();
            //move os dados do resultSet para o objeto veiculo
            block.setCPFCNPJ(rs.getString("CPFCNPJ"));
        }
        
        Banco.desconectar();
        return block;
    }

    @Override
    public Collection<Bloqueio> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Bloqueio> listagem = new ArrayList<>();
        
        block = null;
        //Comando SELECT
        String sql = "SELECT * FROM Bloqueado ";
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
            block = new Bloqueio();
            //move os dados do resultSet para o objeto veiculo
            block.setCPFCNPJ(rs.getString("CPFCNPJ")); 
            
            //adicionar na coleção
            listagem.add(block);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
