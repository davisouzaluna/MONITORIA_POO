# Classe `Pessoa` – Java

Este diretório contém um exemplo simples de uma classe Java chamada `Pessoa`, usada para fins educacionais. Ele demonstra como declarar atributos, criar um construtor, implementar métodos e testar o código com o método `main`.

## Objetivo

O objetivo deste exemplo é ensinar os conceitos básicos de programação orientada a objetos (POO) em Java, como:

- Criação de classes
- Encapsulamento de dados com atributos privados
- Uso de construtores
- Criação de métodos públicos
- Execução e teste de um programa Java com o método `main`

## 💡 Estrutura da Classe

\`\`\`java
public class Pessoa {
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para apresentar
    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }

    // Método main para testar
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana", 25);
        p1.apresentar();
    }
}
\`\`\`


## 🔍 Explicação do Código

- **Atributos `nome` e `idade`:** São privados, seguindo o princípio do encapsulamento.
- **Construtor:** Inicializa os atributos.
- **Método `apresentar()`:** Imprime uma saudação.
- **Método `main`:** Testa o comportamento da classe.

## Como Executar

1. Compile:
   ```bash
   javac Pessoa.java
   ```
2. Execute:
   ```bash
   java Pessoa
   ```

## Script para ajudar o tópico anterior

1. Adicione permissão de leitura ao arquivo `execute.sh`
    ```bash
    chmod +x execute.sh
    ```
2. Execute
    ```bash
    execute <nome_do_arquivo>
    ```


## Para Saber Mais

Explore temas como:

- Getters e Setters
- Herança
- Polimorfismo

## Autoria: Davi Souza de Luna
