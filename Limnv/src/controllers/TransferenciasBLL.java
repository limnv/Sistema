package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Conexao;
import models.Transferencia;

/**
 *
 * @author luism
 */
public class TransferenciasBLL {
    public static void Efetuar(Transferencia t){
                
        double ValorFinal = ContasBLL.AlterarSaldo(t.getValorOperacao(), "-", t.getContaIDOrigem());

        t.setValorFinal(ValorFinal);
        
        double temp = ContasBLL.AlterarSaldo(t.getValorOperacao(), "+", t.getContaIDDestino());

        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = t.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
