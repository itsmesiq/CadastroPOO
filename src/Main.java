import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            PessoaFisica pessoa1 = new PessoaFisica(1, "Archie", "archie@gmail.com", "123.456.789-00", 30);
            PessoaFisica pessoa2 = new PessoaFisica(2, "Betty", "betty@gmail.com", "987.654.321-00", 28);

            repo1.inserir(pessoa1);
            repo1.inserir(pessoa2);

            repo1.persistir("pessoas-fisicas.bin");

            System.out.println("Dados de Pessoa Física Armazenados.");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            repo2.recuperar("pessoas-fisicas.bin");

            System.out.println("Dados de Pessoa Física Recuperados.");

            for(PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
            }

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            PessoaJuridica empresa1 = new PessoaJuridica(1, "Empresa A", "empresaA@gmail.com", "12.345.678/0001-90");
            PessoaJuridica empresa2 = new PessoaJuridica(2, "Empresa B", "empresaB@gmail.com", "98.765.432/0001-90");

            repo3.inserir(empresa1);
            repo3.inserir(empresa2);

            repo3.persistir("pessoas-juridicas.bin");

            System.out.println("Dados de Pessoa Jurídica Armazenados.");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            repo4.recuperar("pessoas-juridicas.bin");

            System.out.println("Dados de Pessoa Jurídica Recuperados.");
            
            for(PessoaJuridica empresa : repo4.obterTodos()) {
                empresa.exibir();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
