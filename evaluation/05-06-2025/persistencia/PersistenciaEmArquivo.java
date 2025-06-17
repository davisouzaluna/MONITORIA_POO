package sistema.bancario.prova.persistencia;

import sistema.bancario.prova.model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class PersistenciaEmArquivo {
    private ArrayList<Cliente> clientes;
    private static final String ARQUIVO = "dados";

    public PersistenciaEmArquivo() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null || clientes.contains(cliente)) {
            throw new IllegalArgumentException("Cliente inválido ou já existente.");
        }
        clientes.add(cliente);
    }

    public void removerCliente(String cpf) {
        if (cpf == null) {
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cpf.equals(cliente.getCpf())) {
                clientes.remove(i);
                break; //remove apenas o primeiro cliente com esse CPF, dps disso o laço para
            }
        }
    }


    public Cliente localizarClientePorCpf(String cpf) {
        if (cpf == null) {
            return null;
        }
        for (Cliente cliente : clientes) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        return null;
    }


    public void atualizarCliente(Cliente novoCliente) {
        removerCliente(novoCliente.getCpf());
        adicionarCliente(novoCliente);
    }

    public void salvarEmArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDeArquivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            clientes = (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            clientes = new ArrayList<>();
        }
    }

    public ArrayList<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Encapsulamento
    }
}
