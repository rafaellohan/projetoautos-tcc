package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Usuario;
import br.com.fatec.model.UsuarioFrota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class UsuarioFrotaDAO implements DAO <UsuarioFrota>{
    
    private UsuarioFrota usuarioFrota;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(UsuarioFrota dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO usuario_alocar_carro (Data_Alocacao, Termino_Alocacao, "
                   + "Aluguel, Placa_Frota, CPF_Usuario, Total, SubTotal, Taxa) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getComeco());
        pst.setString(2, dado.getFim());
        pst.setString(3, dado.getAluguel());
        pst.setString(4, dado.getAutos().getPlaca());
        pst.setString(5, dado.getUsuario().getCPF());
        pst.setFloat(6, dado.getTotal());
        pst.setFloat(7, dado.getSubTotal());
        pst.setFloat(8, dado.getTaxa());

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
    public boolean remove(UsuarioFrota dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM usuario_alocar_carro WHERE CPF_Usuario = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getUsuario().getCPF());
        
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
    public boolean altera(UsuarioFrota dado) throws SQLException {
        boolean alterou;
        
        Banco.conectar();

        // Comando SQL
        String sql = "UPDATE usuario_alocar_carro SET Data_Alocacao = ?, "
                   + "Termino_Alocacao = ?, Aluguel = ?, Placa_Frota = ?, "
                   + "Total = ?, SubTotal = ?, Taxa = ? WHERE CPF_Usuario = ?;";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(8, dado.getUsuario().getCPF());
        pst.setString(1, dado.getComeco());
        pst.setString(2, dado.getFim());
        pst.setString(3, dado.getAluguel());
        pst.setString(4, dado.getAutos().getPlaca());
        pst.setFloat(5, dado.getTotal());
        pst.setFloat(6, dado.getSubTotal());
        pst.setFloat(7, dado.getTaxa());

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
    public UsuarioFrota buscaID(UsuarioFrota dado) throws SQLException {
        AutosDAO autosDAO = new AutosDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioFrota = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM usuario_alocar_carro WHERE CPF_Usuario = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql);
        // Troca a ? 
        pst.setString(1, dado.getUsuario().getCPF()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            usuarioFrota = new UsuarioFrota();
            //move os dados do resultSet para o objeto veiculo
            usuarioFrota.setComeco(rs.getString("Data_Alocacao")); 
            usuarioFrota.setFim(rs.getString("Termino_Alocacao"));
            usuarioFrota.setAluguel(rs.getString("Aluguel"));
            
            Autos autos = new Autos();
            autos.setPlaca(rs.getString("Placa_Frota"));
            autos = autosDAO.buscaID(autos);
            usuarioFrota.setAutos(autos);
            
            Usuario usuario = new Usuario();
            usuario.setCPF(rs.getString("CPF_Usuario"));
            usuario = usuarioDAO.buscaID(usuario);
            usuarioFrota.setUsuario(usuario);
            
            usuarioFrota.setTotal(rs.getFloat("Total"));
            usuarioFrota.setSubTotal(rs.getFloat("SubTotal"));
            usuarioFrota.setTaxa(rs.getFloat("Taxa"));
        }
        
        Banco.desconectar();
        return usuarioFrota;
    }

    @Override
    public Collection<UsuarioFrota> lista(String filtro) throws SQLException {
        //criar uma coleção
        Collection<UsuarioFrota> listagem = new ArrayList<>();
        AutosDAO autosDAO = new AutosDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioFrota = null;
        //Comando SELECT
        String sql = "SELECT * FROM usuario_alocar_carro ";
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
            usuarioFrota = new UsuarioFrota();
            //move os dados do resultSet para o objeto veiculo
            usuarioFrota.setComeco(rs.getString("Data_Alocacao")); 
            usuarioFrota.setFim(rs.getString("Termino_Alocacao"));
            usuarioFrota.setAluguel(rs.getString("Aluguel"));
            
            Autos autos = new Autos();
            autos.setPlaca(rs.getString("Placa_Frota"));
            autos = autosDAO.buscaID(autos);
            usuarioFrota.setAutos(autos);
            
            Usuario usuario = new Usuario();
            usuario.setCPF(rs.getString("CPF_Usuario"));
            usuario = usuarioDAO.buscaID(usuario);
            usuarioFrota.setUsuario(usuario);
            
            usuarioFrota.setTotal(rs.getFloat("Total"));
            usuarioFrota.setSubTotal(rs.getFloat("SubTotal"));
            usuarioFrota.setTaxa(rs.getFloat("Taxa"));

            //adicionar na coleção
            listagem.add(usuarioFrota);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
}
