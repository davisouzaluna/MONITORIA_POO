
# Conexão com o Banco de dados/Primeiro CRUD

## Estrutura do Projeto

Dentro de `./src/crud` temos:

├── prontuario/
│   ├── app/                
│   ├── dao/                 
│   ├── database/            
│   └── model/ 

---
## Funcionalidades

- Criar um novo paciente
- Buscar paciente por ID
- Atualizar dados de um paciente
- Remover paciente do banco
- Listar todos os pacientes

---

## Tecnologias

- Java 21 (versão utilizada: 21.0.4)
- JDBC
- MySQL
- Padrão DAO (Data Access Object)


---

##  Configuração do Banco de Dados

Antes de executar a aplicação, certifique-se de que:

1. O MySQL está instalado e em execução.
2. Um banco de dados chamado `prontuario` foi criado:

   CREATE DATABASE prontuario;

3. A tabela `PACIENTES` foi criada com a seguinte estrutura:

   CREATE TABLE PACIENTES (
       ID BIGINT PRIMARY KEY,
       NOME VARCHAR(100),
       CPF VARCHAR(20)
   );

4. O usuário `root` com senha `root` está configurado (ou ajuste isso na classe DatabaseConnectionMySQL).

O script basico esta dentro de `./sql/script.sql`
---

## Execucao

A classe `Application.java` realiza um exemplo de CRUD completo:

```java
public class Application {
    public static void main(String[] args) {
        IEntityDAO<Paciente> dao = new PacienteDAO(new DatabaseConnectionMySQL());

        // Criação
        Paciente p = new Paciente(1L, "Gustavo", "000");
        dao.create(p);

        // Leitura
        Paciente buscado = dao.findById(1L);
        System.out.println(buscado);

        // Atualização
        buscado.setNome("Gustavo");
        dao.update(buscado);

        // Listagem
        List<Paciente> pacientes = dao.findAll();
        pacientes.forEach(System.out::println);

        // Remoção
        dao.delete(buscado);
    }
}

```

## Conexão com o Banco de Dados

A interface `IConnection` define os métodos de conexão e fechamento da conexão:

public interface IConnection {
    Connection getConnection();
    void closeConnection();
}

A classe `DatabaseConnectionMySQL` implementa a conexão com o MySQL:

```java
public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:"+PORT+"/"+DATABASE, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
```

⚠️ A implementação do closeConnection() ainda pode ser aprimorada para fechar recursos automaticamente com try-with-resources. Mas inicialmente os parâmetros de conexão são definidos nas veriáveis que estão sendo concatenadas dentro do endereço

---
## Objetivo

Este projeto serve para:

- Mostrar separação entre responsabilidades (DAO, modelo, conexão)
- Aplicar interfaces e herança em Java
- Ensinar conceitos de JDBC de forma clara e prática
- Desenvolver lógica básica de acesso a dados sem frameworks