## Documentação de Projeto de Software Versão 6.0

## Área de negócio do Sistema
O presente projeto é voltado para a área educacional, em específico para as bibliotecas. O intuito é proporcionar o gerenciamento do empréstimo de livros de forma similar ao software PERGAMUM já existente nas universidades públicas do estado.

## Principais funcionalidades
O sistema de controle de biblioteca tem como funcionalidades: cadastrar, consultar, editar e excluir: leitores, livros, autores, editoras, funcionários, extrair relatórios, determinar prazo de devolução e aplicar multa em caso de descumprimento da data limite.

## Método de trabalho
Inicialmente foi realizado o levantamento de requisitos do sistema. Em seguida, deu-se prosseguimento à criação de um diagrama entidade relacionamento (modelo ER) visando um melhor entendimento acerca do funcionamento do banco de dados. Para tal utilizou-se a ferramenta de modelagem em banco de dados BrModelo. O projeto, Sistema de Biblioteca, foi desenvolvido com a linguagem de programação Java, cuja interação deu-se com SGBD MySQL. Este foi manipulado através do software HeidiSQL.

## Modelo de Visão
* Apenas o login do tipo administrador poderá cadastrar funcionários, leitores, livros, autores, editoras.
* Os leitores só poderão ser pessoas físicas e, no cadastro, será solicitado: Nome, data de nascimento, telefone, CPF, E-mail e endereço. Ao final, se atribuirá um ID que será o Primary Key.
* Para cadastrar um livro, será necessário primeiramente cadastra o autor e editora do mesmo para poder realizar o cadastro do livro, que será solicitado: Título, autor, editora, ano da edição e quantidade. Ao final, se atribuirá um ID que será o Primary Key.
*  O empréstimo será realizado apenas pelo funcionário.
*  No empréstimo, será requisitado o nome do leitor previamente cadastrado. Este escolherá um ou mais livros, será registrado a data do empréstimo e a data de devolução e será atribuído um ID que será o Primary Key.
* O prazo para devolução é de uma semana. Ao leitor, não será permitido a entrega de apenas um dos livros, caso tenha pego mais de um. Devolve-se tudo de uma só vez, ou renova. A opção de renovação pode ser feita por duas vezes. A cada dia de atraso, será cobrado um valor de R$1,00.
O sistema possibilitará a extração de relatórios de várias formas:
* Relação dos leitores;
* Relação dos livros;
* Quantidade de livros emprestados por leitor;
* Quantidade de leitores que fizeram empréstimos de um determinado livro.

## Modelo Conceitual

![modelo conceitual](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca-V4/blob/master/imagens/Modelo%20Conceitual%203.0%20-%20Sistema%20de%20Biblioteca.jpg)

## Modelo Lógico
```
login (id_login, nome, senha, tipo)
	id_login – Primary Key
  
autor (id_autor, nome, id_login)
	id-autor – Primary Key
         id_login referencia login - Foreign Key
	
editora (id_editora, nome, id_login)
	id_editora - Primary Key
	id_login referencia login - Foreign Key

livro (id_livro, titulo, volume, ano, id_login, id_editora, id_autor)
	id_livro - Primary Key
	id_login referenca login - Foreign Key
         id_editora referencia edtora - Foreign Key
         Id_autor referencia autor - Foreign Key

leitor (id_leitor, nome, cpf, data_nascimento, telefone, email, rua, número, bairro, cidade, cep, uf, id_login)
id_leitor – Primary Key
id_login referencia Login                                                     

emprestimo (id_emprestimo, data_emprestimo, data_devolucao, id_funcionario, id_leitor)
id_emprestimo – Primary Key
id_funcionario referencia funcionário - Foreign Key
id_leitor referencia leitor - Foreign Key

funcionario (id_funcionario, nome, senha, id_login)
	id_funcionario – Primary Key
	id_login referencia login - Foreign Key

emprestimo_livro (id_emprestimo, id_livro)
              id_emprestimo referencia empréstimo – Primary Key
              id_livro referencia livro - Primary Key
```
## Dicionário de Dados

