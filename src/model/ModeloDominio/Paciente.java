package model.ModeloDominio;

import org.json.JSONObject;

public class Paciente {
	
	private long idPaciente;
    private String animal;
    private String raza;
    private String sexo;
    private int edad;
    private long idCliente;

    public Paciente(long idPaciente, String animal, String raza, String sexo, int edad) {
    	this.idPaciente = idPaciente;
    	this.animal = animal;
    	this.raza = raza;
    	this.sexo = sexo;
    	this.edad = edad;
    }
    
    public long getIdPaciente() {
        return this.idPaciente;
    }
    
    public String getAnimal() {
        return this.animal;
    }
    
    public String getRaza() {
        return this.raza;
    }
    
    public String getSexo() {
        return this.sexo;
    }

    public int getEdad() {
        return this.edad;
    }
    
    public long getidDuenyo() {
        return this.idCliente;
    }

    public void setAnimal(String value) {
        this.animal = value;
    }
 
    public void setRaza(String value) {
        this.raza = value;
    }
    
    public void setSexo(String value) {
        this.sexo = value;
    }

    public void setEdad(int value) {
        this.edad = value;
    }

    public void setduenyo(long value) {
        this.idCliente = value;
    }

	public JSONObject getInfo() {
		
		JSONObject jo = new JSONObject();
		jo.put("idPaciente", idPaciente);
		jo.put("animal", animal);
		jo.put("raza", raza);
		jo.put("sexo", sexo);
		jo.put("edad", edad);
		jo.put("idCliente", idCliente);
		
		return jo;
	}
}
