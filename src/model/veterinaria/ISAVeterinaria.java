package model.veterinaria;

import java.util.List;

import model.ModeloDominio.Veterinaria;

public interface ISAVeterinaria {
	
	public boolean anyadirVeterinaria(Veterinaria v);
	public boolean eliminarVeterinaria(Veterinaria v);
	public Veterinaria buscarVeterinaria(long id);
	public boolean modificarVeterinaria(Veterinaria v) throws Exception;
	public String[] getInfo();
	public long buscarVeterinaria(String vet);
	
}
