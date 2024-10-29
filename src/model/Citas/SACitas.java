package model.Citas;

import model.ModeloDominio.Cita;

public class SACitas implements ISACitas{
	
	private IDAOCitas daocitas;
	
	public SACitas() {
		daocitas = new DAOCitas();	
	}
	
	@Override
	public boolean PedirCita(Cita c) {
		
		boolean acierto = false;
		
		if (ConsultarCita(c.getId()) == null) {
			acierto = daocitas.anyadirDAOCita(c);
		}
		
		return acierto;
	}

	@Override
	public boolean EliminarCita(Cita c) {
		boolean acierto=false;
		// TODO Auto-generated method stub
		if(ConsultarCita(c.getId())!=null) {
			acierto=daocitas.eliminarDAOCita(c);
		}
		
		return acierto;
	}

	@Override
	public boolean ModificarCita(Cita c) {
		boolean acierto = false;
		// TODO Auto-generated method stub
		if(ConsultarCita(c.getId())!=null) {
			acierto=daocitas.modificarDAOCita(c);
		}
		
		return acierto;
	}

	@Override
	public Cita ConsultarCita(long id) {
		
		return daocitas.buscarDAOCita(id);
		// TODO Auto-generated method stub
		
	}

}
