---
title: "Relatório de Atividade Prática - Criação do Cadastro em Modo Texto"
author: "Ana Siqueira"
date: "2026"
toc: true
---

# Introdução

Este relatório apresenta o desenvolvimento do segundo procedimento da prática de Programação Orientada a Objetos, voltado à implementação de um sistema de cadastro de pessoas em modo texto utilizando a linguagem Java.

Nesta etapa, foi desenvolvida uma aplicação capaz de realizar o gerenciamento de Pessoas Físicas e Pessoas Jurídicas, contemplando operações de inclusão, alteração, exclusão, consulta e exibição dos registros. Também foi implementado o mecanismo de persistência e recuperação dos dados por meio de arquivos binários.

O desenvolvimento do procedimento permitiu aplicar, de forma prática, conceitos de Programação Orientada a Objetos, como herança, encapsulamento, criação e utilização de objetos, além da separação das responsabilidades entre as entidades e os respectivos repositórios.

# Objetivos

## Objetivo Geral

Desenvolver, como parte do segundo procedimento da prática, um sistema de cadastro de pessoas em modo texto utilizando Java e conceitos de Programação Orientada a Objetos.

## Objetivos Específicos

- Implementar o cadastro de Pessoas Físicas e Pessoas Jurídicas;
- Aplicar conceitos de herança e encapsulamento na definição das entidades;
- Implementar os repositórios responsáveis pelo gerenciamento dos registros;
- Desenvolver as operações de inclusão, alteração, exclusão e consulta de pessoas;
- Criar um menu de interação com o usuário em modo texto;
- Implementar a persistência dos registros em arquivos binários;
- Implementar a recuperação dos dados previamente persistidos;
- Testar as funcionalidades desenvolvidas durante o procedimento.

# Desenvolvimento

## Implementação do sistema em modo texto

No segundo procedimento, foi desenvolvida a classe `Main`, responsável pela interação do usuário com o sistema por meio do terminal. As classes de entidade e os repositórios utilizados nesta etapa já haviam sido desenvolvidos no primeiro procedimento, sendo reutilizados para implementar as funcionalidades de gerenciamento dos cadastros.

A aplicação utiliza a classe `Scanner`, da biblioteca padrão do Java, para receber os dados informados pelo usuário. A partir dessas entradas, o programa identifica a operação solicitada e executa os métodos correspondentes dos repositórios de Pessoas Físicas e Pessoas Jurídicas.

### Menu de operações

Para facilitar a interação com o sistema, foi implementado um menu principal que apresenta ao usuário as operações disponíveis:

- Incluir Pessoa;
- Alterar Pessoa;
- Excluir Pessoa;
- Buscar pelo ID;
- Exibir todos os registros;
- Salvar dados;
- Recuperar dados;
- Finalizar o programa.

O menu é executado dentro de uma estrutura de repetição, permitindo que diferentes operações sejam realizadas consecutivamente até que o usuário escolha a opção de finalizar o programa.

![Menu principal do sistema](imagens/menu.png)

### Entrada e coleta dos dados

Para organizar a entrada de informações, foram criados métodos auxiliares responsáveis por coletar cada tipo de dado necessário para as operações. Entre eles estão os métodos para obtenção do tipo de pessoa, ID, nome, e-mail, CPF, idade e CNPJ.

Essa organização permite separar a responsabilidade de leitura dos dados da lógica de execução das operações. Por exemplo, o método `coletarNome()` utiliza o `Scanner` para solicitar o nome ao usuário e retorna o valor informado para ser utilizado posteriormente pela operação correspondente.

![Funções para coleta de dados](imagens/coleta.png)

### Integração com os repositórios

Após a coleta das informações, os dados são utilizados para criar ou localizar os objetos correspondentes e executar os métodos disponibilizados pelos repositórios.

A escolha entre Pessoa Física e Pessoa Jurídica é realizada pelo usuário por meio das opções `F` e `J`. Com base nessa escolha, o programa direciona a operação para o `PessoaFisicaRepo` ou para o `PessoaJuridicaRepo`.

Dessa forma, o `Main` funciona como uma camada de interação entre o usuário e as funcionalidades já implementadas nos repositórios.

## Operações de cadastro

Com o menu implementado, foram desenvolvidas as operações responsáveis pelo gerenciamento dos registros de Pessoas Físicas e Pessoas Jurídicas. Para cada operação, o usuário informa o tipo de pessoa e os dados necessários, e o programa utiliza o repositório correspondente para executar a ação.

### Inclusão de pessoas

A opção de inclusão permite cadastrar uma nova Pessoa Física ou Pessoa Jurídica. Inicialmente, o usuário informa o tipo de pessoa que deseja cadastrar e, em seguida, os dados comuns, como ID, nome e e-mail.

Para Pessoas Físicas, também são solicitados CPF e idade. Para Pessoas Jurídicas, é solicitado o CNPJ. Após a coleta das informações, o programa cria o objeto correspondente e utiliza o método `inserir()` do repositório adequado.

