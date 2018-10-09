package views;

import java.sql.Connection;

public class main {

    public static void main(String[] args) {
        Connection conn = null;
        conn = models.Conexao.obterConexao();

        if (conn != null) {
            System.out.println("Conectado!");
            fLogin login = new fLogin();
            if (login.Exibir()){
                fMain principal = new fMain();                
            }            
        }
    }
}