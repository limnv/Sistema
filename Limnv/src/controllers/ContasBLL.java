package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public static List<String> ObterDescricaoContas(int ClienteID) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT descricao FROM contas WHERE clienteid= " + ClienteID;

        List<String> descricoes = new ArrayList<String>();

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String Nome = rs.getString("descricao");
                descricoes.add(Nome);
            }

            return descricoes;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int ObterContaIDPorDescricoes(String descricao) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT id FROM contas WHERE descricao= '" + descricao + "'";

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int codigo = -1;

            while (rs.next()) {
                codigo = rs.getInt("id");
            }

            return codigo;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static double ObterSaldo(int ContaID) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT saldo FROM contas WHERE id= " + ContaID;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            double saldo = -1;

            while (rs.next()) {
                saldo = rs.getDouble("saldo");
            }

            return saldo;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static double AlterarSaldo(double valor, String oper, int ContaID) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;
        
        double NovoSaldo = ObterSaldo(ContaID);
        
        switch(oper) {
            case "+":
                NovoSaldo += valor;
                break;
            case "-":
                NovoSaldo -= valor;
                break;
        }

        String sql = "UPDATE contas SET saldo = " + NovoSaldo + " WHERE id = " + ContaID;

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();
            
            return NovoSaldo;

        } catch (SQLException ex) {
            return -1;
        }
    }

}
