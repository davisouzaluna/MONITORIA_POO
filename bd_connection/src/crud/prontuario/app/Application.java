package crud.prontuario.app;

import crud.prontuario.dao.IEntityDAO;
import crud.prontuario.dao.PacienteDAO;
import crud.prontuario.database.DatabaseConnectionMySQL;
import crud.prontuario.model.Paciente;

public class Application {
	
	public static void main(String[] args) {
		
		IEntityDAO<Paciente> dao = 
				new PacienteDAO(new DatabaseConnectionMySQL());
		Paciente p = new Paciente(0L, "Davi", "000");
		
		dao.create(p);
	}
}
