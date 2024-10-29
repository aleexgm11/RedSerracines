package model.veterinaria;

import java.util.List;

import model.ModeloDominio.Veterinaria;

public interface IDAOVeterinaria {
	
	public boolean anyadirDAOVeterinaria(Veterinaria v);
	public boolean eliminarDAOVeterinaria(Veterinaria v);
	public Veterinaria buscarDAOVeterinaria(long id);
	public boolean modificarDAOVeterinaria(Veterinaria v);
	public List<String> getInfo();
	public long buscarVeterinaria(String vet);
	
}
