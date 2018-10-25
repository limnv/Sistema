package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class ContasBLL {
    
    public static void Editar(Conta ct){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = ct.toUpdateSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
    
    public static void Inativar(Conta ct){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = ct.toDeletoSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }

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
    
    public static List<Conta> ObterListaContasPorClienteID(int ClienteID){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM contas WHERE clienteid= " + ClienteID + " AND ativo = 'S'";

        List<Conta> contas = new ArrayList<Conta>();

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                
                c.setID(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setClienteID(rs.getInt("clienteid"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setTipo(rs.getString("tipo"));
                c.setAtivo(rs.getString("ativo"));
                
                contas.add(c);
            }

            return contas;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static List<String> ObterDescricaoContas(int ClienteID) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT descricao FROM contas WHERE clienteid= " + ClienteID + " AND ativo = 'S'";

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
    
    public static Conta ObterContaPorId(int cod){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM contas WHERE id= " + cod;

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Conta c = new Conta();

            while (rs.next()) {
                c.setID(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setClienteID(rs.getInt("clienteid"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setTipo(rs.getString("tipo"));
                c.setAtivo(rs.getString("ativo"));                    
            }

            return c;
        } catch (SQLException ex) {
            return null;
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
