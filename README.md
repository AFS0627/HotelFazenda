# HotelFazenda

# 🏨 Sistema de Gerenciamento de Hóspedes

Sistema desktop desenvolvido em **Java** para gerenciamento de hóspedes de um estabelecimento hoteleiro.

O projeto permite cadastrar, visualizar, alterar e excluir hóspedes, além de armazenar as informações de forma persistente em arquivo. A aplicação possui uma interface gráfica desenvolvida com **Java Swing** e utiliza **MigLayout** para organização dos componentes.

## 📌 Sobre o projeto

O sistema foi desenvolvido com o objetivo de praticar conceitos de **Programação Orientada a Objetos**, desenvolvimento de interfaces gráficas e persistência de dados em Java.

Cada hóspede possui informações pessoais, dados da reserva, informações de contato e uma avaliação.

Os dados são armazenados localmente por meio de **serialização de objetos Java**, utilizando um arquivo `dados.dat`.

## ✨ Funcionalidades

* ➕ Cadastro de hóspedes
* 📋 Visualização dos hóspedes em tabela
* ✏️ Alteração dos dados de um hóspede
* 🗑️ Exclusão de hóspedes
* ⭐ Avaliação do hóspede de 0 a 5
* 🧹 Limpeza automática dos campos após o cadastro
* 💾 Persistência dos dados em arquivo
* 📅 Manipulação de datas utilizando `LocalDate`
* 🔄 Carregamento automático dos dados ao iniciar o sistema
* 💽 Salvamento dos dados ao fechar a aplicação

A tela principal possui campos para nome, nascimento, nacionalidade, passaporte, check-in, check-out, quarto, valor pago, e-mail, telefone, endereço, número de pessoas, solicitações especiais e avaliação.

## 🛠️ Tecnologias utilizadas

* **Java**
* **Java Swing**
* **MigLayout**
* **Java Serialization**
* **LocalDate / DateTimeFormatter**
* **Eclipse IDE**

## 🏗️ Estrutura do projeto

O projeto segue uma organização baseada na separação entre **modelo, controle e visão**:

```text
src/
├── modelo/
│   └── Hospede.java
│
├── controle/
│   └── HospedeDAO.java
│
└── visao/
    ├── Janela.java
    └── JanelaAlterarHospede.java
```

### 📦 Modelo

A classe `Hospede` representa os dados de cada hóspede.

Entre seus atributos estão:

* Nome
* Data de nascimento
* Nacionalidade
* Passaporte
* Check-in
* Check-out
* Número do quarto
* Total pago
* E-mail
* Telefone
* Endereço
* Número de pessoas
* Solicitações especiais
* Avaliação

A classe implementa `Serializable`, permitindo que os objetos sejam gravados diretamente em arquivo.

### 💾 Controle

A classe `HospedeDAO` é responsável pela persistência dos dados.

Ela realiza principalmente duas operações:

```java
escreverArquivo(lista, "dados.dat");
```

e

```java
lerArquivo("dados.dat");
```

Dessa forma, a lista de hóspedes é salva e posteriormente recuperada quando o sistema é iniciado.

### 🖥️ Visão

A interface gráfica é construída utilizando **Java Swing**.

A classe `Janela` representa a tela principal do sistema e contém os campos de cadastro, tabela e botões de operação.

As principais operações disponíveis são:

```text
Adicionar
Alterar
Excluir
Fechar
```

## 🔄 Funcionamento

Ao iniciar a aplicação, os dados existentes são carregados do arquivo `dados.dat`.

### Cadastro

O usuário preenche os dados do hóspede e seleciona a avaliação.

Ao clicar em **Adicionar**, um novo objeto `Hospede` é criado e inserido na lista:

```java
Hospede novoHospede = new Hospede();
listaHospedes.add(novoHospede);
```

Após o cadastro, a tabela é atualizada para exibir o novo registro.

### Alteração

O usuário seleciona um registro na tabela e utiliza o botão **Alterar**.

Os dados do hóspede selecionado são enviados para uma tela específica de alteração, onde podem ser modificados.

### Exclusão

O registro selecionado na tabela pode ser removido através do botão **Excluir**.

### Persistência

Ao fechar o sistema, a lista de hóspedes é gravada no arquivo:

```text
dados.dat
```

A aplicação também realiza o salvamento no evento de fechamento da janela.

## 📅 Formato das datas

As datas são informadas no formato:

```text
dd/MM/yyyy
```

Exemplo:

```text
25/09/2026
```

O projeto utiliza `DateTimeFormatter` para realizar a conversão entre texto e `LocalDate`.

## 🚀 Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

### 2. Abra o projeto

Abra o projeto em uma IDE compatível com Java, como:

* Eclipse
* IntelliJ IDEA
* NetBeans

### 3. Verifique a dependência

O projeto utiliza a biblioteca **MigLayout**. Certifique-se de que ela esteja disponível no classpath do projeto.

### 4. Execute a aplicação

Execute a classe:

```text
visao.Janela
```

A interface gráfica será aberta e o arquivo `dados.dat` será utilizado para armazenar os registros.

## 💾 Armazenamento dos dados

O sistema utiliza **serialização de objetos** para armazenar a lista de hóspedes.

O arquivo utilizado é:

```text
dados.dat
```

Por isso, o arquivo é criado/atualizado durante a utilização do sistema e deve ser mantido caso os dados cadastrados precisem ser preservados.

## 🎯 Conceitos praticados

Este projeto envolve diversos conceitos importantes de Java:

* Programação Orientada a Objetos
* Classes e objetos
* Encapsulamento
* Getters e setters
* Herança de interfaces (`Serializable`)
* Collections (`ArrayList`)
* Serialização de objetos
* Persistência de dados
* Java Swing
* Eventos e `ActionListener`
* Tabelas com `JTable`
* `DefaultTableModel`
* Manipulação de datas
* Organização em pacotes
* Separação entre modelo, controle e visão

## 📷 Interface

A aplicação possui uma tela principal para gerenciamento dos hóspedes, contendo formulário de cadastro e uma tabela para visualização dos registros.

> Adicione aqui screenshots da aplicação para deixar o repositório mais completo.

Exemplo:

```text
docs/
├── tela-principal.png
└── tela-alteracao.png
```

## 📚 Objetivo acadêmico

Projeto desenvolvido com finalidade acadêmica para aplicação prática de conceitos de desenvolvimento de sistemas desktop utilizando Java.

---

## 👨‍💻 Autor

**Arthur de França Schoening**

Desenvolvido utilizando **Java + Swing**.