##### Tabela Login

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Nome       |Varchar, 100  |     Sim     |          |Nome do usuário que está logando                        |
|    Senha      |Varchar,50    |     Sim     |          |Senha do usuário que está logando                       |
|    Tipo       |Varchar       |     Sim     |          |Contém os dados se a conta logada é Admin ou Funcionário|

##### Tabela Autor

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Nome       |Varchar, 100  |     Sim     |          |Nome do autor                                           |
|    id_login   |integer       |     Sim     |          |Referência à tabela login                               |

##### Tabela Livro

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Título      |Varchar, 100  |     Sim     |         |Nome do livro                                           |
|    Volume      |Varchar,50    |     Sim     |          |Senha do usuário que está logando                       |
|    Ano      |Varchar          |     Sim     |          |Contém os dados se a conta logada é Admin ou Funcionário|
|Id_login     |Integer|          Sim          |FK        |Referencia à tabela login|
|Id_editora   |Integer           |Sim         |          |           Referência à tabela editora|
|Id_autor   |Integer           |Sim         |          |           Referência à tabela autor|

##### Tabela Usuário

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|    Nome       |String,100    |     Sim     |          |Nome do usuário                                         |
|    senha       |String,50    |     Sim     |          |Senha do usuário                                        |
|    id_login   |Integer       |     Sim     |          |Referência à tabela login                                |

##### Tabela Empréstimo

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
| Data_emprestimo |Date        |     Sim     |          |Data da locação do(s) Livro(s)                          |
| Data_devolucao  |Date        |     Sim     |          |Data da devolução do(s) Livro(s)                        |
|Id_funcionario   | Integer    |     Sim     |       FK | Referência à tabela funcionário                        |
|Id_leitor        | Integer    |     Sim     |       FK | Referência à tabela leitor                             |

##### Tabela Leitor

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|     Nome      |Varchar,100   |     Sim     |          |Nome do leitor                                          |
|     cpf       |Char,11       |     Sim     |          |CPF do leitor                                           |
|     Data_nascimeto|Date      |     Sim     |          |Data de nascimento do leitor                            |
|     Telefone  |Char,13       |     Sim     |          |Telefone do Leitor                                      |
|     Email     |Varchar,100   |     Sim     |          |E-mail do Leitor                                        |
|     Rua       |Varchar,100   |     Sim     |          |Rua do Leitor                                           |
|     Numero    |Varchar,10    |     Sim     |          |Número da residência do leitor                          |
|     Bairro    |Varchar,50    |     Sim     |          |Bairro onde reside o leitor                             |
|     Cidade    |Varchar,50    |     Sim     |          |Cidade onde reside o leitor                             |
|     Cep       |Char,8        |     Sim     |          |CEP da rua do Leitor                                    |
|     Uf        |Char,2        |     Sim     |          |Estado onde reside o leitor                             |
|     Cep       |Char,8        |     Sim     |          |CEP da rua do Leitor                                    |
|    id_login   |Integer       |     Sim     |          |Referência à tabela login                                |

##### Tabela Empréstimo_livro

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|  Id_editor    |Integer       |     Sim     | PK       |Referencia à tabela empréstimo, chave primária composta |
|    id_login   |Integer       |     Sim     |          |Referência à tabela login                               |

##### Tabela Editora

|Identificador  |Tamanho       |Obrigatório  |Chave     |Descrição                                               |
|:-------------:|:------------:|:-----------:|:--------:|:-------------------------------------------------------|
|     ID        |Integer       |     Sim     | PK       |Chave Primária da tabela, Auto_Increment                |
|     Nome      |Varchar,100   |     Sim     |          |Nome da Editora                                         |
|    id_login   |Integer       |     Sim     |          |Referência à tabela login                               |

## Modelo Físico

### Scripts DDL do banco de dados

##### Tabela Login
```
CREATE TABLE `login` (
`id_login` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`senha` VARCHAR(50) NOT NULL,
`tipo` VARCHAR(11) NOT NULL,
PRIMARY KEY (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```
##### Tabela Autor

