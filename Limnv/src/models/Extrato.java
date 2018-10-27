package models;

import java.util.Date;

/**
 *
 * @author luism
 */
public class Extrato {
    private Date Data;
    private String Descricao;
    private double ValorOperacao;
    private double ValorFinal;

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
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
        
}
