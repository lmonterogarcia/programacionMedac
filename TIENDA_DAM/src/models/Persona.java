package models;

import java.util.regex.Pattern;

public abstract class Persona implements IPersona {

	private String sDni; // PK
	private String sNombre, sApellidos; // NN
	private String sDireccion, sNumeroDireccion, sTelefono; // N
	private Usuario oUsuario; // FK

	public Persona(String sDni) {
		setsDni(sDni);
	}

	public Persona(String sDni, String sNombre, String sApellidos, Usuario oUsuario) {
		setsDni(sDni);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setoUsuario(oUsuario);
	}

	public Persona(String sDni, String sNombre, String sApellidos, String sDireccion, String sNumeroDireccion,
			String sTelefono, Usuario oUsuario) {
		setsDni(sDni);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setsDireccion(sDireccion);
		setsNumeroDireccion(sNumeroDireccion);
		setsTelefono(sTelefono);
		setoUsuario(oUsuario);
	}

	public String getsDni() {
		return sDni;
	}

	public void setsDni(String sDni) {
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		if (Pattern.matches(dniRegexp, sDni)) {
			this.sDni = sDni;
		}
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		if (sNombre != null && sNombre.length() < MAXCARACTERES) {
			this.sNombre = sNombre;
		}
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		if (sApellidos != null && sApellidos.length() < MAXCARACTERES) {
			this.sApellidos = sApellidos;
		}
	}

	public String getsDireccion() {
		return sDireccion;
	}

	public void setsDireccion(String sDireccion) {
		if (sDireccion != null && sDireccion.length() < MAXCARACTERES) {
			this.sDireccion = sDireccion;
		}
	}

	public String getsNumeroDireccion() {
		return sNumeroDireccion;
	}

	public void setsNumeroDireccion(String sNumeroDireccion) {
		if (sNumeroDireccion != null && sNumeroDireccion.length() < MAXCARACTERES) {
			this.sNumeroDireccion = sNumeroDireccion;
		}
	}

	public String getsTelefono() {
		return sTelefono;
	}

	public void setsTelefono(String sTelefono) {
		if(sTelefono != null && sTelefono.length() == 9 && sTelefono.matches("\\d+"))
		this.sTelefono = sTelefono;
	}
	
	public Usuario getoUsuario() {
		return oUsuario;
	}

	public void setoUsuario(Usuario oUsuario) {
		this.oUsuario = oUsuario;
	}

	public String toString() {
		String sResultado = "";
		if(checkPersona()) {
			sResultado += "Usuario: " + this.getoUsuario().toString() + "\n";
			sResultado += "DNI: " + this.getsDni() + "\n";
			sResultado += "Nombre: " + this.getsNombre() + " " + this.getsApellidos();
			
			if(this.getsDireccion() != null) {
				sResultado += "Direccion: " + this.getsDireccion() + "\n";
			}
			
			if(this.getsNumeroDireccion() != null) {
				sResultado += "Numero de la direccion: " + this.getsNumeroDireccion() + "\n";
			}
			
			if(this.getsTelefono() != null) {
				sResultado += "Telefono: " + this.getsTelefono() + "\n";
			}			
		}
		
		return sResultado;
	}
	
	public boolean checkPersona() {
		boolean bExito = false;
		if(this.getsDni() != null && this.getsNombre() != null && this.getsApellidos() != null && this.getoUsuario() != null && this.getoUsuario().checkUsuario()) {
			bExito = true;
		}
		return bExito;
	}	
}
