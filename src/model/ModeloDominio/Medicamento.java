package model.ModeloDominio;

public class Medicamento {
	
	private long idMedicamento;
	private long idVeterinaria;
    private String nombre;
    private String prospecto;
    private java.sql.Date fechaCaducidad;
    private int existencias;
    
    public Medicamento(long id, long idVeterinaria, String nombre, String prospecto, java.sql.Date fechaCaducidad, int existencias) {
    	
    	this.idMedicamento = id;
    	this.idVeterinaria = idVeterinaria;
    	this.nombre = nombre;
    	this.prospecto = prospecto;
    	this.fechaCaducidad = fechaCaducidad;
    	this.existencias = existencias;
    }
    
    public long getId() {
        return this.idMedicamento;
    }
    
    public long getIdVet() {
    	return this.idVeterinaria;
    }
    
    public String getNombre() {
    	return this.nombre;
    }
    
    public String getProspecto() {
    	return this.prospecto;
    }
    
    public java.sql.Date getFechaCaducidad() {
    	return this.fechaCaducidad;
    }
    
    public int getExistencias() {
    	return this.existencias;
    }
    
    public void setNombre(String value) {
        this.nombre = value;
    }
    
    public void setProspecto(String value) {
        this.prospecto = value;
    }
    
    public void setFechaCaducidad(java.sql.Date value) {
        this.fechaCaducidad = value;
    }
    
    public void setExistencias(int value) {
    	this.existencias = value;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
