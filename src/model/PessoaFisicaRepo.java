package model;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public ArrayList<PessoaFisica> obterTodos () {
        return pessoasFisicas;
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public void excluir(int id) {
        pessoasFisicas.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
    }

    public void alterar(PessoaFisica pessoaFisica) {
        PessoaFisica pessoaExistente = obter(pessoaFisica.getId());

        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoaFisica.getNome());
            pessoaExistente.setEmail(pessoaFisica.getEmail());
            pessoaExistente.setCpf(pessoaFisica.getCpf());
            pessoaExistente.setIdade(pessoaFisica.getIdade());
        }
    }

    public void persistir(String nomeArquivo) throws IOException {
        try(
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objeto = new ObjectOutputStream(arquivo)
        ) {
            objeto.writeObject(pessoasFisicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try(
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream objeto = new ObjectInputStream(arquivo)
        ) {
            pessoasFisicas = (ArrayList<PessoaFisica>) objeto.readObject();
        }
    }
}