```
CREATE TABLE `autor` (
`id_autor` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`id_login` INT NOT NULL,
PRIMARY KEY (`id_autor`),
INDEX `FK_autor_login` (`id_login`),
CONSTRAINT `FK_autor_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```
##### Tabea Editora

```
CREATE TABLE `editora` (
`id_editora` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`id_login` INT NOT NULL,
PRIMARY KEY (`id_editora`),
INDEX `FK_editora_login` (`id_login`),
CONSTRAINT `FK_editora_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```

##### Tabela Livro

```
CREATE TABLE `livro` (
`id_livro` INT NOT NULL AUTO_INCREMENT,
`titulo` VARCHAR(100) NOT NULL,
`volume` INT NOT NULL,
`ano` CHAR(4) NOT NULL,
`id_login` INT NOT NULL,
`id_editora` INT NOT NULL,
`id_autor` INT NOT NULL,
PRIMARY KEY (`id_livro`),
INDEX `FK_livro_login` (`id_login`),
INDEX `FK_livro_editora` (`id_editora`),
INDEX `FK_livro_autor` (`id_autor`),
CONSTRAINT `FK_livro_autor` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
CONSTRAINT `FK_livro_editora` FOREIGN KEY (`id_editora`) REFERENCES `editora` (`id_editora`),
CONSTRAINT `FK_livro_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```

##### Tabela Funcionário

```
CREATE TABLE `funcionario` (
`id_funcionario` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`senha` CHAR(50) NOT NULL,
`id_login` INT NOT NULL,
PRIMARY KEY (`id_funcionario`),
INDEX `FK_funcionario_login` (`id_login`),
CONSTRAINT `FK_funcionario_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=21;
```

##### Tabela Leitor

```
CREATE TABLE `leitor` (
`id_leitor` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`cpf` CHAR(11) NOT NULL,
`data_nascimento` DATE NOT NULL,
`telefone` CHAR(13) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`rua` VARCHAR(100) NOT NULL,
`numero` VARCHAR(10) NOT NULL,
`bairro` VARCHAR(50) NOT NULL,
`cidade` VARCHAR(50) NOT NULL,
`cep` CHAR(8) NOT NULL,
`uf` CHAR(2) NOT NULL,
`id_login` INT NOT NULL,
PRIMARY KEY (`id_leitor`),
INDEX `FK_leitor_login` (`id_login`),
CONSTRAINT `FK_leitor_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```

##### Tabela Epréstimo

```
CREATE TABLE `emprestimo` (
`id_emprestimo` INT NOT NULL AUTO_INCREMENT,
`data_emprestimo` DATE NOT NULL,
`data_devolucao` DATE NOT NULL,
`id_funcionario` INT NOT NULL,
`id_leitor` INT NOT NULL,
PRIMARY KEY (`id_emprestimo`),
INDEX `id_funcionario` (`id_funcionario`),
INDEX `id_leitor` (`id_leitor`),
CONSTRAINT `FK_emprestimo_funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`),
CONSTRAINT `FK_emprestimo_leitor` FOREIGN KEY (`id_leitor`) REFERENCES `leitor` (`id_leitor`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```

##### Tabela Empréstimo_Livro

```
CREATE TABLE `emprestimo_livro` (
`id_emprestimo` INT NOT NULL AUTO_INCREMENT,
`id_livro` INT NOT NULL,
INDEX `FK_emprestimo_livro_emprestimo` (`id_emprestimo`),
INDEX `FK_emprestimo_livro_livro` (`id_livro`),
CONSTRAINT `FK_emprestimo_livro_emprestimo` FOREIGN KEY (`id_emprestimo`) REFERENCES `emprestimo` (`id_emprestimo`),
12
CONSTRAINT `FK_emprestimo_livro_livro` FOREIGN KEY (`id_livro`) REFERENCES `livro` (`id_livro`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
```

## Comandos Insert

```
insert into login (nome, senha, tipo) values ('Otávio','tico3339','Funcionario');
insert into login (nome, senha, tipo) values ('Ana Luiza','admin789','Admin');
insert into login (nome, senha, tipo) values ('Dory','abc321','Funcionario');
insert into login (nome, senha, tipo) values ('Rosi','dory123','Funcionario');
insert into login (nome, senha, tipo) values ('Dell','123123','Funcionario');
insert into login (nome, senha, tipo) values ('Jefferson','del4321','Funcionario');

insert into autor (nome, id_login) values ('Susan Cain',2);
insert into autor (nome, id_login) values ('Roger S. Pressman',2);
insert into autor (nome, id_login) values ('Viktor Mayer-Schonberger',2);
insert into autor (nome, id_login) values ('Paul Barry',2);
insert into autor (nome, id_login) values ('Richard Hunter',2);

insert into editora (nome, id_login) values ('Sextante',2);
insert into editora (nome, id_login) values ('AMGH',2);
insert into editora (nome, id_login) values ('Elsevier',2);
insert into editora (nome, id_login) values ('Alta Books',2);
insert into editora (nome, id_login) values ('MBOOKS',2);

insert into funcionario (nome, senha, id_login) values ('Jefferson','acb123',2);
insert into funcionario (nome, senha, id_login) values ('Ana','123abc',2);
insert into funcionario (nome, senha, id_login) values ('Dory','dory123',2);
insert into funcionario (nome, senha, id_login) values ('Rose','rosi4321',2);
insert into funcionario (nome, senha, id_login) values ('Dell','Dell789',2);

insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) VALUES ('Miguel','47957368042',"1970-11-06",'(71)999910300','miguel@gmail.com','Avenida Rosa','402','Alto das Pombas','Recife','40226175','BA',2);
insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) VALUES ('Arthur','68166208016',"1959-02-08",'(92)999983558','Arthur@gmail.com','Rua Independência','690','Alvorada','Olinda','69043020','AM',2);
insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) VALUES ('Davi','96790166092',"1961-10-08",'(41)999917759','Davi@gmail.com','Rua Hércules Accorsi','860','Cafezal','Recife','86045270','PR',2);
insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) VALUES ('Bernardo','50224973010',"1965-09-20",'(62)999368617','Bernardo@gmail.com','Rua 86A','740','Setor Sul','Cabo','74083340','GO',2);
insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) VALUES('Murilo','77913644095',"1966-10-29",'(21)999366299','Murilo@gmail.com','Rua Projetada A','230','Guaratiba','Camaragibe','23031195','RJ',2);

