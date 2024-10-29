package model.Medicamentos;

import model.ModeloDominio.GenerateRandom;
import model.ModeloDominio.Medicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import BD.ConnectionClass;

public class DAOMedicamentos implements IDAOMedicamentos {
	
	private final Connection c = ConnectionClass.getConnection();
	private final String TABLE = "Medicamento";
	private final String ID = "idMedicamento";
	
	public DAOMedicamentos() {

	}

	@Override
	public boolean anyadirDAOMedicamento(Medicamento m) {
		
		boolean ok = false;
		
		String stmnt = "INSERT INTO "+ TABLE +" VALUES(?, ?, ?, ?, ?, ?); ";  
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, GenerateRandom.getRandom());
			p.setLong(2, m.getIdVet());
			p.setString(3, m.getNombre());
			p.setString(4, m.getProspecto());
			p.setDate(5, m.getFechaCaducidad());
			p.setInt(6, m.getExistencias());
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {	}
		
		return ok;
	}



	@Override
	public boolean eliminarDAOMedicamento(Medicamento m) {
		boolean ok = false;
		
		String stmnt = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, m.getId());
			
			ok = p.executeUpdate() == 1;
		}
		catch (SQLException e) {}
		
		return ok;
	}
	
	

	@Override
	public boolean modificarDAOMedicamento(Medicamento m) {
		
		boolean ok = false;
		
		String stmnt = "UPDATE " + TABLE + " SET idVeterinaria = ?, "
				+ "nombre = ?, prospecto = ?, caducidad = ?, existencias = ? WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, m.getIdVet());
			p.setString(2, m.getNombre());
			p.setString(3, m.getProspecto());
			p.setDate(4, m.getFechaCaducidad());
			p.setInt(5, m.getExistencias());
			p.setLong(6, m.getId());
			
			ok = p.executeUpdate() == 1;
			
		} catch (SQLException e) {}
		
		return ok;
	}

	
	@Override
	public Medicamento buscarDAOMedicamento(long id) {
		
		Medicamento m = null;
		String stmt = "SELECT FROM " + TABLE + " * WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmt);
			p.setLong(1, id);
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) m = veterinariaBuilder(rs);
		} catch (SQLException | JSONException e) {}
		return m;
	}

	
	private Medicamento veterinariaBuilder(ResultSet rs) throws SQLException {
		
		long id = rs.getLong("idMedicamento");
		long idVet = rs.getLong("idVeterinaria");
		String nombre = rs.getString("nombre");
		String prospecto = rs.getString("prospecto");
		Date fecha = rs.getDate("caducidad");
		int exist = rs.getInt("existencias");
		
		Medicamento m = new Medicamento(id, idVet, nombre, prospecto, fecha, exist);
		
		return m;
	}

	@Override
	public void solicitudDeMedicamento(Medicamento m) {
		// TODO Auto-generated method stub
		
	}
	
	
	public List<Medicamento> listaMedicamentos(long idVeterinaria) {
		
		List<Medicamento> listM = new ArrayList<>();
		String stmt = "SELECT * FROM " + TABLE + " WHERE idVeterinaria = ?";
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmt);
			p.setLong(1, idVeterinaria);
			
			ResultSet r = p.executeQuery();
			while(r != null && r.next()) {
				listM.add(medicamentoBuilder(r));
			}
		} catch (SQLException e) {}
		
		return listM;
	}

	private Medicamento medicamentoBuilder(ResultSet r) throws SQLException {
		
		long id = r.getInt("idMedicamento");
		long idVet = r.getInt("idVeterinaria");
		String nombre = r.getString("nombre");
		String prospecto = r.getString("prospecto");
		Date fechaCaducidad = r.getDate("caducidad");
		int existencias = r.getInt("existencias");
		
		return new Medicamento(id, idVet, nombre, prospecto, fechaCaducidad, existencias);
	}

}
