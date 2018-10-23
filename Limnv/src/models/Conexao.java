package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public static Connection ConexaoAtual;

    public static Connection obterConexao() {
        if (ConexaoAtual == null) {
            try {
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                String dbURL = "jdbc:sqlserver://localhost;databaseName=limnv;integratedSecurity=true;";
                ConexaoAtual = DriverManager.getConnection(dbURL);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        return ConexaoAtual;
    }

}
