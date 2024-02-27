package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Cartao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class CartaoDAO implements DAO <Cartao>{
    
    private Cartao cartao;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Cartao dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO cartao (Pagamento, Bandeira, "
                   + "Nome, Numero, Vence, CVV) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getTipo());
        pst.setString(2, dado.getBandeira());
        pst.setString(3, dado.getNome());
        pst.setInt(4, dado.getNumero());
        pst.setString(5, dado.getVence());
        pst.setInt(6, dado.getCVV());

        // Executar
        if(pst.executeUpdate() > 0) {
            inseriu = true;
        } 
        else {
            inseriu = false;
        }

        Banco.desconectar();
        System.out.println("Chegou aqui");
        return inseriu;
    }

    @Override
    public boolean remove(Cartao dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM cartao WHERE Numero = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setInt(1, dado.getNumero());
        
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
    public boolean altera(Cartao dado) throws SQLException {
        boolean alterou;
        
        Banco.conectar();

        // Comando SQL
        String sql = "UPDATE cartao SET Pagamento = ?, Bandeira = ?, "
                   + "Nome = ?, Vence = ?, CVV = ? "
                   + "WHERE Numero = ?;";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getTipo());
        pst.setString(2, dado.getBandeira());
        pst.setString(3, dado.getNome());
        pst.setInt(6, dado.getNumero());
        pst.setString(4, dado.getVence());
        pst.setInt(5, dado.getCVV());
        

        // Executar
        if(pst.executeUpdate() > 0) {
            alterou = true;
        } 
        else {
            alterou = false;
        }

        Banco.desconectar();

        return alterou;
    }

    @Override
    public Cartao buscaID(Cartao dado) throws SQLException {
        cartao = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM cartao WHERE Numero = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Troca a ? 
        pst.setInt(1, dado.getNumero()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            cartao = new Cartao();
            //move os dados do resultSet para o objeto veiculo
            cartao.setTipo(rs.getString("Pagamento")); 
            cartao.setBandeira(rs.getString("Bandeira"));
            cartao.setNome(rs.getString("Nome"));
            cartao.setNumero(rs.getInt("Numero"));
            cartao.setVence(rs.getString("Vence"));
            cartao.setCVV(rs.getInt("CVV"));
        }
        
        Banco.desconectar();
        return cartao;
    }

    @Override
    public Collection<Cartao> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<Cartao> listagem = new ArrayList<>();
        
        cartao = null;
        //Comando SELECT
        String sql = "SELECT * FROM cartao ";
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
            cartao = new Cartao();
            //move os dados do resultSet para o objeto veiculo
            cartao.setTipo(rs.getString("Pagamento")); 
            cartao.setBandeira(rs.getString("Bandeira"));
            cartao.setNome(rs.getString("Nome"));
            cartao.setNumero(rs.getInt("Numero"));
            cartao.setVence(rs.getString("Vence"));
            cartao.setCVV(rs.getInt("CVV"));

            //adicionar na coleção
            listagem.add(cartao);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
