package models.personas;

public class Usuario implements IUsuario {

    private String sEmail; //PK
    private String sPassword; //NN

    //Contructores
    public Usuario(String sEmail){
        setsEmail(sEmail);
    }
    public Usuario(String sEmail, String sPassword) {
        setsEmail(sEmail);
        setsPassword(sPassword);
    }

    //GET and SET
    public String getsEmail() {
        return this.sEmail;
    }
    public void setsEmail(String sEmail) {
        if (sEmail != null && !sEmail.isEmpty() && sEmail.contains("@") && sEmail.length() < MAXCARACTERES) {
			this.sEmail = sEmail;
		}
    }
    public String getsPassword() {
        return this.sPassword;
    }
    public void setsPassword(String sPassword) {
        if (sPassword != null && !sPassword.isEmpty() && sPassword.length() > 5 && sPassword.length() < 15) {
			this.sPassword = sPassword;
		}
    }

    //Metodos de la clase
    public boolean checkUsuario() {
        boolean bExito = false;
		if (this.getsEmail() != null && this.getsPassword() != null) {
			bExito = true;
		}
		return bExito;
    }

    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sEmail == null) ? 0 : sEmail.hashCode());
		return result;
	}
    
    public boolean equals(Object obj) {
		boolean bExito = false;
		Usuario oUser = (Usuario) obj;
		if (oUser.getsEmail() != null && this.getsEmail() != null && this.getsEmail().equals(oUser.getsEmail())) {
			bExito = true;
		}
		return bExito;
	}
}
