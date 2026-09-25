# 🏨 Sistema de Gerenciamento de Hóspedes

Sistema desktop desenvolvido em **Java** utilizando **Java Swing**, com arquitetura baseada no padrão **MVC (Model-View-Controller)**.

O projeto permite realizar o gerenciamento de hóspedes de um hotel, incluindo cadastro, consulta, alteração e exclusão de registros, além da persistência dos dados em arquivo.

---

## 📋 Sobre o Projeto

O sistema foi desenvolvido com o objetivo de fornecer uma interface gráfica simples para o gerenciamento de informações de hóspedes.

Cada hóspede possui informações pessoais, dados de hospedagem, contato, pagamento e avaliação.

O projeto utiliza o padrão **MVC**, separando as responsabilidades entre:

* **Model** — representa os dados e entidades do sistema.
* **View** — responsável pela interface gráfica.
* **Controller** — concentra as regras de negócio, validações e comunicação entre a interface e os dados.
* **DAO** — responsável pela persistência dos dados.

---

## ✨ Funcionalidades

### 👤 Cadastro de hóspedes

Permite cadastrar hóspedes informando:

* Nome
* Data de nascimento
* Nacionalidade
* Passaporte
* Data de check-in
* Data de check-out
* Número do quarto
* Total pago
* E-mail
* Telefone
* Endereço
* Número de pessoas
* Solicitações especiais
* Avaliação

### 🔎 Visualização

Os hóspedes cadastrados são apresentados em uma tabela na interface gráfica.

### ✏️ Alteração

Permite selecionar um hóspede cadastrado e alterar seus dados.

### 🗑️ Exclusão

Permite remover um hóspede selecionado da lista.

### 💾 Persistência

Os dados são armazenados localmente no arquivo:

```text
dados.dat
```

A persistência utiliza **serialização de objetos Java**, permitindo que os dados permaneçam disponíveis após o encerramento do programa.

### ✅ Validação

O sistema realiza validações antes de cadastrar ou alterar um hóspede, verificando, entre outros:

* Campos obrigatórios
* Formato das datas
* Datas de check-in e check-out
* Número do quarto
* Valor pago
* E-mail
* Número de pessoas
* Avaliação
* Valores numéricos

Quando um dado é inválido, o sistema informa o problema através de uma mensagem na interface.

---

## 🏗️ Arquitetura

O projeto utiliza uma estrutura baseada em **MVC**:

```text
src/
│
├── modelo/
│   └── Hospede.java
│
├── controle/
│   ├── HospedeController.java
│   └── HospedeDAO.java
│
└── visao/
    ├── Janela.java
    └── JanelaAlterarHospede.java
```

### Model

Responsável pela representação dos dados do sistema.

```text
modelo/
└── Hospede.java
```

A classe `Hospede` representa um hóspede e contém seus atributos, getters e setters.

A classe implementa `Serializable` para permitir a persistência dos objetos.

---

### Controller

Responsável pela lógica da aplicação.

```text
controle/
└── HospedeController.java
```

O `HospedeController` realiza operações como:

* Adicionar hóspedes
* Excluir hóspedes
* Buscar hóspedes
* Alterar hóspedes
* Validar informações
* Preparar os dados para a tabela
* Solicitar a persistência dos dados

A validação dos campos é realizada no Controller, mantendo a View mais focada na interface gráfica.

---

### DAO

Responsável pela comunicação com o arquivo de dados.

```text
controle/
└── HospedeDAO.java
```

O `HospedeDAO` realiza:

* Leitura dos dados
* Escrita dos dados
* Criação/acesso ao arquivo `dados.dat`

A persistência é realizada através de `ObjectInputStream` e `ObjectOutputStream`.

---

### View

Responsável pela interface gráfica do sistema.

```text
visao/
├── Janela.java
└── JanelaAlterarHospede.java
```

A View utiliza **Java Swing** para construção da interface.

Ela é responsável principalmente por:

* Exibir os componentes gráficos
* Capturar os dados digitados pelo usuário
* Exibir a tabela
* Acionar as operações do Controller
* Atualizar a interface após as operações

---

## 🛠️ Tecnologias utilizadas

