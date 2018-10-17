package models;

/**
 *
 * @author luism
 */
public class Pagamento implements Model{
    private int ID;
    private int ContaID;
    private String Descricao;
    private String CodigoBarras;
    private String DataOperacao;
    private double ValorOperacao;
    private double ValorFinal;

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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String CodigoBarras) {
        this.CodigoBarras = CodigoBarras;
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
        return "INSERT INTO pagamentos (CONTAID, DESCRICAO, CODIGOBARRAS, DATAOPERACAO, VALOROPERACAO, VALORFINAL) values (" + ContaID + ", '" + Descricao + "', '" + CodigoBarras + "', '" + DataOperacao + "', " + ValorOperacao + ", " + ValorFinal + ")";
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
