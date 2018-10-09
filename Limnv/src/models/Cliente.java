package models;

public class Cliente implements Model {
    private int Id;
    private String Nome;
    private String Cpf;
    private String Senha;

    public Cliente(int Id, String Nome, String Cpf, String Senha) {
        this.Id = Id;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Senha = Senha;
    }
    
    public Cliente() {
    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    @Override
    public String toInsertSQL(){
        return "INSERT INTO CLIENTES (NOME, CPF, SENHA) values ('" + Nome + "', '" + Cpf + "','" + Senha + "')";
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
