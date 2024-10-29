package model.Medicamentos;

import model.ModeloDominio.Medicamento;

public interface ISAMedicamentos {
	
	public boolean anyadirMedicamento(Medicamento m);
	public boolean eliminarMedicamento(Medicamento m);
	public boolean modificarMedicamento(Medicamento m);
	public Medicamento buscarMedicamento(long idMedicamento);
	
}
