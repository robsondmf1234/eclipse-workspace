public class Cliente {

    private String nome;
    private String cpf;
    private String profissao;
    
    //Método utilizado para recuperar o nome
    public String getNome() {
        return nome;
    }
    
     //Método utilizado para setar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //Método utilizado para recuperar o cpf
    public String getCpf() {
        return cpf;
    }
    
     //Método utilizado para setar o cpf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    //Método utilizado para recuperar a profissão
    public String getProfissao() {
        return profissao;
    }
    
    //Método utilizado para setar a profissão
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
