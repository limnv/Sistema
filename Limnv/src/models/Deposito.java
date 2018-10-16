package models;

public class Deposito implements Model{
    
    private int ID;
    private int ContaID;
    private String DataOperacao;
    private double ValorOperacao;
    private double ValorFinal;
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

    public double getValorOperacao() {
        return ValorOperacao;
    }

    public void setValorOperacao(double ValorOperacao) {
        this.ValorOperacao = ValorOperacao;
    }

    public double getValorFinal() {
        return ValorFinal;
    }

    public void setValorFinal(double ValorFinal) {
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
        return "INSERT INTO depositos (CONTAID, DATAOPERACAO, VALOROPERACAO, VALORFINAL, TIPO) values (" + ContaID + ", '" + DataOperacao + "', " + ValorOperacao + ", " + ValorFinal + ", '" + Tipo + "')";
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
