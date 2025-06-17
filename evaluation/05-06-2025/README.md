# Monitoria – Programação Orientada a Objetos  
##  Atividade Avaliativa: Sistema Bancário Simplificado

Este diretório contém uma implementação contendo uma resposta alternativa da atividade avaliativa da disciplina **Programação Orientada a Objetos**, com foco em boas práticas, organização e suporte ao processo de monitoria. A atividade consiste na criação de um sistema bancário simplificado com funcionalidades de cliente, conta bancária e persistência de dados em arquivo.

---

###  Encapsulamento
- Todos os atributos são privados.
- As listas (ex: contas de um cliente) estão protegidas com cópias defensivas.
- Getters e setters foram implementados apenas quando necessários.

###  Classe `Cliente`
- Representa um cliente do banco.
- Atributos: `cpf`, `nome`, `ArrayList<Conta> contas`.
- Métodos principais:
  - `adicionarConta`, `removerConta`, `localizarContaPorNumero`, `atualizarConta`.
  - `equals` e `hashCode` baseados no CPF.
- Implementa `Serializable` com `serialVersionUID`.

### Classe `Conta`
- Representa uma conta bancária.
- Atributos: `numeroConta`, `saldo` (`BigDecimal`), `status`, `dataAbertura` (`LocalDateTime`).
- Métodos principais:
  - `depositar`, `sacar`, `transferir`, `ativarConta`, `desativarConta`.
  - `equals` e `hashCode` baseados no número da conta.
- Implementa `Serializable` com `serialVersionUID`.

###  Classe `PersistenciaEmArquivo`
- Responsável por salvar e carregar os clientes no arquivo `"dados"`.
- Usa `ObjectOutputStream` e `ObjectInputStream`.
- Trata exceções de I/O e `ClassNotFoundException`.

---

