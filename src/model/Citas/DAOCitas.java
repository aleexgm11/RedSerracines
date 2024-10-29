package model.Citas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import BD.ConnectionClass;
import model.ModeloDominio.Cita;
import model.usuario.DAOUsuario;


public class DAOCitas implements IDAOCitas{
	
	private final Connection c = ConnectionClass.getConnection();
	private final String TABLE = "Cita";
	private final String ID = "idCita";
	DAOUsuario daoU;
	
	public DAOCitas(){
	}

	@Override
	public boolean anyadirDAOCita(Cita c) {
		
boolean ok = false;
		
		String stmnt = "INSERT INTO "+ TABLE +" VALUES(?, ?, ?, ?, ?, ?, ?); ";  
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmnt);
			p.setLong(1, c.getId());
			p.setLong(2, c.getVeterinaria());
			p.setLong(3, c.getVeterinario());
			p.setLong(4, c.getCliente());
			p.setLong(5, c.getMedicamentos());
			p.setLong(6, c.getInforme());
			p.setDate(7, c.getFecha());
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {	}
		
		return ok;
	}

	@Override
	public boolean eliminarDAOCita(Cita c) {
		
		boolean ok = false;
		
		String stmnt = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmnt);
			p.setLong(1, c.getId());
			
			ok = p.executeUpdate() == 1;
		}
		catch (SQLException e) {}
		
		return ok;
	}

	@Override
	public Cita buscarDAOCita(long id) {
		
		Cita c = null;
		String stmt = "SELECT FROM " + TABLE + " * WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmt);
			p.setLong(1, id);
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) c = citaBuilder(rs);
		} catch (SQLException | JSONException e) {}
		
		return c;
	}

	@Override
	public boolean modificarDAOCita(Cita c) {
		
		boolean ok = false;
		
		String stmnt = "UPDATE " + TABLE + " SET idVeterinaria = ?, "
				+ "idVeterinario = ?, idCliente = ?, idMedicamento = ?, "
				+ "idInforme = ?, fecha = ? WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmnt);
			p.setLong(1, c.getVeterinaria());
			p.setLong(2, c.getVeterinario());
			p.setLong(3, c.getCliente());
			p.setLong(4, c.getMedicamentos());
			p.setLong(5, c.getInforme());
			p.setDate(6, c.getFecha());
			p.setLong(7, c.getId());
			
			ok = p.executeUpdate() == 1;
			
		} catch (SQLException e) {}
		
		return ok;
	}
	
	private Cita citaBuilder(ResultSet r) throws SQLException {
		
		long id = r.getLong("idCita");
		Date fecha = r.getDate("fecha");
		long idClinVet = r.getLong("idVeterinaria");
		long idVet = r.getLong("idVeterinario");
		long idCli = r.getLong("idCliente");
		long idMed = r.getLong("idMedicamento");
		long idInf = r.getLong("idInforme");
		
		return new Cita(id, fecha, idClinVet, idVet, idCli, idMed, idInf);
	}

	public List<Cita> listaCitas(long idVeterinaria){
		
		List<Cita> listC = new ArrayList<>();
		String stmt = "SELECT * FROM " + TABLE + " WHERE idVeterinaria = ?";
		try {
			PreparedStatement p = this.c.prepareStatement(stmt);
			p.setLong(1, idVeterinaria);
			
			ResultSet r = p.executeQuery();
			while(r != null && r.next()) {
				listC.add(citaBuilder(r));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listC;
	}

}
