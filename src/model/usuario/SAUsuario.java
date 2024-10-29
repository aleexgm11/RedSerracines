package model.usuario;

import model.ModeloDominio.Paciente;
import model.ModeloDominio.Usuario;

public class SAUsuario implements ISAUsuario{
	
	private IDAOUsuario daoUsuario;
	
	public SAUsuario() {
		daoUsuario = new DAOUsuario();
	}

	@Override
	public boolean altaUsuario(Usuario usuario) {
		if (daoUsuario.buscarDAOUsuario(usuario.getDni()) == null)
			return daoUsuario.altaDAOUsuario(usuario);
		
		return false;
	}

	@Override
	public boolean bajaUsuario(Usuario usuario) {
		if (daoUsuario.buscarDAOUsuario(usuario.getDni()) != null)
			return daoUsuario.bajaDAOUsuario(usuario);
		
		return false;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) throws Exception {
		try{
			if (daoUsuario.buscarDAOUsuario(usuario.getDni()) != null)
				return daoUsuario.modificarDAOUsuario(usuario);
			else
				throw new Exception("Usuario no encontrado");
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Usuario buscarUsuario(String dni) {
		return daoUsuario.buscarDAOUsuario(dni);
		
	}

	@Override
	public boolean anyadirMascotaUsuario(Usuario usuario, Paciente paciente) {
		if (daoUsuario.buscarDAOUsuario(usuario.getDni()) != null)
			return daoUsuario.anyadirMascotaDAOUsuario(usuario, paciente);
		
		return false;
	}

}
