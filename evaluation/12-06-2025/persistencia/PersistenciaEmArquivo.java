package sistema.prontuario.persistencia;

import sistema.prontuario.model.Paciente;

import java.io.*;
import java.util.ArrayList;

public class PersistenciaEmArquivo {

    private ArrayList<Paciente> pacientes;
    private static final String ARQUIVO = "dados";

    public PersistenciaEmArquivo() {
        this.pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não pode ser nulo.");
        }
        if (localizarPacientePorCpf(paciente.getCpf()) == null) {
            pacientes.add(paciente);
        }
    }

    public void removerPaciente(String cpf) {
        pacientes.removeIf(p -> p.getCpf().equals(cpf));
    }

    public Paciente localizarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public void atualizarPaciente(Paciente novoPaciente) {
        if (novoPaciente == null) {
            return;
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(novoPaciente.getCpf())) {
                pacientes.set(i, novoPaciente);
                break;
            }
        }
    }

    public void salvarEmArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(pacientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 
     *  O aviso de "unchecked" ocorre porque o método readObject() retorna um Object
     * genérico, e a conversão para ArrayList<Paciente> não pode ser verificado em tempo
     * de compilação devido ao apagamento de tipos (type erasure) do Java. Leia na doc: https://docs.oracle.com/javase/tutorial/java/generics/erasure.html 
     * 
     * Como confiamos(eu confio kkkk) que o conteúdo do arquivo é de fato um ArrayList<Paciente>, 
     * suprimimos esse aviso para evitar poluição do código com warnings desnecessários.
     * 
     * Caso o arquivo não exista ou ocorra algum erro na leitura, a lista de pacientes 
     * é inicializada como vazia(linha 77).
     * 
     * 
     * */
    @SuppressWarnings("unchecked")
    public void carregarDeArquivo() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            pacientes = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            pacientes = (ArrayList<Paciente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            pacientes = new ArrayList<>();
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }
}
