package br.com.fatec.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static String bancoDados, usuario, senha, servidor;
    public static int porta;
    
    public static java.sql.Connection conexao = null;
    
    static {
        bancoDados = "locadoraautos";
        usuario = "root";
        senha = "";
        servidor = "localhost";
        porta = 3306;
    }
    
    public static void conectar() throws SQLException {
        String url = "jdbc:mysql://" + servidor +
                     ":" + porta + "/" + bancoDados;

        conexao = DriverManager.getConnection(url, usuario, senha);
    }

    public static void desconectar() throws SQLException {
        conexao.close();
    }

    public static java.sql.Connection obterConexao() 
                throws SQLException {
        if (conexao == null) {
            throw new SQLException("Conexão está fechada..");
        } else {
            return conexao;
        }
    }
}
