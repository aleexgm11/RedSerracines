package model.Medicamentos;

import model.ModeloDominio.Medicamento;

public interface IDAOMedicamentos {
	
	public boolean anyadirDAOMedicamento(Medicamento m);
	public boolean eliminarDAOMedicamento(Medicamento m);
	public boolean modificarDAOMedicamento(Medicamento m);
	public Medicamento buscarDAOMedicamento(long id);
	public void solicitudDeMedicamento(Medicamento m);

}
