# Cadastro POO — Java

Sistema de cadastro de pessoas desenvolvido em Java como parte das práticas da disciplina **DGT2821 — Desenvolvimento Full Stack**, utilizando conceitos de **Programação Orientada a Objetos**.

O projeto consiste em uma aplicação executada em modo texto, permitindo o gerenciamento de Pessoas Físicas e Pessoas Jurídicas por meio de um menu interativo.

---

## Sobre o projeto

O sistema foi desenvolvido em duas etapas.

No primeiro procedimento foram implementadas as entidades do domínio e as classes de repositório responsáveis pelo gerenciamento dos registros.

No segundo procedimento foi desenvolvida a aplicação em modo texto, centralizada na classe `Main`, responsável pela interação com o usuário por meio do terminal e pela utilização dos métodos disponibilizados pelos repositórios.

A aplicação permite realizar operações de:

- Inclusão de pessoas;
- Alteração de dados;
- Exclusão de registros;
- Consulta por ID;
- Exibição de todos os registros;
- Persistência dos dados em arquivos binários;
- Recuperação dos dados persistidos.

---

## Funcionalidades

### Inclusão de pessoas

Permite cadastrar dois tipos de pessoa:

#### Pessoa Física

- ID;
- Nome;
- E-mail;
- CPF;
- Idade.

#### Pessoa Jurídica

- ID;
- Nome;
- E-mail;
- CNPJ.

---

### Alteração de pessoas

Permite localizar uma pessoa pelo ID e substituir seus dados.

Antes da alteração, os dados atuais do registro são exibidos para o usuário.

---

### Exclusão de pessoas

Permite excluir um registro informando:

1. Tipo de pessoa;
2. ID do registro.

---

### Busca por ID

Permite consultar individualmente uma Pessoa Física ou Pessoa Jurídica utilizando seu ID.

Caso o registro não seja encontrado, o sistema informa ao usuário.

---

### Exibição de todos os registros

Permite listar todos os registros armazenados no repositório correspondente ao tipo de pessoa selecionado.

---

### Persistência dos dados

Os registros podem ser salvos em arquivos binários utilizando os métodos de persistência implementados nos repositórios.

O usuário informa um prefixo para os arquivos, e o sistema gera arquivos separados para cada tipo de pessoa:

```text
<prefixo>.fisica.bin
<prefixo>.juridica.bin
