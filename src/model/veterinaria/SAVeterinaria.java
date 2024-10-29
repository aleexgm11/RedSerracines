package model.veterinaria;

import java.util.List;

import model.ModeloDominio.Veterinaria;

public class SAVeterinaria implements ISAVeterinaria{
	
	private IDAOVeterinaria daoVeterinaria;
	
	public SAVeterinaria() {
		this.daoVeterinaria = new DAOVeterinaria();
	}
	
	@Override
	public boolean anyadirVeterinaria(Veterinaria v) {
		//  Auto-generated method stub
		boolean exito = false;
		
		if(daoVeterinaria.buscarDAOVeterinaria(v.getId()) == null)
			exito = daoVeterinaria.anyadirDAOVeterinaria(v);
		
		return exito;
	}

	@Override
	public boolean eliminarVeterinaria(Veterinaria v) {
		//  Auto-generated method stub
		boolean exito = false;
		
		if(daoVeterinaria.buscarDAOVeterinaria(v.getId()) != null)
			exito = daoVeterinaria.eliminarDAOVeterinaria(v);
		
		return exito;
	}

	@Override
	public Veterinaria buscarVeterinaria(long id) {
		return daoVeterinaria.buscarDAOVeterinaria(id);
	}

	@Override
	public boolean modificarVeterinaria(Veterinaria v) throws Exception {
		boolean ok = false;
			
		if(daoVeterinaria.buscarDAOVeterinaria(v.getId()) != null)
			ok = daoVeterinaria.modificarDAOVeterinaria(v);
	
		return ok;
		
	}

	@Override
	public String[] getInfo() {
		
		List<String> v = daoVeterinaria.getInfo();
		String[] resul = new String[v.size()];
		for(int i = 0; i < v.size(); i++)
			resul[i] = v.get(i);
		
		return resul;
	}

	@Override
	public long buscarVeterinaria(String vet) {
		return daoVeterinaria.buscarVeterinaria(vet);
	}

}
