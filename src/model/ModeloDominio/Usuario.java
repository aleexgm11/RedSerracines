package model.ModeloDominio;

import org.json.JSONObject;

public abstract class Usuario {
	
	protected long id;
	protected long idVeterinaria;
    protected String nombre;
    protected String contrasenya;
    protected int telefono;
    protected String dni;
    protected TipoUsuario tipo;

    public Usuario(long id, long idVeterinaria, String nombre, String contrasenya, int telefono, String dni, TipoUsuario tipo) {
    	this.id = id;
    	this.idVeterinaria = idVeterinaria;
    	this.nombre = nombre;
    	this.contrasenya = contrasenya;
    	this.telefono = telefono;
    	this.dni = dni;
    	this.tipo = tipo;
    }
    
    public long getId() {
        return this.id;
    }
    
    public long getIdVet() {
    	return this.idVeterinaria;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getContrasenya() {
        return this.contrasenya;
    }
    
    public int getTelefono() {
        return this.telefono;
    }
    
    public String getDni() {
        return this.dni;
    }
    
    public String getTipo() {
    	return tipo.toString();
    }
    
    public void setNombre(String value) {
        this.nombre = value;
    }
    
    public void setContrasenya(String value) {
        this.contrasenya = value;
    }

    public void setTelefono(int value) {
        this.telefono = value;
    }

    public void setDni(String value) {
        this.dni = value;
    }

	public abstract JSONObject getSpecificAtt();
    
}
