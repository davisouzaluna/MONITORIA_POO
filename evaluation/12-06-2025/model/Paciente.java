package sistema.prontuario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;
    private double peso;
    private double altura;
    private String sexo;
    private int idade;
    private ArrayList<Exame> exames;

    public Paciente() {
        this.exames = new ArrayList<>();
        this.peso = 0.0;
        this.altura = 0.0;
        this.sexo = "";
        this.idade = 0;
    }

    public Paciente(String cpf, String nome, double peso, double altura, String sexo, int idade) {
        this()//chama ela mesma, no caso seu construtor vazio

        // pra evitar de deixar o construtor gigantesco, faz essas validacoes com os getters e setters
        setCpf(cpf);
        setNome(nome);
        setPeso(peso);
        setAltura(altura);
        setSexo(sexo);
        setIdade(idade);
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        /**
         * 
         * nome.trim().isEmpty() -->remove os espaços em branco do início e do fim da string nome. Entao um nome " " ou "   " seria considerado vazio
         * e lançaria uma exceção.
         */
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (!"M".equals(sexo) && !"F".equals(sexo)) {
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
        }
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    // Retorna cópia defensiva da lista exames
    public ArrayList<Exame> getExames() {
        return new ArrayList<>(exames);
    }

    public void adicionarExame(Exame exame) {
        if (exame == null) {
            throw new IllegalArgumentException("Exame não pode ser nulo.");
        }
        if (!exames.contains(exame)) {
            exames.add(exame);
        }
    }

    public void removerExame(String idExame) {
        exames.removeIf(e -> e.getIdExame().equals(idExame));
    }

    public Exame localizarExamePorId(String idExame) {
        for (Exame e : exames) {
            if (e.getIdExame().equals(idExame)) {
                return e;
            }
        }
        return null;
    }

    public void atualizarExame(Exame novoExame) {
        if (novoExame == null) {
            return;
        }
        for (int i = 0; i < exames.size(); i++) {
            if (exames.get(i).getIdExame().equals(novoExame.getIdExame())) {
            	//muda o elemento do array
                exames.set(i, novoExame);
                break;
            }
        }
    }

    public double calcularIMC() {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalStateException("Peso e altura devem ser maiores que zero para calcular IMC.");
        }
        return peso / (altura * altura);
    }

    public double calcularBMR() {
        if (peso <= 0) {
            throw new IllegalStateException("Peso deve ser maior que zero para calcular o BMR.");
        }
        if (altura <= 0) {
            throw new IllegalStateException("Altura deve ser maior que zero para calcular o BMR.");
        }
        if (idade <= 0) {
            throw new IllegalStateException("Idade deve ser maior que zero para calcular o BMR.");
        }
        if (!"M".equals(sexo) && !"F".equals(sexo)) {
            throw new IllegalStateException("Sexo deve ser 'M' ou 'F' para calcular o BMR.");
        }

        double alturaCm = altura * 100.0;

        if ("M".equals(sexo)) {
            return (10 * peso) + (6.25 * alturaCm) - (5 * idade) + 5;
        } else {
            return (10 * peso) + (6.25 * alturaCm) - (5 * idade) - 161;
        }
    }

    public double calcularPesoIdeal() {
        if (altura <= 0) {
            throw new IllegalStateException("Altura deve ser maior que zero para calcular o peso ideal.");
        }
        if (!"M".equals(sexo) && !"F".equals(sexo)) {
            throw new IllegalStateException("Sexo deve ser 'M' ou 'F' para calcular o peso ideal.");
        }

        double alturaCentimetros = altura * 100.0;
        double diferencaAltura = alturaCentimetros - 150.0;

        double fatorDivisao;
        if ("M".equals(sexo)) {
            fatorDivisao = 4.0;
        } else {
            fatorDivisao = 2.0;
        }

        double ajustePeso = diferencaAltura / fatorDivisao;
        double pesoIdeal = alturaCentimetros - 100.0 - ajustePeso;

        return pesoIdeal;
    }


    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", nome=" + nome + ", peso=" + peso + ", altura=" + altura + ", sexo=" + sexo
                + ", idade=" + idade + ", exames=" + exames.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cpf, paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
