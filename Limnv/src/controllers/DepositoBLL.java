package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Conexao;
import models.Deposito;
import models.Extrato;
import views.UsuarioLogado;

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

    public static List<Extrato> ObterListaPorData(String DataInicial, String DataFinal) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM depositos WHERE dataoperacao BETWEEN '" + DataInicial + "' AND '" + DataFinal + "' AND contaid = " + UsuarioLogado.ContaID;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Extrato> lista = new ArrayList<Extrato>();

            while (rs.next()) {
                Extrato e = new Extrato();
                e.setData(rs.getDate("DATAOPERACAO"));
                String Tipo = rs.getString("TIPO");
                if(Tipo.equals("D")){
                    e.setDescricao("Depósito em Dinheiro");
                } else {
                    e.setDescricao("Depósito em Cheque");
                }
                e.setValorOperacao(rs.getDouble("VALOROPERACAO"));
                e.setValorFinal(rs.getDouble("VALORFINAL"));

                lista.add(e);
            }

            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