![Inclusão de uma Pessoa Física](imagens/inclusao-pessoa-fisica.png)

### Alteração de pessoas

A operação de alteração inicia-se com a escolha do tipo de pessoa e a identificação do registro por meio do ID. O programa utiliza o método `obter()` do repositório para localizar a pessoa cadastrada.

Quando o registro é encontrado, seus dados atuais são exibidos no terminal e o usuário pode informar os novos valores. Após a coleta das informações, é criado um novo objeto com os dados atualizados, que é encaminhado ao método `alterar()` do respectivo repositório.

Caso o ID informado não corresponda a nenhum registro, o sistema informa que a pessoa não foi encontrada e retorna ao menu principal.

![Alteração de uma pessoa](imagens/alteracao-pessoa.png)

### Exclusão e consulta de pessoas

A exclusão também utiliza o tipo de pessoa e o ID informado pelo usuário para determinar qual repositório deve ser utilizado. O método `excluir()` é responsável por remover o registro correspondente.

A consulta por ID, por sua vez, utiliza o método `obter()` para localizar o registro. Quando encontrado, o método `exibir()` é utilizado para apresentar os dados da pessoa no terminal.

Além da consulta individual, o sistema disponibiliza a opção de exibir todos os registros cadastrados. Para isso, o método `obterTodos()` retorna os registros armazenados no repositório selecionado, que são percorridos e exibidos no terminal.

![Exclusão de pessoa pelo ID](imagens/exclusao.png)

![Consulta de pessoa pelo ID](imagens/consulta-pessoa.png)

## Persistência e recuperação dos dados

Além das operações de gerenciamento dos cadastros, foi implementado o recurso de persistência dos dados. Essa funcionalidade permite salvar os registros armazenados nos repositórios em arquivos binários, possibilitando que as informações sejam recuperadas posteriormente.

Na opção de salvar os dados, o usuário informa um prefixo para os arquivos. A partir desse prefixo, são gerados arquivos distintos para os registros de Pessoas Físicas e Pessoas Jurídicas. Os métodos `persistir()` dos respectivos repositórios são responsáveis por realizar a gravação dos dados.

Na recuperação, o mesmo prefixo é utilizado para localizar os arquivos correspondentes. Os métodos `recuperar()` dos repositórios carregam novamente os registros para a aplicação.

![Persistência dos dados](imagens/persistencia.png)

![Recuperação dos dados](imagens/recuperacao.png)

# Análise e Conclusão

## O que são elementos estáticos e qual o motivo para o método main adotar esse modificador?

Elementos estáticos pertencem à classe em si e não a uma instância (objeto) dessa classe, podendo ser chamado diretamente por meio do nome da classe. O método main é declarado como static por ser o ponto de entrada da aplicação. Quando o programa é iniciado, a JVM precisa executar o main sem antes criar uma instância.

## Para que serve a classe Scanner?

A classe Scanner é utilizada para ler dados de entrada fornecidos pelo usuário durante a execução do programa.

## Como o uso de classes de repositório impactou na organização do código?

Essa divisão tornou o código mais organizado e facilitou a reutilização das funcionalidades já desenvolvidas no primeiro procedimento, pois as responsabilidades ficaram separadas dentro da aplicação. Dessa forma a Main não precisa implementar a lógica de armazenamento, consulta ou exclusão de registros e fica responsável apenas pela interação com o usuário, leitura de dados e escolha da operação a ser executada.

# Resultados

Ao final do segundo procedimento, foi obtida uma aplicação funcional em modo texto para o gerenciamento de Pessoas Físicas e Pessoas Jurídicas.

A aplicação passou a disponibilizar, por meio de um menu interativo, as operações de inclusão, alteração, exclusão, consulta por ID e exibição dos registros. A utilização da classe `Scanner` permitiu que os dados fossem informados diretamente pelo usuário durante a execução do programa, sendo posteriormente encaminhados aos métodos dos repositórios correspondentes.

Também foi implementada a persistência dos registros em arquivos binários e a recuperação dos dados previamente armazenados. Dessa forma, os registros não ficam restritos ao período de execução da aplicação, podendo ser salvos e carregados posteriormente.

Os testes realizados durante o desenvolvimento demonstraram o funcionamento das operações implementadas e a integração entre a interface em modo texto e os repositórios desenvolvidos no procedimento anterior.

![Código completo da aplicação](imagens/codigo.png)

![Inserindo uma Pessoa Física no sistema](imagens/teste1.png)

![Buscando uma Pessoa Física no sistema](imagens/teste2.png)

![Alterando uma Pessoa Física no sistema](imagens/teste3.png)

![Exibindo todas as Pessoas Físicas](imagens/teste4.png)

![Incluindo uma Pessoa Jurídica no sistema](imagens/teste5.png)

![Exibindo toas as Pessoas Jurídicas](imagens/teste6.png)

![Salvando dados](imagens/teste8.png)

![Recuperando dados](imagens/teste9.png)

![Excluindo uma pessoa do sistema](imagens/teste10.png)










