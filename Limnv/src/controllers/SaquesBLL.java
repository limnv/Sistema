package controllers;

import java.sql.*;
import java.util.*;
import models.*;
import views.UsuarioLogado;

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
    
    public static List<Extrato> ObterListaPorData(String DataInicial, String DataFinal) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM saques WHERE dataoperacao BETWEEN '" + DataInicial + "' AND '" + DataFinal + "' AND contaid = " + UsuarioLogado.ContaID;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Extrato> lista = new ArrayList<Extrato>();

            while (rs.next()) {
                Extrato e = new Extrato();
                e.setData(rs.getTimestamp("DATAOPERACAO"));  
                e.setDescricao("Saque");                
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
