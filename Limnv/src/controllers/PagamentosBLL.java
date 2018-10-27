package controllers;

import java.sql.*;
import java.util.*;
import models.*;
import views.UsuarioLogado;

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
    
    public static List<Extrato> ObterListaPorData(String DataInicial, String DataFinal) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM pagamentos WHERE dataoperacao BETWEEN '" + DataInicial + "' AND '" + DataFinal + "' AND contaid = " + UsuarioLogado.ContaID;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Extrato> lista = new ArrayList<Extrato>();

            while (rs.next()) {
                Extrato e = new Extrato();
                e.setData(rs.getTimestamp("DATAOPERACAO"));  
                e.setDescricao("Pagamento: " + rs.getString("DESCRICAO") );                
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
