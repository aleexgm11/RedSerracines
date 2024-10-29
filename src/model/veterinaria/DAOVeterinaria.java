package model.veterinaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import BD.ConnectionClass;
import model.Citas.DAOCitas;
import model.Medicamentos.DAOMedicamentos;
import model.ModeloDominio.GenerateRandom;
import model.ModeloDominio.Veterinaria;
import model.usuario.DAOUsuario;

public class DAOVeterinaria implements IDAOVeterinaria {
	
	private final Connection c = ConnectionClass.getConnection();
	private final String TABLE = "Veterinaria";
	private final String ID = "idVeterinaria";
	DAOUsuario daoU;
	DAOMedicamentos daoM;
	DAOCitas daoC;
	
	public DAOVeterinaria() {
		daoU = new DAOUsuario();
		daoM = new DAOMedicamentos();
		daoC = new DAOCitas();
	}
	
	@Override
	public boolean anyadirDAOVeterinaria(Veterinaria v) {
		
		boolean ok = false;
		
		String stmnt = "INSERT INTO "+ TABLE +" VALUES(?, ?, ?, ?, ?); ";  
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, GenerateRandom.getRandom());
			p.setString(2, v.getNombre());
			p.setString(3, v.getDireccion());
			p.setString(4, v.getEmail());
			p.setInt(5, v.getTelefono());
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {	}
		
		return ok;
	}

	@Override
	public boolean eliminarDAOVeterinaria(Veterinaria v) {
		
		boolean ok = false;
		
		String stmnt = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, v.getId());
			
			ok = p.executeUpdate() == 1;
		}
		catch (SQLException e) {}
		
		return ok;
	}

	@Override
	public Veterinaria buscarDAOVeterinaria(long id) {

		Veterinaria v = null;
		String stmt = "SELECT * FROM " + TABLE + " WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmt);
			p.setLong(1, id);
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) v = veterinariaBuilder(rs);
		} catch (SQLException | JSONException e) {}
		return v;
	}

	@Override
	public boolean modificarDAOVeterinaria(Veterinaria v) {
		
		boolean ok = false;
		
		String stmnt = "UPDATE " + TABLE + " SET nombre = ?, "
				+ "direccion = ?, email = ?, telefono = ? WHERE " + ID + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setString(1, v.getNombre());
			p.setString(2, v.getDireccion());
			p.setString(3, v.getEmail());
			p.setInt(4, v.getTelefono());
			p.setLong(5, v.getId());
			
			ok = p.executeUpdate() == 1;
			
		} catch (SQLException e) {}
		
		return ok;
	}
	
	private Veterinaria veterinariaBuilder(ResultSet rs) throws SQLException {
		
		String nombre = rs.getString("nombre");
		long id = rs.getInt("idVeterinaria");
		String direccion = rs.getString("direccion");
		String telefono = rs.getString("telefono");
		String email = rs.getString("email");
		
		Veterinaria v = new Veterinaria(id, nombre, direccion, email, Integer.parseInt(telefono));
		
		v.setListUsuario(daoU.listaUsuarios(id));
		v.setListMedicamentos(daoM.listaMedicamentos(id));
		v.setListCitas(daoC.listaCitas(id));
		
		return v;
	}

	@Override
	public List<String> getInfo() {
		
		List<String> vetList = new ArrayList<>();
		String stmt = "SELECT * FROM " + TABLE;
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmt);
			
			ResultSet s = p.executeQuery();
	        while (s != null && s.next()) {
	            vetList.add(s.getString("nombre"));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vetList;
	}

	@Override
	public long buscarVeterinaria(String vet) {
		long v = -1;
		String stmt = "SELECT * FROM " + TABLE + " WHERE nombre = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmt);
			p.setString(1, vet);
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) v = veterinariaBuilder(rs).getId();
		} catch (SQLException | JSONException e) {}
		return v;
	}	
}
