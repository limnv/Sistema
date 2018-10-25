package models;

/**
 *
 * @author luism
 */
public class ContasVM {
    private int Codigo;
    private String Descricao;
    private String Tipo;
    
    public ContasVM(Conta c){
        this.Codigo = c.getID();
        this.Descricao = c.getDescricao();
        this.Tipo = c.getTipo();
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
