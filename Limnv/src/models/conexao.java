package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    
    public static Connection obterConexao() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbURL = "jdbc:sqlserver://localhost;databaseName=limnv;integratedSecurity=true;";
        return DriverManager.getConnection(dbURL);

    }

}
