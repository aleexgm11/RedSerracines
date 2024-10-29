package model.ModeloDominio;

public enum TipoUsuario {
	
	VETERINARIO, CLIENTE, ADMINISTRADOR;
	
	@Override
	public String toString() {
		
		String name = null;
		
		switch (this) {
		case VETERINARIO: 
			name = "Veterinario";
			break;
		case CLIENTE:
			name = "Cliente";
			break;
		case ADMINISTRADOR:
			name = "Administrador";
			break;
		}
		
		return name;
	}
}
