package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conta implements Model {
    private int ID;
    private String Descricao;
    private int ClienteID;
    private double Saldo;
    private String Tipo;
    private String Ativo;    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getAtivo() {
        return Ativo;
    }

    public void setAtivo(String Ativo) {
        this.Ativo = Ativo;
    }
    

    @Override
    public String toInsertSQL() {
        return "INSERT INTO CONTAS (DESCRICAO, CLIENTEID, TIPO) values ('" + Descricao + "', " + ClienteID + ",'" + Tipo + "')";
    }

    @Override
    public String toUpdateSQL() {
        return "UPDATE contas SET DESCRICAO = '" + Descricao + "', TIPO = '" + Tipo + "' WHERE ID = " + ID;
    }

    @Override
    public String toDeletoSQL() {
        return "UPDATE contas SET ATIVO = 'N' WHERE ID = " + ID;
    }
    
}
