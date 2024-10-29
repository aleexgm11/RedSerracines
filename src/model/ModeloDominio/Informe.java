package model.ModeloDominio;

public class Informe {
	
	private final long idInforme;
    private String contenido;
    private long cliente;

    public Informe(long id, String contenido, long cliente) {
    	this.idInforme = id;
    	this.contenido = contenido;
    	this.cliente = cliente;
    }
    
    public long getIdInforme() {
        return this.idInforme;
    }
    
    public String getContenido() {
        return this.contenido;
    }
    
    public long getduenyo() {
    	return this.cliente;
    }

    public void setContenido(String value) {
        this.contenido = value;
    }
    
    public void setduenyo(long value) {
    	this.cliente = value;
    }
    
}
