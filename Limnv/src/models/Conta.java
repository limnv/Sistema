package models;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toDeletoSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
