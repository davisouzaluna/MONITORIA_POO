# Classe `Pessoa` – C++

Este diretório contém um exemplo simples de uma classe, em C++, chamada `Pessoa`, usada para fins educacionais. Ele demonstra como declarar atributos, criar um construtor, implementar métodos e testar o código com o método `main`.

## Objetivo

O objetivo deste exemplo é ensinar os conceitos básicos de programação orientada a objetos (POO) em C++, como:

- bApresentar conceitos básicos de classes em C++
- Demonstrar o uso de construtor com lista de inicialização
- Explicar a separação entre atributos e métodos
- Ensinar como compilar um projeto com CMake

## Codigo fonte:

```cpp
#include <iostream>
#include <string>

class Pessoa {
private:
    std::string nome;
    int idade;

public:
    Pessoa(const std::string& nome, int idade) : nome(nome), idade(idade) {}

    void apresentar() const {
        std::cout << "Nome: " << nome << ", Idade: " << idade << std::endl;
    }
};

int main() {
    Pessoa p("Maria", 25);
    p.apresentar();
    return 0;
}
```

## 🔍 Explicação

- **Atributos `nome` e `idade`**:  
  Privados, acessíveis apenas por métodos da classe.

- **Construtor com lista de inicialização**:  
  `: nome(nome), idade(idade)` é uma forma eficiente de inicializar atributos, principalmente objetos complexos.

- **Método `apresentar()`**:  
  Exibe os dados da pessoa usando `std::cout`.

- **Função `main()`**:  
  Cria um objeto `Pessoa` e chama seu método público.

## O que é o CMAKE
O CMake é uma ferramenta de automação de compilação (build system generator), usada principalmente em projetos C e C++. Ele facilita a geração de arquivos de build (como Makefiles ou projetos do Visual Studio), que são usados para compilar o código-fonte de forma organizada e portátil entre diferentes sistemas operacionais.

Em vez de escrever manualmente comandos de compilação para cada arquivo e dependência, você descreve a estrutura do projeto em um arquivo chamado CMakeLists.txt, e o CMake se encarrega de gerar os arquivos de compilação apropriados para o seu ambiente.

### Principais Vantagens:
- Portabilidade: Funciona em Windows, Linux e macOS.
- Produtividade: Automatiza o processo de build.
- Organização: Ajuda a manter projetos grandes bem estruturados.
- Integração: Funciona com várias IDEs (como CLion, Visual Studio, Qt Creator).
- Flexibilidade: Suporta múltiplos compiladores e configurações de build.

O CMake não compila diretamente seu código — ele gera os scripts que o compilador (como g++ ou clang) vai usar.

## Como compilar e executar com o CMAKE
1. Primeiro é importante criar um diretório onde você vai salvar os executáveis. Geralmente isso é feito na raiz do seu projeto. No nosso caso, dentro de onde está o diretório onde contém o arquivo CMAKE vamos criar o diretório `build`

    ```bash
    mkdir build && cd build
    ```
2. Logo em seguida iremos buildar o arquivo, apontando o programa cmake(anteriormente instalado) para o diretório onde está localizado o arquivo `CMakeLists.txt`

    ```bash
    cmake ..
    ```

3. Por último vamos criar os executáveis. Temos duas opções:

    ```bash
    cmake --build
    ```
    ou
    ```bash
    make
    ```
4. Agora é só executar



