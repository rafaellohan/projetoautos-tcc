package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Cartao;
import br.com.fatec.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class UsuarioDAO implements DAO <Usuario>{
    
    private Usuario usuario;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Usuario dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO usuario (CPF, Nome, Sobrenome, "
                   + "Endereco, Cidade, Estado, "
                   + "Telefone, Email, Num_Cartao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getCPF());
        pst.setString(2, dado.getNome());
        pst.setString(3, dado.getSobrenome());
        pst.setString(4, dado.getEndereco());
        pst.setString(5, dado.getCidade());
        pst.setString(6, dado.getEstado());
        pst.setString(7, dado.getTelefone());
        pst.setString(8, dado.getEmail());
        pst.setInt(9, dado.getCartao().getNumero());

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
    public boolean remove(Usuario dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM usuario WHERE CPF = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getCPF());
        
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
    public boolean altera(Usuario dado) throws SQLException {
        boolean alterou;
        
        Banco.conectar();

        // Comando SQL
        String sql = "UPDATE usuario SET Nome = ?, Sobrenome = ?, "
                   + "Endereco = ?, Cidade = ?, Estado = ?, "
                   + "Telefone = ?, Email = ?, Num_Cartao = ? WHERE CPF = ?;";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(9, dado.getCPF());
        pst.setString(1, dado.getNome());
        pst.setString(2, dado.getSobrenome());
        pst.setString(3, dado.getEndereco());
        pst.setString(4, dado.getCidade());
        pst.setString(5, dado.getEstado());
        pst.setString(6, dado.getTelefone());
        pst.setString(7, dado.getEmail());
        pst.setInt(8, dado.getCartao().getNumero());
        

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
    public Usuario buscaID(Usuario dado) throws SQLException {
        CartaoDAO cartaoDAO = new CartaoDAO();
        
        usuario = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM usuario WHERE CPF = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Troca a ? 
        pst.setString(1, dado.getCPF()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            usuario = new Usuario();
            //move os dados do resultSet para o objeto veiculo
            usuario.setCPF(rs.getString("CPF")); 
            usuario.setNome(rs.getString("Nome"));
            usuario.setSobrenome(rs.getString("Sobrenome"));
            usuario.setEndereco(rs.getString("Endereco"));
            usuario.setCidade(rs.getString("Cidade"));
            usuario.setEstado(rs.getString("Estado"));
            usuario.setTelefone(rs.getString("Telefone"));
            usuario.setEmail(rs.getString("Email"));
            
            Cartao cartao = new Cartao();
            cartao.setNumero(rs.getInt("Num_Cartao"));
            cartao = cartaoDAO.buscaID(cartao);
            usuario.setCartao(cartao);
        }
        
        Banco.desconectar();
        return usuario;
    }

    @Override
    public Collection<Usuario> lista(String filtro) throws SQLException {
        CartaoDAO cartaoDAO = new CartaoDAO();

        //criar uma coleção
        Collection<Usuario> listagem = new ArrayList<>();
        
        usuario = null;
        //Comando SELECT
        String sql = "SELECT * FROM usuario ";
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
            usuario = new Usuario();
            //move os dados do resultSet para o objeto veiculo
            usuario.setCPF(rs.getString("CPF")); 
            usuario.setNome(rs.getString("Nome"));
            usuario.setSobrenome(rs.getString("Sobrenome"));
            usuario.setEndereco(rs.getString("Endereco"));
            usuario.setCidade(rs.getString("Cidade"));
            usuario.setEstado(rs.getString("Estado"));
            usuario.setTelefone(rs.getString("Telefone"));
            usuario.setEmail(rs.getString("Email"));
            
            Cartao cartao = new Cartao();
            cartao.setNumero(rs.getInt("Num_Cartao"));
            cartao = cartaoDAO.buscaID(cartao);
            usuario.setCartao(cartao);

            //adicionar na coleção
            listagem.add(usuario);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}