| Tecnologia         | Utilização                           |
| ------------------ | ------------------------------------ |
| Java 11            | Linguagem e plataforma               |
| Java Swing         | Interface gráfica                    |
| MVC                | Organização da aplicação             |
| Java Serialization | Persistência dos dados               |
| MigLayout          | Gerenciamento de layout da interface |
| Eclipse            | Ambiente de desenvolvimento          |

---

## ☕ Requisitos

Para executar o projeto é necessário ter instalado:

* **Java Development Kit (JDK) 11**
* **Eclipse IDE** ou outra IDE compatível com projetos Java
* Biblioteca **MigLayout**

Verifique a versão do Java instalada:

```bash
java -version
```

O projeto deve utilizar Java 11.

---

## ▶️ Executando o projeto

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta:

```bash
cd NOME_DO_PROJETO
```

### 2. Abrir no Eclipse

No Eclipse:

```text
File
→ Import
→ Existing Projects into Workspace
```

Selecione a pasta do projeto.

### 3. Configurar o Java 11

Verifique se o projeto está utilizando o **JDK 11**:

```text
Project
→ Properties
→ Java Build Path
→ Libraries
```

e também:

```text
Project
→ Properties
→ Java Compiler
```

Configure o nível de compilação para:

```text
11
```

### 4. Executar

Execute a classe principal do projeto através do Eclipse:

```text
Run As
→ Java Application
```

---

## 💾 Arquivo de dados

O sistema utiliza o arquivo:

```text
dados.dat
```

Esse arquivo contém os hóspedes cadastrados através da serialização de objetos Java.

O arquivo é criado/atualizado automaticamente pelo sistema.

### ⚠️ Importante

O arquivo `dados.dat` não deve ser editado manualmente.

Caso o arquivo seja removido, o sistema poderá iniciar com uma lista vazia de hóspedes.

---

## 🔄 Fluxo da aplicação

O funcionamento básico do sistema segue o seguinte fluxo:

```text
Usuário
   │
   ▼
┌─────────────┐
│    View     │
│  Java Swing │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Controller  │
│             │
│ Validação   │
│ Regras      │
│ Operações   │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│    Model    │
│   Hospede   │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│     DAO     │
│             │
│  dados.dat  │
└─────────────┘
```

---

## 📁 Estrutura do projeto

```text
Projeto/
│
├── src/
│   │
│   ├── modelo/
│   │   └── Hospede.java
│   │
│   ├── controle/
│   │   ├── HospedeController.java
│   │   └── HospedeDAO.java
│   │
│   └── visao/
│       ├── Janela.java
│       └── JanelaAlterarHospede.java
│
├── dados.dat
│
└── README.md
```

> A localização física do `dados.dat` pode variar de acordo com a forma como o projeto é executado no ambiente Java/Eclipse.

---

## 🔐 Validações

Antes de um hóspede ser cadastrado ou alterado, o sistema verifica os dados fornecidos.

Exemplos:

```text
Nome vazio
        ↓
   Erro de validação
```

```text
Data inválida
        ↓
   Erro de validação
```

```text
Número do quarto inválido
        ↓
   Erro de validação
```

```text
E-mail inválido
        ↓
   Erro de validação
```

Quando ocorre uma falha, os dados não são gravados.

No cadastro, os campos também não são limpos caso o hóspede não tenha sido adicionado com sucesso.

---

## 🎯 Objetivo acadêmico

O projeto foi desenvolvido para aplicar conceitos de programação orientada a objetos e desenvolvimento de aplicações desktop em Java, incluindo:

* Classes e objetos
* Encapsulamento
* ArrayList
* Serialização
* Manipulação de arquivos
* Tratamento de exceções
* Interfaces gráficas com Swing
* Separação de responsabilidades
* Padrão arquitetural MVC
* Validação de dados
* Manipulação de datas com `LocalDate`

---

## 📌 Observações

* O projeto utiliza **Java 11**.
* Os dados são armazenados localmente.
* Não é utilizado banco de dados relacional.
* A persistência é feita através de serialização Java.
* A interface gráfica é construída com Swing.
* O sistema foi estruturado buscando separar interface, regras de negócio, modelo e persistência.

---

## 👨‍💻 Desenvolvimento

Projeto desenvolvido em Java para gerenciamento de hóspedes.

**AUTOR:** Arthur de França Schoening
**Linguagem:** Java 11
**Interface:** Java Swing
**Arquitetura:** MVC
**Persistência:** Java Serialization
