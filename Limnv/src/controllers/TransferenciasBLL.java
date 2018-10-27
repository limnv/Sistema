package controllers;

import java.sql.*;
import java.util.*;
import models.*;
import views.UsuarioLogado;
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
    
    public static List<Extrato> ObterListaPorData(String DataInicial, String DataFinal) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM transferencias WHERE dataoperacao BETWEEN '" + DataInicial + "' AND '" + DataFinal + "' AND contaidorigem = " + UsuarioLogado.ContaID;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Extrato> lista = new ArrayList<Extrato>();

            while (rs.next()) {
                Extrato e = new Extrato();
                e.setData(rs.getTimestamp("DATAOPERACAO"));  
                e.setDescricao("Transferência para a Conta ID(" + rs.getInt("CONTAIDDESTINO") + ")");                
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
