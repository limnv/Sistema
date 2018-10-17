package models;

public class Saque implements Model{
    
    private int Id;
    private int ContaId;
    private String DataOperacao;
    private double ValorOperacao;
    private double ValorFinal;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getContaId() {
        return ContaId;
    }

    public void setContaId(int ContaId) {
        this.ContaId = ContaId;
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

    @Override
    public String toInsertSQL() {
        return "INSERT INTO saques (CONTAID, DATAOPERACAO, VALOROPERACAO, VALORFINAL) values (" + ContaId + ", '" + DataOperacao + "', " + ValorOperacao + ", " + ValorFinal + ")";
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
