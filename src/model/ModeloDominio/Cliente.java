package model.ModeloDominio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Cliente extends Usuario{
	
    private List<Paciente> listMascotas;
	
	public Cliente(long id, long idVeterinaria, String nombre, String contrasenya, int telefono, String dni) {
		super(id, idVeterinaria, nombre, contrasenya, telefono, dni, TipoUsuario.CLIENTE);
		this.listMascotas = new ArrayList<Paciente> ();
	}
	
    public List<Paciente> getListMascotas() {
        return this.listMascotas;
    }

    public void setListMascotas(List<Paciente> value) {
        this.listMascotas = value;
    }

	@Override
	public JSONObject getSpecificAtt() {
		return null;
	}
}
