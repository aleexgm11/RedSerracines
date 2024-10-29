package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import BD.ConnectionClass;
import model.ModeloDominio.*;

public class DAOUsuario implements IDAOUsuario{
	
	private final Connection c = ConnectionClass.getConnection();
	private final String ID = "id";

	@Override
	public boolean altaDAOUsuario(Usuario u) {
		
		boolean ok = false;
		String stmnt = "INSERT INTO "+ u.getTipo() +" VALUES(?, ?, ?, ?, ?, ?";
		
		if(u.getTipo().equalsIgnoreCase("Veterinario")) {
			stmnt += ", ?, ?, ?";
		}
		
		else if(u.getTipo().equalsIgnoreCase("Administrador")) {
			stmnt += ", ?";
		}
		
		stmnt += ")";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, GenerateRandom.getRandom());
			p.setLong(2, u.getIdVet());
			p.setString(3, u.getDni());
			p.setString(4, u.getNombre());
			p.setInt(5, u.getTelefono());
			p.setString(6, u.getContrasenya());
			
			if(u.getTipo().equalsIgnoreCase("Veterinario")) {
				JSONObject jo = u.getSpecificAtt();
				p.setLong(7, jo.getInt("licencia"));
				p.setString(8, jo.getString("especialidad"));
				p.setInt(9, jo.getInt("consulta"));
			}
			
			else if(u.getTipo().equalsIgnoreCase("Administrador")) {
				JSONObject jo = u.getSpecificAtt();
				p.setInt(7,jo.getInt("numAdmin"));
			}
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {	}
		
		return ok;
	}

	@Override
	public boolean bajaDAOUsuario(Usuario u) {
		
		boolean ok = false;
		String stmt = "DELETE FROM " + u.getTipo() + " WHERE " + ID + u.getTipo() + " = ?;";
		
		try {
			PreparedStatement p = this.c.prepareStatement(stmt);
			p.setLong(1, u.getId());
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {}
		
		return ok;
	}

	@Override
	public boolean modificarDAOUsuario(Usuario u) {
		
		boolean ok = false;
		String stmnt = "UPDATE " + u.getTipo() + " SET idVeterinaria = ?, "
				+ "dni = ?, nombre = ?, telefono = ?, contrasena = ?";  
		
		if(u.getTipo().equalsIgnoreCase("Veterinario")) {
			stmnt += ", licencia = ?, especialidad = ?, consulta = ?";
		}
		
		else if(u.getTipo().equalsIgnoreCase("Administrador")) {
			stmnt += ", numAdmin = ?";
		}
		
		stmnt += " WHERE " + ID + u.getTipo() + " = ?";
		
		try {
			PreparedStatement p = c.prepareStatement(stmnt);
			p.setLong(1, u.getIdVet());
			p.setString(2, u.getDni());
			p.setString(3, u.getNombre());
			p.setInt(4, u.getTelefono());
			p.setString(5, u.getContrasenya());
			
			if(u.getTipo().equalsIgnoreCase("Veterinario")) {
				JSONObject jo = u.getSpecificAtt();
				p.setLong(6, jo.getInt("licencia"));
				p.setString(7, jo.getString("especialidad"));
				p.setInt(8, jo.getInt("consulta"));
				p.setLong(9, u.getId());
				
			}
			
			else if(u.getTipo().equalsIgnoreCase("Administrador")) {
				JSONObject jo = u.getSpecificAtt();
				p.setInt(6,jo.getInt("numAdmin"));
				p.setLong(7, u.getId());

			}
			
			else
				p.setLong(6, u.getId());
			
			ok = p.executeUpdate() == 1;
		} catch (SQLException e) {	}
		
		return ok;
	}

	@Override
	public Usuario buscarDAOUsuario(String dni) {
		
		Usuario u = null;
		
		for(TipoUsuario tp : TipoUsuario.values()) {
			
			String stmt = "SELECT * FROM " + tp.toString() + " WHERE dni = ?;";
			
			try {
				PreparedStatement p = c.prepareStatement(stmt);
				p.setString(1, dni);
				
				ResultSet rs = p.executeQuery();
				
				if (rs.next()) u = usuarioBuilder(rs, tp.toString());
			} catch (SQLException | JSONException e) {}
		}
		
		return u;	
	}

	@Override
	public boolean anyadirMascotaDAOUsuario(Usuario u, Paciente p) {
		
		boolean ok = false;
		p.setduenyo(u.getId());
		
		String stmt = "INSERT INTO Paciente VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = this.c.prepareStatement(stmt);
			ps.setLong(1, p.getIdPaciente());
			ps.setString(2, p.getAnimal());
			ps.setString(3, p.getRaza());
			ps.setString(4, p.getSexo());
			ps.setInt(5, p.getEdad());
			ps.setLong(6, p.getidDuenyo());
			
			ok = ps.executeUpdate() == 1;
		} catch (SQLException e) {}
		
		return ok;
	}
	
	public List<Usuario> listaUsuarios(long idVeterinaria) {
		
		List<Usuario> userList = new ArrayList<>();
		
		for(TipoUsuario u : TipoUsuario.values()) {
			
			String stmt = "SELECT * FROM " + u.toString() + " WHERE idVeterinaria = ?";
			
			try {
				PreparedStatement p = this.c.prepareStatement(stmt);
				p.setLong(1, idVeterinaria);
				
				ResultSet s = p.executeQuery();
				while(s != null && s.next()) {
					userList.add(usuarioBuilder(s,u.toString()));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}
	

	private Usuario usuarioBuilder(ResultSet u, String tipo) throws SQLException {
		Usuario user = null;
		long id = u.getLong("id"+tipo.toString());
		long idVet = u.getLong("idVeterinaria");
		String nombre = u.getString("nombre");
		String contrasenya = u.getString("contrasena");
		int telefono = u.getInt("telefono");
		String dni = u.getString("dni");
		
		switch (tipo) {
		case "Cliente":
			user = new Cliente(id, idVet, nombre, contrasenya, telefono, dni);

			break;
			
		case "Administrador":
			int numUsuario = u.getInt("numUsuario");
			user = new Administrador(id, idVet, nombre, contrasenya, telefono, dni, numUsuario);

			break;
			
		case "Veterinario":
			long licencia = u.getLong("licencia");
			int consulta = u.getInt("consulta");
			String especialidad = u.getString("especialidad");
			
			user = new Veterinario(id, idVet, nombre, contrasenya, telefono, dni, licencia, consulta, especialidad);
			
			break;
			
		default: break;
		}
		
		return user;
	}
}
