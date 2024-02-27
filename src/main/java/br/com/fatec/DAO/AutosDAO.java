package br.com.fatec.DAO;

import br.com.fatec.conexao.Banco;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Categoria;
import br.com.fatec.model.Direcao;
import br.com.fatec.model.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class AutosDAO implements DAO <Autos>{
    
    private Autos autos;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insere(Autos dado) throws SQLException {
        boolean inseriu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "INSERT INTO frota_carro (Placa, Chassi, Marca, Modelo, "
                   + "Ano, Combustivel, Motorizacao, Cambio, Direcao, Preco, "
                   + "Categoria, Quilometragem, MaxVelocidade, ID) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getPlaca());
        pst.setString(2, dado.getChassi());
        pst.setInt(3, dado.getMarca().getCodigo());
        pst.setString(4, dado.getModelo());
        pst.setInt(5, dado.getFabricacao());
        pst.setString(6, dado.getCombustivel());
        pst.setString(7, dado.getMotorizacao());
        pst.setInt(8, dado.getCambio().getCodigo());
        pst.setInt(9, dado.getDirecao().getCodigo());
        pst.setFloat(10, dado.getValor());
        pst.setInt(11, dado.getCategoria().getCodigo());
        pst.setFloat(12, dado.getQuilometragem());
        pst.setString(13, dado.getVelocidade());
        pst.setInt(14, dado.getOrdem());

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
    public boolean remove(Autos dado) throws SQLException {
        boolean removeu;
        
        Banco.conectar();

        // Comando SQL
        String sql = "DELETE FROM frota_carro WHERE Placa = ?";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(1, dado.getPlaca());
        
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
    public boolean altera(Autos dado) throws SQLException {
        boolean alterou;
        
        Banco.conectar();

        // Comando SQL
        String sql = "UPDATE frota_carro SET Chassi = ?, Marca = ?, "
                   + "Modelo = ?, Ano = ?, Combustivel = ?, Motorizacao = ?, "
                   + "Cambio = ?, Direcao = ?, Preco = ?, "
                   + "Categoria = ?, Quilometragem = ?, MaxVelocidade = ?, "
                   + "ID = ? WHERE Placa = ?;";

        // Criar PrepareStatement
        pst = Banco.obterConexao().prepareStatement(sql);

        // Colocar dados no PST
        pst.setString(14, dado.getPlaca());
        pst.setString(1, dado.getChassi());
        pst.setInt(2, dado.getMarca().getCodigo());
        pst.setString(3, dado.getModelo());
        pst.setInt(4, dado.getFabricacao());
        pst.setString(5, dado.getCombustivel());
        pst.setString(6, dado.getMotorizacao());
        pst.setInt(7, dado.getCambio().getCodigo());
        pst.setInt(8, dado.getDirecao().getCodigo());
        pst.setFloat(9, dado.getValor());
        pst.setInt(10, dado.getCategoria().getCodigo());
        pst.setFloat(11, dado.getQuilometragem());
        pst.setString(12, dado.getVelocidade());
        pst.setInt(13, dado.getOrdem());
        

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
    public Autos buscaID(Autos dado) throws SQLException {
        MarcaDAO marcaDAO = new MarcaDAO();
        CambioDAO cambioDAO = new CambioDAO();
        DirecaoDAO direcaoDAO = new DirecaoDAO();
        CategoriaDAO categDAO = new CategoriaDAO();
        
        autos = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM frota_carro WHERE Placa = ?"; 
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Troca a ? 
        pst.setString(1, dado.getPlaca()); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            autos = new Autos();
            //move os dados do resultSet para o objeto veiculo
            autos.setPlaca(rs.getString("Placa")); 
            autos.setChassi(rs.getString("Chassi"));
            
            Marca marca = new Marca();
            marca.setCodigo(rs.getInt("Marca"));
            marca = marcaDAO.buscaID(marca);
            autos.setMarca(marca);
            
            autos.setModelo(rs.getString("Modelo"));
            autos.setFabricacao(rs.getInt("Ano"));
            autos.setCombustivel(rs.getString("Combustivel"));
            autos.setMotorizacao(rs.getString("Motorizacao"));
            
            Cambio cambio = new Cambio();
            cambio.setCodigo(rs.getInt("Cambio"));
            cambio = cambioDAO.buscaID(cambio);
            autos.setCambio(cambio);
            
            Direcao direcao = new Direcao();
            direcao.setCodigo(rs.getInt("Direcao"));
            direcao = direcaoDAO.buscaID(direcao);
            autos.setDirecao(direcao);
            
            autos.setValor(rs.getFloat("Preco"));
            
            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt("Categoria"));
            categoria = categDAO.buscaID(categoria);
            autos.setCategoria(categoria);
            
            autos.setQuilometragem(rs.getFloat("Quilometragem"));
            autos.setVelocidade(rs.getString("MaxVelocidade"));
            autos.setOrdem(rs.getInt("ID"));
        }
        
        Banco.desconectar();
        return autos;
    }

    @Override
    public Collection<Autos> lista(String filtro) throws SQLException {
        // DAOS
        MarcaDAO marcaDAO = new MarcaDAO();
        CambioDAO cambioDAO = new CambioDAO();
        DirecaoDAO direcaoDAO = new DirecaoDAO();
        CategoriaDAO categDAO = new CategoriaDAO();
        
        //criar uma coleção
        Collection<Autos> listagem = new ArrayList<>();
        
        autos = null;
        //Comando SELECT
        String sql = "SELECT * FROM frota_carro ";
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
            autos = new Autos();
            //move os dados do resultSet para o objeto veiculo
            autos.setPlaca(rs.getString("Placa")); 
            autos.setChassi(rs.getString("Chassi"));
            
            Marca marca = new Marca();
            marca.setCodigo(rs.getInt("Marca"));
            marca = marcaDAO.buscaID(marca);
            autos.setMarca(marca);
            
            autos.setModelo(rs.getString("Modelo"));
            autos.setFabricacao(rs.getInt("Ano"));
            autos.setCombustivel(rs.getString("Combustivel"));
            autos.setMotorizacao(rs.getString("Motorizacao"));
            
            Cambio cambio = new Cambio();
            cambio.setCodigo(rs.getInt("Cambio"));
            cambio = cambioDAO.buscaID(cambio);
            autos.setCambio(cambio);
            
            Direcao direcao = new Direcao();
            direcao.setCodigo(rs.getInt("Direcao"));
            direcao = direcaoDAO.buscaID(direcao);
            autos.setDirecao(direcao);
            
            autos.setValor(rs.getFloat("Preco"));
            
            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt("Categoria"));
            categoria = categDAO.buscaID(categoria);
            autos.setCategoria(categoria);
            
            autos.setQuilometragem(rs.getFloat("Quilometragem"));
            autos.setVelocidade(rs.getString("MaxVelocidade"));
            autos.setOrdem(rs.getInt("ID"));

            //adicionar na coleção
            listagem.add(autos);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
    public LinkedList<Autos> Puxar(String filtro) throws SQLException {
        MarcaDAO marcaDAO = new MarcaDAO();
        CambioDAO cambioDAO = new CambioDAO();
        DirecaoDAO direcaoDAO = new DirecaoDAO();
        CategoriaDAO categDAO = new CategoriaDAO();
        
        LinkedList<Autos> listagem = new LinkedList<>();
        
        autos = null;
        
        // Comando SELECT 
        String sql = "SELECT * FROM frota_carro ";
        //colocar filtro ou nao
        if(filtro.length() != 0) {
            sql += "WHERE " + filtro;
        }
        
        // Conecta ao Banco 
        Banco.conectar(); 
        pst = Banco.obterConexao().prepareStatement(sql); 
        
        // Executa o SELECT 
        rs = pst.executeQuery();
        
        //le o próximo regitro
        while(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            autos = new Autos();
            //move os dados do resultSet para o objeto veiculo
            autos.setPlaca(rs.getString("Placa")); 
            autos.setChassi(rs.getString("Chassi"));
            
            Marca marca = new Marca();
            marca.setCodigo(rs.getInt("Marca"));
            marca = marcaDAO.buscaID(marca);
            autos.setMarca(marca);
            
            autos.setModelo(rs.getString("Modelo"));
            autos.setFabricacao(rs.getInt("Ano"));
            autos.setCombustivel(rs.getString("Combustivel"));
            autos.setMotorizacao(rs.getString("Motorizacao"));
            
            Cambio cambio = new Cambio();
            cambio.setCodigo(rs.getInt("Cambio"));
            cambio = cambioDAO.buscaID(cambio);
            autos.setCambio(cambio);
            
            Direcao direcao = new Direcao();
            direcao.setCodigo(rs.getInt("Direcao"));
            direcao = direcaoDAO.buscaID(direcao);
            autos.setDirecao(direcao);
            
            autos.setValor(rs.getFloat("Preco"));
            
            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt("Categoria"));
            categoria = categDAO.buscaID(categoria);
            autos.setCategoria(categoria);
            
            autos.setQuilometragem(rs.getFloat("Quilometragem"));
            autos.setVelocidade(rs.getString("MaxVelocidade"));
            autos.setOrdem(rs.getInt("ID"));
            
            listagem.add(autos);
        }
        
        Banco.desconectar(); 
        return listagem;
    }
}
