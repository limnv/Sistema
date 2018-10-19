package models;

/**
 *
 * @author luism
 */
public class Transferencia implements Model {
    private int ID;
    private int ContaIDOrigem;
    private int ContaIDDestino;
    private String DataOperacao;
    private double ValorOperacao;
    private double ValorFinal;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContaIDOrigem() {
        return ContaIDOrigem;
    }

    public void setContaIDOrigem(int ContaIDOrigem) {
        this.ContaIDOrigem = ContaIDOrigem;
    }

    public int getContaIDDestino() {
        return ContaIDDestino;
    }

    public void setContaIDDestino(int ContaIDDestino) {
        this.ContaIDDestino = ContaIDDestino;
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
        return "INSERT INTO transferencias (CONTAIDORIGEM, CONTAIDDESTINO, DATAOPERACAO, VALOROPERACAO, VALORFINAL) values (" + ContaIDOrigem + ", " + ContaIDDestino + ", '" + DataOperacao + "', " + ValorOperacao + ", " + ValorFinal + ")";
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
