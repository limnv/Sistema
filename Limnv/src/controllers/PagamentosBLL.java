package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Conexao;
import models.Pagamento;

/**
 *
 * @author luism
 */
public class PagamentosBLL {
    public static void Efetuar(Pagamento p){
        double ValorFinal = ContasBLL.AlterarSaldo(p.getValorOperacao(), "-", p.getContaID());

        p.setValorFinal(ValorFinal);

        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = p.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
