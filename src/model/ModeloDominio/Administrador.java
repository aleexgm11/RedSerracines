package model.ModeloDominio;

import org.json.JSONObject;

public class Administrador extends Usuario{
	
	private int numAdmin;
	
	public Administrador(long id, long idVeterinaria, String nombre, String contrasenya, int telefono, String dni, int numAdmin) {
		super(id, idVeterinaria, nombre, contrasenya, telefono, dni, TipoUsuario.ADMINISTRADOR);
		this.numAdmin = numAdmin;

	}

    int getNumUsuario() {
        return this.numAdmin;
    }

    void setNumUsuario(int value) {
        this.numAdmin = value;
    }
    
    @Override
    public JSONObject getSpecificAtt() {
    	
    	JSONObject jo = new JSONObject();
    	
    	jo.put("numAdmin", this.numAdmin);
    	
    	return jo;
    }
}
