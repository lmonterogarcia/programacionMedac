package models.personas;

public interface IUsuarios {
    
    public final int MAXCARACTERES = 255;
	public String getsEmail();
	public void setsEmail(String sEmail);
	public String getsPassword();
	public void setsPassword(String sPassword);
	public boolean checkUsuario();
    public int hashCode();
    public boolean equals(Object obj);

}
