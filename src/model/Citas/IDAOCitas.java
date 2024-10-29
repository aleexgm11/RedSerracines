package model.Citas;

import model.ModeloDominio.Cita;

public interface IDAOCitas {
	public boolean anyadirDAOCita(Cita c );
	public boolean eliminarDAOCita(Cita c );
	public Cita buscarDAOCita(long id);
	public boolean modificarDAOCita(Cita c );
}
