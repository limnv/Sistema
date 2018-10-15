package models;

public class Deposito implements Model{
    
    private int ID;
    private int ContaID;
    private String DataOperacao;
    private Float ValorOperacao;
    private Float ValorFinal;
    private String Tipo;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContaID() {
        return ContaID;
    }

    public void setContaID(int ContaID) {
        this.ContaID = ContaID;
    }

    public String getDataOperacao() {
        return DataOperacao;
    }

    public void setDataOperacao(String DataOperacao) {
        this.DataOperacao = DataOperacao;
    }

    public Float getValorOperacao() {
        return ValorOperacao;
    }

    public void setValorOperacao(Float ValorOperacao) {
        this.ValorOperacao = ValorOperacao;
    }

    public Float getValorFinal() {
        return ValorFinal;
    }

    public void setValorFinal(Float ValorFinal) {
        this.ValorFinal = ValorFinal;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    @Override
    public String toInsertSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
