package models;

import java.util.regex.Pattern;

public class Empleado extends Persona implements IEmpleado {
	
	private String sSegSocial;
	
	public Empleado(String sDni) {
		super(sDni);
	}
	
	public Empleado(String sDni, String sNombre, String sApellidos, Usuario oUsuario) {
		super(sDni,sNombre,sApellidos,oUsuario);
	}
	
	public Empleado(String sDni, String sNombre, String sApellidos, String sDireccion, String sNumeroDireccion,
			String sTelefono, Usuario oUsuario, String sSegSocial) {
		super(sDni,sNombre,sApellidos,sDireccion,sNumeroDireccion,sTelefono,oUsuario);
		setsSegSocial(sSegSocial);
	}	

	public String getsSegSocial() {
		return sSegSocial;
	}

	public void setsSegSocial(String sSegSocial) {
		String sSegSocialRegexp = "\\d{12}";
		if (Pattern.matches(sSegSocialRegexp, sSegSocial)) {
			this.sSegSocial = sSegSocial;
		}
	}
	
	public String toString() {
		String sResultado = "";
		
		if(super.checkPersona()) {
			sResultado += super.toString();
			
			if(this.getsSegSocial() != null) {
				sResultado += "Seguridad social: " + this.getsSegSocial() + "\n";
			}			
		}
		
		return sResultado;
	}
	
	public boolean checkEmpleado() {
		return super.checkPersona();
	}
	
}
