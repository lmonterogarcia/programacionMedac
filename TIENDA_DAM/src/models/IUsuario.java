package models;

public interface IUsuario {
	
	public final int MAXCARACTERES = 250;
	public String getsEmail();
	public void setsEmail(String sEmail);
	public String getsPassword();
	public void setsPassword(String sPassword);
	public boolean checkUsuario();
}
