package model.ModeloDominio;

import org.json.JSONObject;

public class Cita {

	private long id;
    private java.sql.Date fecha;
    private long idVeterinaria;
    private long idVeterinario;
    private long idCliente;
    private long idMedicamento;
    private long idInforme;
    
    public Cita(long id, java.sql.Date fecha, long idVeterinaria, long idVeterinario, long idCliente, long idMedicamento, long idInforme) {
    	this.id = id;
    	this.fecha = fecha;
    	this.idVeterinaria = idVeterinaria;
    	this.idVeterinario = idVeterinario;
    	this.idCliente = idCliente;
    	this.idMedicamento = idMedicamento;
    	this.idInforme = idInforme;
    }
    
    public long getId() {
        return this.id;
    }

    public java.sql.Date getFecha() {
        return this.fecha;
    }

    public long getInforme() {
        return this.idInforme;
    }
    
    public long getVeterinaria() {
    	return this.idVeterinaria;
    }
    
    public long getVeterinario() {
    	return this.idVeterinario;
    }
    
    public long getCliente() {
    	return this.idCliente;
    }
    
    public long getMedicamentos(){
    	return this.idMedicamento;
    }
    
    public void setId(long value) {
        this.id = value;
    }
    
    public void setInforme(long value) {
        this.idInforme = value;
    }
	
    public void setFecha(java.sql.Date value) {
        this.fecha = value;
    }
    
    public void setVeterinario(long value) {
    	this.idVeterinario = value;
    }
    
    public void setCliente(long value) {
    	this.idCliente = value;
    }
    
    public void setMedicameto(long value) {
        this.idMedicamento = value;
    }

	public JSONObject getInfo() {
		JSONObject JCita= new JSONObject();
		JCita.put("Id", this.id);
		JCita.put("Fecha", this.fecha);
		JCita.put("Veterinario", this.idVeterinario);
		JCita.put("Id Dueño", this.idCliente);
		JCita.put("Id Medicamento", this.idMedicamento);
		JCita.put("Informe", this.idInforme);
		
		return JCita;
	}
}
