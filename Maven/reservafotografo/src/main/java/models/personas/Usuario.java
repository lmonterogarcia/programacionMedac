package models.personas;

import java.util.regex.Pattern;
import models.IPlantilla;

public class Usuario implements IUsuario, IPlantilla {

    private String sEmail; //PK
    private String sPassword; //NN

    // ###Contructores###
    public Usuario(String sEmail){
        setsEmail(sEmail);
    }
    public Usuario(String sEmail, String sPassword) {
        setsEmail(sEmail);
        setsPassword(sPassword);
    }

    // ###GET and SET###
    public String getsEmail() {
        return this.sEmail;
    }
    public void setsEmail(String sEmail) {
        if (sEmail != null && !sEmail.isEmpty() && sEmail.length() < BMAXEMAIL && Pattern.matches(SPATRONEMAIL, sEmail)) {
			this.sEmail = sEmail;
		}
    }
    public String getsPassword() {
        return this.sPassword;
    }
    public void setsPassword(String sPassword) {
        if (sPassword != null && !sPassword.isEmpty() && sPassword.length() > BMINPASSW && sPassword.length() < BMAXPASSW) {
			this.sPassword = sPassword;
		}
    }

    //// ###Metodos de esta clase###
    public boolean checkUsuario() {
        boolean bExito = false;
		if (this.getsEmail() != null && !this.getsEmail().isEmpty() && this.getsPassword() != null) {
			bExito = true;
		}
		return bExito;
    }

    public boolean checkUsuarioSuper() {
        boolean bExito = false;
		if (this.getsEmail() != null && !this.getsEmail().isEmpty()) {
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

    public String toString(){
        String sMensaje = "";
        if (getsEmail() != null) {
            sMensaje += "\n Email: " + getsEmail();
            sMensaje += "\n Contaseña: **********";
        }
        return sMensaje;
    }
}
