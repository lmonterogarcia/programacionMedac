package models;

public interface IPersona {
	public final int MAXCARACTERES = 250;
	public String getsDni();
	public void setsDni(String sDni);
	public String getsNombre();
	public void setsNombre(String sNombre);
	public String getsApellidos();
	public void setsApellidos(String sApellidos);
	public String getsDireccion();
	public void setsDireccion(String sDireccion);
	public String getsNumeroDireccion();
	public void setsNumeroDireccion(String sNumeroDireccion);
	public String getsTelefono();
	public void setsTelefono(String sTelefono);
	public Usuario getoUsuario();
	public void setoUsuario(Usuario oUsuario);
	public String toString();
	public boolean checkPersona();	
}