insert into livro (titulo, volume, ano, id_login, id_editora, id_autor) values ('Redes de Computadores',2,'2011',2,1,5);
insert into livro (titulo, volume, ano, id_login, id_editora, id_autor) values ('Criptografia Para Iniciantes',1,'2012',2,2,4);
insert into livro (titulo, volume, ano, id_login, id_editora, id_autor) values ('Use a Cabeça! Python',1,'2018',2,3,3);
insert into livro (titulo, volume, ano, id_login, id_editora, id_autor) values ('Use a Cabeça!: Java ',1,'2007',2,4,3);
insert into livro (titulo, volume, ano, id_login, id_editora, id_autor) values ('Java Para Leigos',1,'2013',2,5,1);

insert into emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_leitor) VALUES ("2019-08-01","2019-08-08",25,5);
insert into emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_leitor) VALUES ("2019-08-03","2019-08-10",25,4);
insert into emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_leitor) VALUES ("2019-08-12","2019-08-19",21,3);
insert into emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_leitor) VALUES ("2020-04-01","2020-04-08",22,2);
insert into emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_leitor) VALUES ("2020-04-02","2020-04-09",24,1);

insert into emprestimo_livro (id_emprestimo, id_livro) values (1,5);
insert into emprestimo_livro (id_emprestimo, id_livro) values (2,4);
insert into emprestimo_livro (id_emprestimo, id_livro) values (3,3);
insert into emprestimo_livro (id_emprestimo, id_livro) values (4,1);
insert into emprestimo_livro (id_emprestimo, id_livro) values (5,2);
```

### Relatórios do Banco de dados

##### 1 - Listar todos os dados dos livros cadastrados, ordenando pelo seu título.

```
SELECT * FROM livro
ORDER BY titulo
```

##### 2 - Listar o funcionário de código 25 e o nome do administrador que o cadastrou

```
SELECT funcionario.id_funcionario, funcionario.nome AS Nome_Funcionario,login.nome AS Nome_admin, login.tipo
FROM funcionario, login
WHERE login.tipo = 'admin' AND funcionario.id_funcionario = 25
```

##### 3- Informar a quantidade de empréstimos feitos por nome de funcionários, realizados no mês de agosto de 2019.

```
SELECT f.nome AS Nome_Funcionario, COUNT(*) Quant_Emprestimo
FROM emprestimo e, funcionario f
WHERE e.id_funcionario = f.id_funcionario
AND e.data_emprestimo BETWEEN '2019-08-01' AND '2019-08-31'
GROUP BY f.nome
```

##### 4 - Listar as quantidades de livros por autor (nome).

```
SELECT nome AS Nome_autor, COUNT(*) Quant_Livro
FROM autor, livro
WHERE livro.id_autor = autor.id_autor
GROUP BY autor.nome
```

##### 5 - Listar os nomes das editoras em ordem crescente.

```
SELECT nome as Nome_editora_Ordem_Crescente FROM editora
ORDER BY nome
```

## Análise e Desing.

##### Diagrama de Classes

###### Ferramenta utilizada: StarUML

![UML](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/uml.png)


## Arquitetura do Software

### Padrão do Projeto.

O MVC (Model-View-Controller) consiste em um padrão de arquitetura de software que realiza a separação da aplicação em três camadas distintas para melhor organização do projeto facilitando futuras manutenções e reaproveitamento de códigos. As camadas são:

* **Model:** camada de manipulação dos dados, parte lógica da aplicação e é a ponte entre as camadas view e controller.
* **View:** camada de interação com o usuário, o *view* pode ser qualquer saída de representação dos dados, como uma tabela ou um diagrama. É onde os dados solicitados do *Model* são exibidos.
* **Controller:** Faz a medição da entrada e saída, comandando a visão e o modelo para serem alterados de forma apropriada conforme o usuário solicitou.

A camada View contém as seguntes telas:

* Login
* Tela Principal
* Inclusão de Leitor
* Alteração de Leitor
* Consulta de Leitor
* Exclusão de Leitor
* Inclusão de Livro
* Alteração de Livro
* Consulta de Livro
* Exclusão de Livro
* Inclusão de Autor
* Alteração de Autor
* Consulta de Autor
* Exclusão de Autor
* Inclusão de Editora
* Alteração de Editora
* Consulta de Editora
* Exclusão de Editora
* Cadastrar Usuário
* Excluir Usuário
* Fazer Empréstimo
* Consultar Empréstimo
* Excluir Empréstimo
* Fazer Devolução
* Consultar Devolução

## Protótipo

### Telas e Classes da camada View


#### Login

![Tela de Login](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca-V4/blob/master/imagens/login.png)

A tela é a de Login do sistema, cuja a função é autenticar o usuário. Uma vez autenticado, ele tem permissão para acessar o sistema.

#### Principal

![Tela Principal](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/tela%20pincipal%20-%20tela%202.png)

A tela principal é a que tem todas as funcionalidades do sistema através da barra superior do Menu.

#### Cadastro de Leitor

![Inserir Leitor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/cadastro%20leitor%20-%20tela%203.png)

Responsável por manter um cadastro de pessoa física, possibilitando através do cadastro identificar o leitor no momento do empréstimo.

#### Editar Leitor

![Editar Leitor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/editar%20leitor.png)

Responsável por editar um cadastro de pessoa física, possibilitando, através da edição, a correção de alguns erros nos dados cadastrados. Para realizar a alteração é necessário, antes, realizar a pesquisa do livro. Ao clicar na Lupa, o usuário é direcionado para outra tela de pesquisa. Nela, ao selecionar o leitor e clicar em OK, volta para a tela anterior com os dados inseridos, para que seja realizada a alteração.

#### Consultar Leitor

![Consultar Leitor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20leitor.png)

Responsável por consultar um cadastro de pessoa física, possibilitando, através da consulta, verificar algum erro de cadastro e realizar a correção na tela de alteração de cadastro. Para realizar a alteração é necessário, antes, realizar a pesquisa do Leitor. Ao clicar na Lupa, o usuário é direcionado para outra tela de pesquisa. Nela, ao selecionar o leitor e clicar em OK, volta para a tela anterior com os dados inseridos, para que seja realizada a alteração.

#### Excluir Leitor

![Excluir Leitor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20letitor.png)

Responsável por excluir o cadastro de um leitor.

#### Incluir Livro

![Incluir Livro](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/incluir%20livro.png)

Responsável pelo cadastro dos livros a serem utilizados no empréstimo solicitado pelo leitor.

#### Alterar Livro

![Alterar Livro](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/altera%C3%A7%C3%A3o%20de%20livro.png)

Responsável pela alteração dos dados dos livros cadastrados a serem utilizados no empréstimo solicitado pelo leitor.
Para realizar a alteração é necessário, antes, realizar a pesquisa do livro. Ao clicar na Lupa, o usuário é direcionado para outra tela de pesquisa. Nela, ao selecionar o livro e clicar em OK, volta para a tela anterior com os dados inseridos, para que seja realizada a alteração.

#### Consultar Livro

![Consultar Livro](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20livrp.png)

Responsável por realizar consulta de livros cadastrados no banco de dados.

#### Excluir Livro

![Excluir Livro](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20livro.png)

Responsável por realizar a exclusão dos livros cadastrados no banco de dados.

#### Incluir Autor

![Incluir Autor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/incluir%20autor.png)

Responsável pelo cadastro dos autores no banco de dados, no qual serão selecionados quando houver uma inclusão de livro.

#### Alterar Autor

![Alterar Autor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/altera%C3%A7%C3%A3o%20de%20autor.png)

Responsável pela alteração dos dados dos autores cadastrados que serão utilizados quando houver uma inclusão de livro.

Para realizar a alteração, é necessário, antes, realizar a pesquisa do autor. Ao clicar na lupa, o usuário é direcionado para outra tela de pesquisa. Após selecionar o autor e clicar em OK, volta para a tela anterior com os dados inseridos para realizar a alteração.

#### Consultar Autor

![Consultar Autor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20autor.png)

Responsável por realizar consulta de autores cadastrados no banco de dados.

#### Excluir Autor

![Excluir autor](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20autor.png)

Responsável por realizar a exclusão dos autores cadastrados no banco de dados.

#### Cadastrar Editora

![Cadastrar Editora](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/cadastrar%20editora.png)

Responsável pelo cadastro da editora no banco de dados, no qual serão selecionados quando houver uma inclusão de livro.

#### Alterar Editora

![Alterar Editora](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/editar%20editora.png)

Responsável pela alteração dos dados das editoras cadastradas que serão utilizadas quando houver uma inclusão de livro.

Para realizar a alteração, é necessário, antes, realizar a pesquisa da editora. Ao clicar na lupa, o usuário é direcionado para outra tela de pesquisa. Após selecionar a editora e clicar em OK, volta para a tela anterior com os dados inseridos para realizar a alteração.

#### Consultar Editora

![Consultar Editora](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20editora.png)

Responsável por realizar consulta de autor cadastrado no banco de dados.

#### Excluir Editora

![Excluir Editora](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20editora.png)

Responsável por realizar a exclusão da editora que está cadastrada no banco de dados.

#### Cadastrar Usuário

![Cadastrar Usuário](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/cadastro%20usuario.png)

Responsável por realizar o cadastro de usuários que poderão ter acesso ao sistema. Estes podem ser do tipo Adm ou funcionário.

#### Excluir Usuário

![Excluir Usuário](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20usuario.png)

Responsável por realizar a exclusão dos usuários (Adm ou funcionário) que poderão ter acesso ao sistema.

#### Empréstimo

![Empréstimo](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/emprestimo.png)

Responsável por realizar o empréstimo dos livros previamente cadastrados no banco de dados do sistema.

#### Consultar Emréstimo

![Consultar Emréstimo](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20emprestimo.png)

Responsável por realizar consulta de empréstimos cadastrados no banco de dados do sistema.

#### Excluir Empréstimo

![Excluir Empréstimo](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/excluir%20emprestimo.png)

Responsável por realizar a exclusão dos empréstimos cadastrados no banco de dados.

#### Devolução

![Devolução](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/devolucao.png)

Responsável por realizar a devolução do livro emprestado ao leitor anteriormente.

#### Consultar Devolução

![Consultar Devolução](https://github.com/1989jeffesonqueiroz/Sistema-de-Biblioteca/blob/master/imagens/consultar%20devolucao.png)

Responsável por realizar consultas de devoluções cadastradas no banco de dados.

### Classes da camada Controller

#### AutorDAO

```
package controller;

