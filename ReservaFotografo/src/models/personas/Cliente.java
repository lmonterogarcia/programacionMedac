package models.personas;

import java.time.LocalDate;
import models.lugar.Lugar;

public class Cliente extends Contacto implements ICliente {

    // NN
    private Usuario oUsuario;
    // N
    private Lugar oLugar;

    // ###Contructores###

    public Cliente(int iIdContacto) {
        super(iIdContacto);
    }

    public Cliente(String sNombreContacto, Usuario oUsuario) {
        super(sNombreContacto);
        setoUsuario(oUsuario);
    }

    public Cliente(String sDniContacto, String sNombreContacto, String sApellido1Contacto, String setsApellido2Contacto,
            String sTelefonoContacto, LocalDate oFechaNacimientoContacto, Usuario oUsuario, Lugar oLugar) {
        super(sDniContacto, sNombreContacto, sApellido1Contacto, setsApellido2Contacto, sTelefonoContacto,
            oFechaNacimientoContacto);
        setoUsuario(oUsuario);
        setoLugar(oLugar);
    }

    // ###GET and SET###

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        if (oUsuario != null) {
            this.oUsuario = oUsuario;
        }
    }

    public Lugar getoLugar() {
        return oLugar;
    }

    public void setoLugar(Lugar oLugar) {
        if (oLugar != null) {
            this.oLugar = oLugar;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkCliente() {
		return super.checkContacto();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

    public String toString() {
        String sMensaje ="\nInformacion del Cliente\n" +  super.toString();
        if (this.oUsuario != null) {
            sMensaje += oUsuario.toString();
        }
        if (this.oLugar != null) {
            sMensaje += oLugar.toString();
        }
        return sMensaje;
    }
}
