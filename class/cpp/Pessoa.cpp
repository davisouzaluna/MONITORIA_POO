#include <iostream>
#include <string>

class Pessoa {
private:
    std::string nome;
    int idade;

public:
    /* Construtor com parâmetros. Depois dos ":" vem a lista de inicialiszação, sendo a atribuição de valores aos atributos da classe.

    Essa opção é preferível quando os atributos são do tipo const ou referência, pois evita a criação de um objeto temporário.
    Além disso, é mais eficiente para tipos complexos, pois evita a cópia desnecessária.
    Se não for especificada, o compilador cria um construtor padrão.
    */
    Pessoa(const std::string& nome, int idade) : nome(nome), idade(idade) {}

    // Exemplo de um método
    void apresentar() const {
        
        /* Exibe os dados da pessoa
         Usando std::cout para imprimir na saída padrão
        std::endl para adicionar uma nova linha após a saída
        */
        std::cout << "Nome: " << nome << ", Idade: " << idade << std::endl;
    }
};

int main() {

    // Criação do objeto
    Pessoa p("Maria", 25);

    // Chamada de método
    p.apresentar();
    return 0;
}
