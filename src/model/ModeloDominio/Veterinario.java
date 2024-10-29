package model.ModeloDominio;

import org.json.JSONObject;

public class Veterinario extends Usuario{

	private long licencia;
    private int consulta;
    private long idVeterinaria;
    private String especialidad;
    
	public Veterinario(long id, long idVeterinaria, String nombre, String contrasenya, int telefono, String dni, long licencia, int consulta, String especialidad) {
		super(id, idVeterinaria, nombre, contrasenya, telefono, dni, TipoUsuario.VETERINARIO);
		this.licencia = licencia;
		this.consulta = consulta;
		this.especialidad = especialidad;
	}
    
    long getLicencia() {
        return this.licencia;
    }

    void setLicencia(long value) {
        this.licencia = value;
    }

    int getConsulta() {
        return this.consulta;
    }

    void setConsulta(int value) {
        this.consulta = value;
    }

    String getEspecialidad() {
        return this.especialidad;
    }

    void setEspecialidad(String value) {
        this.especialidad = value;
    }
    
    @Override
    public JSONObject getSpecificAtt() {
    	
    	JSONObject jo = new JSONObject();
    	
    	jo.put("licencia", this.licencia);
    	jo.put("especialidad", this.especialidad);
    	jo.put("consulta", this.consulta);
    	
    	return jo;
    }
    
}
