import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;
        int id;
        String nome;
        String email;
        String tipoPessoa;

        do {
            System.out.println("==============================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("==============================");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    tipoPessoa = obterTipoPessoa(scanner);
                    id = coletarId(scanner);
                    nome = coletarNome(scanner);
                    email = coletarEmail(scanner);

                    if (tipoPessoa.equals("F")){
                        String cpf = coletarCpf(scanner);
                        int idade = coletarIdade(scanner);
                        repoFisica.inserir(new PessoaFisica(id, nome, email, cpf, idade));
                        System.out.println("Pessoa Física inserida com sucesso."

                        );
                    } else if (tipoPessoa.equals("J")) {
                        String cnpj = coletarCnpj(scanner);
                        repoJuridica.inserir(new PessoaJuridica(id, nome, email, cnpj));
                        System.out.println("Pessoa Jurídica inserida com sucesso.");

                    } else {
                        System.out.println("Tipo de pessoa inválido.");
                    }
                    break;

                case 2:
                    tipoPessoa = obterTipoPessoa(scanner);
                    id = coletarId(scanner);

                    if (tipoPessoa.equals("F")){
                        PessoaFisica pessoa = repoFisica.obter(id);

                        if (pessoa == null) {
                            System.out.println("Pessoa não encontrada.");
                            break;
                        } 

                        System.out.println("Dados atuais: ");
                        pessoa.exibir();

                        System.out.println("Digite os novos dados");

                        nome = coletarNome(scanner);
                        email = coletarEmail(scanner);
                        String cpf = coletarCpf(scanner);
                        int idade = coletarIdade(scanner);

                        PessoaFisica pessoaAlterada = new PessoaFisica(id, nome, email, cpf, idade);

                        repoFisica.alterar(pessoaAlterada);

                        System.out.println("Pessoa Física alterada com sucesso.");
                 
                    } else if (tipoPessoa.equals("J")){
                        PessoaJuridica pessoa = repoJuridica.obter(id);

                        if (pessoa == null) {
                            System.out.println("Pessoa não encontrada.");
                            break;
                        } 

                        System.out.println("Dados atuais: ");
                        pessoa.exibir();

                        System.out.println("Digite os novos dados");

                        nome = coletarNome(scanner);
                        email = coletarEmail(scanner);
                        String cnpj = coletarCnpj(scanner);

                        PessoaJuridica pessoaAlterada = new PessoaJuridica(id, nome, email, cnpj);

                        repoJuridica.alterar(pessoaAlterada);
                        System.out.println("Pessoa Jurídica alterada com sucesso.");
                    } else {
                        System.out.println("Tipo de pessoa inválido.");
                    }
                    break;

                case 3:
                    tipoPessoa = obterTipoPessoa(scanner);
                    id = coletarId(scanner);

                    if (tipoPessoa.equals("F")){
                        repoFisica.excluir(id);
                        System.out.println("Pessoa Física com ID " + id + " excluída com sucesso.");
                    } else if (tipoPessoa.equals("J")){
                        repoJuridica.excluir(id);
                        System.out.println("Pessoa Jurídica com ID " + id + " excluída com sucesso.");
                    } else {
                        System.out.println("Tipo de pessoa inválido.");
                    }
                    break;

                case 4:
                    tipoPessoa = obterTipoPessoa(scanner);
                    id = coletarId(scanner);

                    if (tipoPessoa.equals("F")){
                        PessoaFisica pessoa = repoFisica.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } else if (tipoPessoa.equals("J")){
                        PessoaJuridica pessoa = repoJuridica.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo de pessoa inválido.");
                    }
                    break;

                case 5:
                    tipoPessoa = obterTipoPessoa(scanner);

                    if(tipoPessoa.equals("F")){
                        for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else if(tipoPessoa.equals("J")){
                        for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else {
                        System.out.println("Tipo de pessoa inválido.");
                    }
                    break;

                case 6:
                    String prefixoPersistir = coletarPrefixo(scanner);

                    try {
                        repoFisica.persistir(prefixoPersistir + ".fisica.bin");
                        repoJuridica.persistir(prefixoPersistir + ".juridica.bin");
                        System.out.println("Dados persistidos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao persistir dados: " + e.getMessage());
                    }

                    break;

                case 7:
                    String prefixoRecuperar = coletarPrefixo(scanner);

                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static String obterTipoPessoa(Scanner scanner){
        String tipoPessoa;

        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        tipoPessoa = scanner.next().toUpperCase();
        scanner.nextLine();

        return tipoPessoa;
    }

    public static int coletarId(Scanner scanner){
        int id;
        
        System.out.println("Digite o ID da pessoa:");
        id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public static String coletarNome(Scanner scanner){
        String nome;
        System.out.println("Digite o nome da pessoa:");
        nome = scanner.nextLine();
        return nome;
    }

    public static String coletarEmail(Scanner scanner){
        String email;
        System.out.println("Digite o email da pessoa:");
        email = scanner.nextLine();
        return email;
    }

    public static String coletarCpf(Scanner scanner){
        String cpf;
        System.out.println("Digite o CPF da pessoa:");
        cpf = scanner.nextLine();
        return cpf;
    }

    public static int coletarIdade(Scanner scanner){
        int idade;
        System.out.println("Digite a idade da pessoa:");
        idade = scanner.nextInt();
        scanner.nextLine();
        return idade;
    }

    public static String coletarCnpj(Scanner scanner){
        String cnpj;
        System.out.println("Digite o CNPJ da pessoa:");
        cnpj = scanner.nextLine();
        return cnpj;
    }

    public static String coletarPrefixo(Scanner scanner){
        String prefixo;
        System.out.println("Digite o prefixo do arquivo:");
        prefixo = scanner.nextLine();
        return prefixo;
    }
}
