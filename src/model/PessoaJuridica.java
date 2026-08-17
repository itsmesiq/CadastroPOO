package model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(int id, String nome, String email, String cnpj) {
        super(id, nome, email);
        this.cnpj = cnpj;
    }

    // Getters
    public String getCnpj () {
        return cnpj;
    }

    // Setters
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
}
