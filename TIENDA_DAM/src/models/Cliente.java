package models;

import java.util.regex.Pattern;

public class Cliente extends Persona implements ICliente {
	
	private String sTarjeta;
	
	public Cliente(String sDni) {
		super(sDni);
	}
	
	public Cliente(String sDni, String sNombre, String sApellidos, Usuario oUsuario) {
		super(sDni,sNombre,sApellidos,oUsuario);
	}
	
	public Cliente(String sDni, String sNombre, String sApellidos, String sDireccion, String sNumeroDireccion,
			String sTelefono, Usuario oUsuario, String sTarjeta) {
		super(sDni,sNombre,sApellidos,sDireccion,sNumeroDireccion,sTelefono,oUsuario);
		setsTarjeta(sTarjeta);
	}	

	public String getsTarjeta() {
		return sTarjeta;
	}

	public void setsTarjeta(String sTarjeta) {
		String sTarjetaRegexp = "\\d{16}";
		if (Pattern.matches(sTarjetaRegexp, sTarjeta)) {
			this.sTarjeta = sTarjeta;
		}
	}
	
	public String toString() {
		String sResultado = "";
		
		if(super.checkPersona()) {
			sResultado += super.toString();
			
			if(this.getsTarjeta() != null) {
				sResultado += "Tarjeta de credito: " + this.getsTarjeta() + "\n";
			}			
		}
		
		return sResultado;
	}
	
	public boolean checkCliente() {
		return super.checkPersona();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
