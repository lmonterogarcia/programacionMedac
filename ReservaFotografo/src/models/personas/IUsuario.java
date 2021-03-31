package models.personas;

public interface IUsuario {
    
	public String getsEmail();
	public void setsEmail(String sEmail);
	public String getsPassword();
	public void setsPassword(String sPassword);
	public boolean checkUsuario();
    public int hashCode();
    public boolean equals(Object obj);
	public String toString();

}
