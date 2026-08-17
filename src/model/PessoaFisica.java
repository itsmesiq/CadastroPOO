package model;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;

    // Constructor
    public PessoaFisica(int id, String nome, String email, String cpf, int idade) {
        super(id, nome, email);
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    // Stters
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
}
