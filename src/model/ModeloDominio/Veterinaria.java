package model.ModeloDominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public class Veterinaria {
	
	    private long id;
	    private String nombre;
	    private String direccion;
	    private String email;
	    private int telefono;
	    private List<Usuario> listUsuario; 
	    private List<Medicamento> listMedicamentos;
	    private List<Cita> listCitas;
	    
	    public Veterinaria(long id, String nombre, String direccion, String email, int telefono) {
	    	this.id = id;
	    	this.nombre = nombre;
	    	this.direccion = direccion;
	    	this.email = email;
	    	this.telefono = telefono;
	    	this.listCitas = new ArrayList<Cita> ();
	    	this.listMedicamentos = new ArrayList<Medicamento> ();
	    	this.listUsuario = new ArrayList<Usuario> ();
	    }
	    
	    public long getId() {
	        return this.id;
	    }

	    public String getNombre() {
	        return this.nombre;
	    }

	    public String getDireccion() {
	        return this.direccion;
	    }
	    
	    public String getEmail() {
	        return this.email;
	    }
	    
	    public int getTelefono() {
	        return this.telefono;
	    }
	    
	    public List<Medicamento> getListMedicamentos() {
	        return Collections.unmodifiableList(this.listMedicamentos);
	    }

	    
	    public List<Cita> getListCitas() {
	        return Collections.unmodifiableList(this.listCitas);
	    }

	    public List<Usuario> getListUsuario(){
	    	return Collections.unmodifiableList(this.listUsuario);
	    }
	    
	    public void setEmail(String value) {
	        this.email = value;
	    }

	    public void setTelefono(int value) {
	        this.telefono = value;
	    }
	    
	    public void setDireccion(String value) {
	    	this.direccion = value;
	    }
	    
	    public void setNombre(String value) {
	    	this.nombre = value;
	    }
	    
	    public void setListMedicamentos(List<Medicamento> value) {
	        this.listMedicamentos = value;
	    }
	    
	    public void setListCitas(List<Cita> value) {
	        this.listCitas = value;
	    }
	    
	    public void setListUsuario(List<Usuario> value) {
	    	this.listUsuario = value;
	    }
	    
	    public JSONObject getInfo() {
	    	JSONObject jo = new JSONObject();
	    	jo.put("id", id);
	    	jo.put("nombre", nombre);
	    	jo.put("telefono", telefono);
	    	jo.put("email", email);
	    	jo.put("direccion", direccion);
	    	jo.put("citas", listCitas);
	    	jo.put("usuarios", listUsuario);
	    	jo.put("medicamentos", listMedicamentos);
	    	
			return jo;
	    }
}
