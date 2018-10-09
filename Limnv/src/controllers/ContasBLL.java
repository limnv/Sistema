package controllers;

import java.sql.*;
import models.*;

public class ContasBLL {
    
    public static void Inserir(Conta ct) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = ct.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();           

        } catch (SQLException ex) {
        }
    }
}
