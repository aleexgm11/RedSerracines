package model.usuario;

import model.ModeloDominio.Paciente;
import model.ModeloDominio.Usuario;

public interface IDAOUsuario {
	public boolean altaDAOUsuario(Usuario usuario);
	public boolean bajaDAOUsuario(Usuario usuario);
	public boolean modificarDAOUsuario(Usuario usuario);
	public Usuario buscarDAOUsuario(String dni);
	public boolean anyadirMascotaDAOUsuario(Usuario usuario, Paciente paciente);
}
