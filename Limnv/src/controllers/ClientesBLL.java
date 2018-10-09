package controllers;

import java.sql.*;
import models.Cliente;
import models.Conexao;

public class ClientesBLL {
    
    public static void Inserir(Cliente c) {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = c.toInsertSQL();

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();           

        } catch (SQLException ex) {
        }
    }
    
    public static Cliente ObterPorCPF(String CPF){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT * FROM clientes WHERE cpf= '" + CPF + "'";

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Cliente c = null;

            while (rs.next()) {
                int Id = rs.getInt("ID");
                String Nome = rs.getString("NOME");
                String Cpf = rs.getString("CPF");
                String Senha = rs.getString("SENHA");

                c = new Cliente(Id, Nome, Cpf, Senha);
            }

            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static int ObterIDPorCPF(String CPF){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "SELECT ID FROM clientes WHERE cpf='" + CPF + "'";

        try {
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            int Id = -1;
            
            while (rs.next()) {
                Id = rs.getInt("ID");
            }

            return Id;
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    public static void ApagarPorID(int ID){
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;

        String sql = "DELETE FROM clientes WHERE ID = " + ID;

        try {
            ps = conn.prepareStatement(sql);

            int result = ps.executeUpdate();           

        } catch (SQLException ex) {
        }
    }
}
