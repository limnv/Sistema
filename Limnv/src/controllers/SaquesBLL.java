package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Conexao;
import models.Saque;

/**
 *
 * @author luism
 */
public class SaquesBLL {
    
    public static void Efetuar(Saque s){
        
        double ValorFinal = ContasBLL.AlterarSaldo(s.getValorOperacao(), "-", s.getContaId());

        s.setValorFinal(ValorFinal);

        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = s.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
