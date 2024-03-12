# 🤓👍🏾Storage Benezinho 

CP I - **Java Advanced** aplicado em 12/03/2024.


| ![](documentacao/fiap.jpg)               | **Java Advanced** |
|------------------------------------------|-------------------|
| **ALUNO:** Gabriel Eringer de Oliveira    | **TURMA:** 2TDSPG |
| **PROFESSOR:** Benefrancis do Nascimento | 12/03/2024        |
| **CP I**                                 | ****              |

# Sumário


[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como Entregar ](#_Entrega)

[Correção da Prova ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso


A Holding Benezinho está interessada em investir na abertura de Depósitos no Brasil em 2024. Este investimento pode oferecer diversas vantagens para o empresário, especialmente considerando o contexto econômico e social do país.  
 

 

Com o objetivo de fazer este negócio dar certo, idealizamos o desenvolvimento de um Sistema de Gestão de produtos estocados a serem comercializados pelas lojas do Conglomerado de empresas da rede.

Criaremos, nesta aula, um Produto Mínimo Viável (PMV) de uma API Rest para este sistema.



Nossa equipe de analistas desenvolveu o Diagrama de Classes abaixo, e a sua missão aqui é realizar o Mapeamento Objeto Relacional das classes de Entidade. Usaremos a JPA e o Hibernate como ferramentas de Mapeamento Objeto Relacional.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Repositorios :

   1. DepositoRepository
   2. EnderecoRepository
   3. ItemEstocadoRepository
   4. ProdutoRepository

5. A criação dos Seguintes Resources:

   1. **DepositoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/deposito" - **GET**, **POST**
      2. "logalhost/deposito/{id}" - **GET**
    

   2. **EnderecoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/endereco" - **GET**, **POST**
      2. "logalhost/endereco/{id}" - **GET**
      
   3. **ProdutoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/produto" - **GET**, **POST**
      2. "logalhost/produto/{id}" - **GET**
      
      
   4. **EntradaResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/entrada/deposito/{idDeposito}/produto/{idProduto}" - **POST** 
         No corpo da requisição deverá vir a quantidade de itens da entrada.
         O retorno deverá ser a Lista de Produtos estocados nesta entrada.

   5. **SaidaResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/saida/deposito/{idDeposito}/produto/{idProduto}" - **POST**
         No corpo da requisição deverá vir a quantidade de itens que sairão do deposito.
         O retorno deverá ser a Lista de Produtos que saem nesta requisição.

<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?


**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/spring-pg-deposito](https://github.com/Benefrancis/spring-pg-deposito)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma da dupla que fará esta atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

1. **(0,5 Ponto)** acessar o arquivo **application.yml** e incluir as configurações para **persistencia** para que seja possível conectar-se ao banco de dados Oracle da FIAP com o seu usuário e senha (manter o seu usuário e senha ativo é sua responsabilidade). Não utilize o usuário e senha de outro aluno. Caso tenha problema para autenticar, comunique o professor.

## No pacote entity, criar as seguintes classes

2. **(1,5 Pontos)** Criar a classe **ItemEstocado** e adicionar corretamente as anotações JPA.

3. **(0,5 Ponto)** Criar a classe **Produto** e adicionar corretamente as anotações JPA.

4. **(0,5 Ponto)** Criar a classe **Endereco** e adicionar corretamente as anotações JPA.

5. **(1 Ponto)** Criar a classe **Deposito** e adicionar corretamente as anotações JPA.


## No pacote resources criar as seguintes classes

6. **(6 Ponto)**  A perfeita criação dos Seguintes Resources no pacote resources:

   1. **DepositoResource** com as seguintes ROTAS e VERBOS:
   1. (0,5 Ponto) "localhost/deposito" - **GET**;
   2. (1 Ponto)   "localhost/deposito" - **POST**;
   3. (0,5 Ponto) "logalhost/deposito/{id}" - **GET**


2. **EnderecoResource** com as seguintes ROTAS e VERBOS:
   1. (0,5 Ponto) "localhost/endereco" - **GET**, 
   2. (1 Ponto)   "localhost/endereco" - **POST**,
   3. (0,5 Ponto) "logalhost/endereco/{id}" - **GET**

3. **ProdutoResource** com as seguintes ROTAS e VERBOS:
   1. (0,5 Ponto) "localhost/produto" - **GET**,
   2. (1 Ponto)   "localhost/produto" - **POST**
   3. (0,5 Ponto) "logalhost/produto/{id}" - **GET**


4. (1 Ponto **EXTRA DESAFIO**) **EntradaResource** com as seguintes ROTAS e VERBOS:
   1. "localhost/entrada/deposito/{idDeposito}/produto/{idProduto}" - **POST**
      No corpo da requisição deverá vir a quantidade de itens da entrada.
      O retorno deverá ser a Lista de Produtos estocados nesta entrada.

5. (1 Ponto **EXTRA DESAFIO**) **SaidaResource** com as seguintes ROTAS e VERBOS:
   1. "localhost/saida/deposito/{idDeposito}/produto/{idProduto}" - **POST**
      No corpo da requisição deverá vir a quantidade de itens que sairão do deposito.
      O retorno deverá ser a Lista de Produtos que saem nesta requisição.


## No pacote repository criar as seguintes interfaces

7. **(1 Ponto)** A criação dos Seguintes Repositories :

   1. **(0,25 Ponto)** DepositoRepository
   2. **(0,25 Ponto)** EnderecoRepository
   3. **(0,25 Ponto)** ProdutoRepository
   4. **(0,25 Ponto)** ItemEstocadoRepository


<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes

![diagrama-de-classes-deposito.png](documentacao%2Fdiagrama-de-classes-deposito.png)

<a id="_Entrega"></a>

# Como Entregar

**A entrega deverá ser feita pelo Teams**, porém não se esqueça de fazer o **commit** e **push** do projeto no github.


<a id="_Correcao"></a>

# Correção da Prova

Nos próximos dias, a correção da prova será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/spring-pg-deposito && cd spring-pg-deposito && git checkout correcao
```


A avaliação é em dupla.


Boa avaliação.
