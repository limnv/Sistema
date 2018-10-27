package models;

/**
 *
 * @author luism
 */
public class ExtratoArvore {
    private ExtratoArvore Esquerda;
    private Extrato Dado;
    private ExtratoArvore Direita;

    public ExtratoArvore getEsquerda() {
        return Esquerda;
    }

    public void setEsquerda(ExtratoArvore Esquerda) {
        this.Esquerda = Esquerda;
    }

    public Extrato getDado() {
        return Dado;
    }

    public void setDado(Extrato Dado) {
        this.Dado = Dado;
    }

    public ExtratoArvore getDireita() {
        return Direita;
    }

    public void setDireita(ExtratoArvore Direita) {
        this.Direita = Direita;
    }
    
    
    
}
