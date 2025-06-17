package sistema.bancario.prova.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;
    private ArrayList<Conta> contas;

    public Cliente() {
        this.contas = new ArrayList<>();
    }
    
    
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getContas() {
        return new ArrayList<>(contas); //Protege encapsulamento
    }

    public void adicionarConta(Conta conta) {
        if (conta == null || contas.contains(conta)) {
            throw new IllegalArgumentException("Conta inválida ou já existente.");
        }
        contas.add(conta);
    }

    public void removerConta(String numero) {
        if (numero == null) {
            return;
        }
        for (int i = 0; i < contas.size(); i++) {
            if (numero.equals(contas.get(i).getNumeroConta())) {
                contas.remove(i);
                break; //remove apenas a primeira conta com o número correspondente
            }
        }
    }

    public Conta localizarContaPorNumero(String numeroConta) {
        return contas.stream()
                .filter(c -> c.getNumeroConta().equals(numeroConta))
                .findFirst()
                .orElse(null);
    }

    public void atualizarConta(Conta novaConta) {
        removerConta(novaConta.getNumeroConta());
        adicionarConta(novaConta);
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
