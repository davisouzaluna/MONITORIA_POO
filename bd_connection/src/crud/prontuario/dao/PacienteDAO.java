package crud.prontuario.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.prontuario.database.IConnection;
import crud.prontuario.model.Paciente;

public class PacienteDAO implements IEntityDAO<Paciente> {

	private IConnection conn;

	public PacienteDAO(IConnection connection) {
		this.conn = connection;
	}

	@Override
	public void create(Paciente t) {
		try {
			PreparedStatement pstm = conn.getConnection()
					.prepareStatement("INSERT INTO PACIENTES (ID, NOME, CPF) VALUES (?, ?, ?);");
			pstm.setLong(1, t.getId());
			pstm.setString(2, t.getNome());
			pstm.setString(3, t.getCpf());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Paciente findById(Long id) {
		try {
			PreparedStatement pstm = conn.getConnection()
					.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?;");
			pstm.setLong(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getLong("ID"));
				paciente.setNome(rs.getString("NOME"));
				paciente.setCpf(rs.getString("CPF"));
				rs.close();
				pstm.close();
				return paciente;
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Paciente t) {
		try {
			PreparedStatement pstm = conn.getConnection()
					.prepareStatement("DELETE FROM PACIENTES WHERE ID = ?;");
			pstm.setLong(1, t.getId());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Paciente> findAll() {
		List<Paciente> pacientes = new ArrayList<>();
		try {
			PreparedStatement pstm = conn.getConnection()
					.prepareStatement("SELECT * FROM PACIENTES;");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getLong("ID"));
				paciente.setNome(rs.getString("NOME"));
				paciente.setCpf(rs.getString("CPF"));
				pacientes.add(paciente);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	@Override
	public void update(Paciente t) {
		try {
			PreparedStatement pstm = conn.getConnection()
					.prepareStatement("UPDATE PACIENTES SET NOME = ?, CPF = ? WHERE ID = ?;");
			pstm.setString(1, t.getNome());
			pstm.setString(2, t.getCpf());
			pstm.setLong(3, t.getId());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
