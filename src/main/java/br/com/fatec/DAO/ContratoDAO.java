package br.com.fatec.DAO;

import br.com.fatec.model.Contrato;
import br.com.fatec.conexao.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class ContratoDAO implements DAO <Contrato>{
    
    private Contrato contrato;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Contrato dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO Usuario (CPF, Nome, Sobrenome, Nascimento"
                   + "Endereco, Cidade, Estado, Telefone, Email) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getCpf());
        pst.setString(2, dado.getNome());
        pst.setString(3, dado.getSobrenome());
        pst.setString(4, dado.getNascimento());
        pst.setString(5, dado.getEndereco());
        pst.setString(6, dado.getCidade());
        pst.setString(7, dado.getEstado());
        pst.setString(8, dado.getTelefone());
        pst.setString(9, dado.getEmail());

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
    public boolean remove(Contrato dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM Usuario WHERE CPF = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getCpf());
        
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
    public boolean altera(Contrato dado) throws SQLException {
        boolean alterou;
        
        Banco.conectar();

        // Comando SQL
        String sql = "UPDATE Usuario SET Nome = ?, Sobrenome = ?, "
                   + "Nascimento = ?, Endereco = ?, Cidade = ?, Estado = ?, "
                   + "Telefone = ?, Email = ? WHERE CPF = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(9, dado.getCpf());
        pst.setString(1, dado.getNome());
        pst.setString(2, dado.getSobrenome());
        pst.setString(3, dado.getNascimento());
        pst.setString(4, dado.getEndereco());
        pst.setString(5, dado.getCidade());
        pst.setString(6, dado.getEstado());
        pst.setString(7, dado.getTelefone());
        pst.setString(8, dado.getEmail());

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
    public Contrato buscaID(Contrato dado) throws SQLException {
        
        contrato = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM Usuario WHERE CPF = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Troca a ? 
        pst.setString(1, dado.getCpf()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        // Cria o Objeto Veiculo 
        contrato = new Contrato(); 
            
        // resultSet Para o Objeto Veiculo 
        contrato.setCpf(rs.getString("CPF")); 
        contrato.setNome(rs.getString("Nome")); 
        contrato.setSobrenome(rs.getString("Sobrenome"));
        contrato.setNascimento(rs.getString("Nascimento"));
        contrato.setEndereco(rs.getString("Endereco"));
        contrato.setCidade(rs.getString("Cidade"));
        contrato.setEstado(rs.getString("Estado"));
        contrato.setTelefone(rs.getString("Telefone"));
        contrato.setEmail(rs.getString("Email"));
        
        Banco.desconectar(); 
        return contrato;
    }

    @Override
    public Collection<Contrato> lista(String filtro) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
