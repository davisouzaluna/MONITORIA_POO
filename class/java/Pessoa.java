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
        Pessoa p1 = new Pessoa("Ana", 25); // Criando objeto
        p1.apresentar();
    }
}
