package model.usuario;

import model.ModeloDominio.Paciente;
import model.ModeloDominio.Usuario;

public interface ISAUsuario {
	public boolean altaUsuario(Usuario usuario);
	public boolean bajaUsuario(Usuario usuario);
	public boolean modificarUsuario(Usuario usuario) throws Exception;
	public Usuario buscarUsuario(String dni);
	public boolean anyadirMascotaUsuario(Usuario usuario, Paciente paciente);

}
