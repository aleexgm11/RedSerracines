package model.Citas;

import model.ModeloDominio.Cita;

public interface ISACitas {
	public boolean PedirCita(Cita c);
	public boolean EliminarCita(Cita c);
	public boolean ModificarCita(Cita c);
	public Cita ConsultarCita(long id);
}