//import com.sun.jndi.ldap.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Autor;

public class AutorDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public AutorDAO(){
    
       //ABRIR CONEXÃO COM O BANCO DE DADOS
       this.con = ConexaoBD.Conectar();
   }
    
    public int inserir(Autor a){
        try {
            String sql = "insert into autor (nome, id_login) values (?,2)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// REFERENCIA A CONEXÃO
            
            cmd.setString(1, a.getNome());
            //cmd.setInt(2, a.getId_login());
            
            if(cmd.executeUpdate() > 0){
                ResultSet rs = cmd.getGeneratedKeys();
                return (rs.next()) ? rs.getInt(1): -1;
            }else{
                return -1;
            }
            
        } catch (SQLException e) {
            System.out.println("ERRO SQL" + e.getMessage());
        }finally{
        ConexaoBD.Desconectar(con);//FECHAR CONEXÃO
    }
        return 0;
        
    }
    
     public void alterar(Autor a) {
        String sql = "UPDATE autor SET nome = ? where = id_autor = ?";// não sei como fazer para chamar o id_editora
       
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, a.getNome());
            preparedStatement.setInt(2, a.getId_autor());
            
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Autor a) {
        String sql = "delete from autor where nome = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, a.getNome());
            
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

#### EditoraDAO

```
package controller;

import java.sql.*;
import model.Editora;


public class EditoraDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Editora editora) {
        String sql = "insert into editora (nome)values(?)";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, editora.getNome()); 
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void alterar(Editora editora) {
        String sql = "UPDATE editora SET nome = ? WHERE id_editora = ?";// não sei como fazer para chamar o id_editora
       
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.setInt(2, editora.getId_editora());
            
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Editora editora) {
        String sql = "delete from editora where nome = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

#### LeitorDAO

```
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import model.Leitor;

public class LeitorDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    
 public void cadastrar(Leitor leitor) {
        String sql = "insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) \n" +
"VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,2)";
        
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, leitor.getNome()); 
            preparestatement.setString(2, leitor.getCpf());
            preparestatement.setDate(3, leitor.getDataNascimento());//converter
            preparestatement.setString(4, leitor.getTelefone());
            preparestatement.setString(5, leitor.getEmail());
            preparestatement.setString(6, leitor.getRua());
            preparestatement.setString(7, leitor.getNumero());
            preparestatement.setString(8, leitor.getBairro());
            preparestatement.setString(9, leitor.getCidade());
            preparestatement.setString(10, leitor.getCep());
            preparestatement.setString(11, leitor.getUf());
            //preparestatement.setInt(12, leitor.getId_login());
            
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void alterar(Leitor leitor) {
        String sql = "UPDATE leitor SET nome = ?, cpf=?,data_nascimento= ?, telefone= ?,email= ?,rua= ?,numero= ?,bairro= ?,cidade=? ,cep= ?,uf=?, id_login=2 \n" +
"WHERE  id_leitor = ?";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
             preparestatement.setString(1, leitor.getNome()); 
            preparestatement.setString(2, leitor.getCpf());
            preparestatement.setDate(3, leitor.getDataNascimento());//converter
            preparestatement.setString(4, leitor.getTelefone());
            preparestatement.setString(5, leitor.getEmail());
            preparestatement.setString(6, leitor.getRua());
            preparestatement.setString(7, leitor.getNumero());
            preparestatement.setString(8, leitor.getBairro());
            preparestatement.setString(9, leitor.getCidade());
            preparestatement.setString(10, leitor.getCep());
            preparestatement.setString(11, leitor.getUf());
            preparestatement.setInt(13, leitor.getId_leitor());
            
           
            preparestatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Leitor leitor) {
        String sql = "DELETE FROM leitor WHERE id_leitor = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, leitor.getId_leitor());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
```

#### LivroDAO

```
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Livro;

public class LivroDAO {
    
     private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Livro livro) {
        //String sql = "insert into livro (nome, id_login) values(?,2)";
     String sql = "insert into livro (titulo, volume, ano, id_login, id_editora,id_autor) values (?, ?,?,2,?,?)";
     //id_login iserir no direto do comando
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, livro.getTitulo());
            preparestatement.setInt(2, livro.getVolume());
            preparestatement.setString(3, livro.getAnoedicao());
            preparestatement.setString(5, livro.getAutor());
            preparestatement.setString(6, livro.getEditora());
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void alterar(Livro livro) {
        String sql = "update livro set titulo = ? AND autor ? AND editora = ? AND ano = ? AND volume = ?";// não sei como fazer para chamar o id_editora
      
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
            preparestatement.setString(1, livro.getTitulo());
            preparestatement.setString(2, livro.getAutor());
            preparestatement.setString(3, livro.getEditora());
            preparestatement.setString(4, livro.getAnoedicao());
            preparestatement.setInt(5, livro.getVolume());
           
            preparestatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Livro livro) {
        String sql = "DELETE from livro WHERE titulo = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
```

#### UsuarioDAO

```
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, senha, tipo, id_login) values (?,?,?,2)";
     //id_login iserir no direto do comando
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, usuario.getNome());
            preparestatement.setString(2, usuario.getSenha());
            preparestatement.setString(3, usuario.getTipo());
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 
    public void excluir(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE nome = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
```
#### ConexãoDB

```
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    //Detalhes da Conexão    
    private static final String DATABASE="biblioteca";
    private static final String HOST="jdbc:mysql://localhost:3306/biblioteca";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    //Para tirar erro de SSL em alguns casos em que tem varios Bancos e Certificados
    private static final String URL="jdbc:mysql://localhost:3306/biblioteca?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String USR="root";
    private static final String PWD="";
//Metodo conectar    
    public static Connection Conectar(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USR, PWD);
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocorreu falha na conexão com Banco de Dados, acione equipe de suporte ! ");
            System.out.println("Falha ao Conectar com Banco de Dados: " + "ERRO RETORNADO: " + e.getMessage());
                    JOptionPane.showMessageDialog(null,"Falha de Comunicação com Banco de Dados", "WARNING: Conexão com Banco", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
//Método Desconectar    
    public static void Desconectar (Connection con){
        try{
            if (con != null){
                con.close();
            }
        }
        catch (SQLException e){
                System.out.println("ERRO: " + e.getMessage());
               }
        }  
//Metodo Main 
    public static void main(String[] args){
        if (Conectar() != null){
            System.out.println("Conexão realizada com sucesso!");
            System.out.println("Conectado ao Banco de Dados Bibliotexa - Mysql");
            JOptionPane.showMessageDialog(null,"Operação realizada com sucesso !", "CONEXÃO COM SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        }
    }      
    
}
```
## Classes da camada Model.

#### Classe Autor

```



