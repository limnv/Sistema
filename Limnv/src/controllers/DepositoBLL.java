package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Conexao;
import models.Deposito;

public class DepositoBLL {

    public static void Efetuar(Deposito d) {
        
        double ValorFinal = ContasBLL.AlterarSaldo(d.getValorOperacao(), "+", d.getContaID());

        d.setValorFinal(ValorFinal);

        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = d.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
