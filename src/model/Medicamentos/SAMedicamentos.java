package model.Medicamentos;

import model.ModeloDominio.Medicamento;

public class SAMedicamentos implements ISAMedicamentos {
	
	private IDAOMedicamentos daoMedicamentos;
	
	public SAMedicamentos() {
		this.daoMedicamentos = new DAOMedicamentos();
		
	}

	@Override
	public boolean anyadirMedicamento(Medicamento m) {
		boolean ok = false;
		
		if(daoMedicamentos.buscarDAOMedicamento(m.getId()) == null)
			ok = daoMedicamentos.anyadirDAOMedicamento(m);
		
		return ok;
	}


	@Override
	public boolean eliminarMedicamento(Medicamento m) {
		boolean ok = false;
		
		if(daoMedicamentos.buscarDAOMedicamento(m.getId()) != null)
			ok = daoMedicamentos.anyadirDAOMedicamento(m);
		
		return ok;
	}


	@Override
	public boolean modificarMedicamento(Medicamento m) {
		boolean ok = false;
		
		if(daoMedicamentos.buscarDAOMedicamento(m.getId()) != null)
			ok = daoMedicamentos.anyadirDAOMedicamento(m);
		
		return ok;
	}


	@Override
	public Medicamento buscarMedicamento(long idMedicamento) {
		return daoMedicamentos.buscarDAOMedicamento(idMedicamento);
	}
	
	
}
