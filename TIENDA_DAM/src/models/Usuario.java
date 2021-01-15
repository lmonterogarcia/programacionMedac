package models;

public class Usuario {
	
	private final int MAXCARACTERES = 250;
	private String sEmail; // PK
	private String sPassword; // NN

	public Usuario(String sEmail) {
		setsEmail(sEmail);
	}

	public Usuario(String sEmail, String sPassword) {
		setsEmail(sEmail);
		setsPassword(sPassword);
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		if (sEmail != null && sEmail.contains("@") && sEmail.length() < MAXCARACTERES) {
			this.sEmail = sEmail;
		}
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		if(sPassword != null && sPassword.length() > 5 && sPassword.length() < 12) {
			this.sPassword = sPassword;	
		}		
	}
	
	public boolean checkUsuario() {
		boolean bExito = false;
		if(this.getsEmail() != null && this.getsPassword() != null) {
			bExito = true;
		}
		return bExito;
	}
}
