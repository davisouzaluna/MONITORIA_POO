package crud.prontuario.app;

import crud.prontuario.dao.IEntityDAO;
import crud.prontuario.dao.PacienteDAO;
import crud.prontuario.database.DatabaseConnectionMySQL;
import crud.prontuario.model.Paciente;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		IEntityDAO<Paciente> dao = new PacienteDAO(new DatabaseConnectionMySQL());

		// Criação de um novo paciente
		Paciente p = new Paciente(1L, "Gustavo", "000");
		System.out.println("Criando paciente...");
		dao.create(p);

		// Buscar paciente por ID(select com where)
		System.out.println("\nBuscando paciente com ID = 1");
		Paciente encontrado = dao.findById(1L);
		if (encontrado != null) {
			System.out.println("Paciente encontrado: " + encontrado);
		} else {
			System.out.println("Paciente não encontrado.");
		}

		// Atualizar paciente(update com where)
		System.out.println("\nAtualizando paciente com ID = 1");
		// Mudando nome e CPF do paciente encontrado
		encontrado.setNome("Gustavo Guanabara");
		encontrado.setCpf("111");
		dao.update(encontrado);
		System.out.println("Paciente atualizado.");

		// Buscar todos os pacientes(select *)
		System.out.println("\nListando todos os pacientes:");
		List<Paciente> pacientes = dao.findAll();
		for (Paciente paciente : pacientes) {
			System.out.println(paciente);
		}

		// Deletar paciente(delete com where)
		System.out.println("\nDeletando paciente com ID = 1");
		dao.delete(encontrado);
		System.out.println("Paciente deletado.");

		// Verificando se foi deletado(findbyid)
		System.out.println("\nVerificando se paciente ainda existe...");
		Paciente verificado = dao.findById(1L);
		if (verificado == null) {
			System.out.println("Paciente foi removido com sucesso.");
		} else {
			System.out.println("Paciente ainda está no banco: " + verificado);
		}
	}
}
