package views;

import java.sql.Connection;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = models.conexao.obterConexao();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getErrorCode());
        }

        if (conn != null) {
            System.out.println("Conectado!");
            fPrincipal form = new fPrincipal();
            form.show();
        }
    }
}