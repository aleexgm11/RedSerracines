package controller;

import java.util.List;

import model.Citas.ISACitas;
import model.Citas.SACitas;
import model.Medicamentos.ISAMedicamentos;
import model.Medicamentos.SAMedicamentos;
import model.ModeloDominio.Cita;
import model.ModeloDominio.Medicamento;
import model.ModeloDominio.Paciente;
import model.ModeloDominio.Usuario;
import model.ModeloDominio.Veterinaria;
import model.usuario.ISAUsuario;
import model.usuario.SAUsuario;
import model.veterinaria.ISAVeterinaria;
import model.veterinaria.SAVeterinaria;

public class Controller {
	private ISAUsuario iU;
	private ISAMedicamentos iM;
	private ISAVeterinaria iV;
	private ISACitas iC;
	
	public Controller() {
		iU = new SAUsuario();
		iM = new SAMedicamentos();
		iV = new SAVeterinaria();
		iC = new SACitas();
	}
	
	public boolean altaUsuario(Usuario usuario) {
		return iU.altaUsuario(usuario);
	}
	
	public boolean bajaUsuario(Usuario usuario) {
		return iU.bajaUsuario(usuario);
		
	}
	
	public boolean modificarUsuario(Usuario usuario) throws Exception {
		return iU.modificarUsuario(usuario);
	}
	
	public Usuario buscarUsuario(String dni){
		return iU.buscarUsuario(dni);
	}
	
	public boolean anyadirMascotaUsuario(Usuario usuario, Paciente paciente) {
		return iU.anyadirMascotaUsuario(usuario, paciente);
	}
	
	public boolean anyadirVeterinaria(Veterinaria v) {
		return iV.anyadirVeterinaria(v);
	}
	
	public boolean eliminarVeterinaria(Veterinaria v) {
		return iV.eliminarVeterinaria(v);
	}
	
	public Veterinaria buscarVeterinaria(long id) {
		return iV.buscarVeterinaria(id);
	}
	
	public boolean modificarVeterinaria(Veterinaria v) throws Exception{
		return iV.modificarVeterinaria(v);
	}
	
	public boolean PedirCita(Cita c) {
		return iC.PedirCita(c);
	}
	
	public boolean EliminarCita(Cita c) {
		return iC.EliminarCita(c);
	}
	
	public boolean ModificarCita(Cita c) {
		return iC.ModificarCita(c);
	}
	
	public Cita ConsultarCita(long id) {
		return iC.ConsultarCita(id);
	}
	
	public boolean anyadirNuevoMedicamento(Medicamento m) {
		return iM.anyadirMedicamento(m);
	}
	
	public boolean eliminarMedicamento(Medicamento m) {
		return iM.eliminarMedicamento(m);
	}
	
	public Medicamento buscarMedicamento(long idMedicamento) {
		return iM.buscarMedicamento(idMedicamento);
	}

	public String[] getVeterinariasInfo() {
		return iV.getInfo();
	}

	public long buscarVeterinaria(String vet) {
		return iV.buscarVeterinaria(vet);
	}
	
	
}