package model;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public ArrayList<PessoaJuridica> obterTodos () {
        return pessoasJuridicas;
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public void excluir(int id) {
        pessoasJuridicas.removeIf(pessoaJuridica -> pessoaJuridica.getId() == id);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        PessoaJuridica pessoaExistente = obter(pessoaJuridica.getId());

        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoaJuridica.getNome());
            pessoaExistente.setEmail(pessoaJuridica.getEmail());
            pessoaExistente.setCnpj(pessoaJuridica.getCnpj());
        }
    }

    public void persistir(String nomeArquivo) throws IOException {
        try(
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objeto = new ObjectOutputStream(arquivo)
        ) {
            objeto.writeObject(pessoasJuridicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try(
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream objeto = new ObjectInputStream(arquivo)
        ) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) objeto.readObject();
        }
    }
}
