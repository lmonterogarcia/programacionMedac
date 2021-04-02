package models.personas;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Participante extends Contacto implements IParticipante{
    
    //N
    private String sEmailParticipante;

    // ###Contructores###

    public Participante(int iIdContacto) {
        super(iIdContacto);
    }

    public Participante(String sNombreContacto) {
        super(sNombreContacto);
    }

    public Participante(String sDniContacto, String sNombreContacto, String sApellido1Contacto, String setsApellido2Contacto,
            String sTelefonoContacto, LocalDate oFechaNacimientoContacto, String sEmailParticipante) {
        super(sDniContacto, sNombreContacto, sApellido1Contacto, setsApellido2Contacto, sTelefonoContacto,
            oFechaNacimientoContacto);
            setsEmailParticipante(sEmailParticipante);
    }

    // ###GET and SET###

    public String getsEmailParticipante() {
        return sEmailParticipante;
    }

    public void setsEmailParticipante(String sEmailParticipante) {
        if (sEmailParticipante != null && !sEmailParticipante.isEmpty() && sEmailParticipante.length() < BMAXEMAIL && Pattern.matches(SPATRONEMAIL, sEmailParticipante)) {
			this.sEmailParticipante = sEmailParticipante;
		}
        this.sEmailParticipante = sEmailParticipante;
    }
    
    // ###Metodos de esta clase###

    public boolean checkCliente() {
		return super.checkContacto();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

    public String toString() {
        String sMensaje ="";
        if (getiIdContacto() >= 0 && getiIdContacto() <= IMAXIDS) {
            sMensaje ="\nInformacion del Cliente" + "\n Id: " + SLETRAPARTICIPANTE + String.format("%06d" , getiIdContacto()) + super.toString();
            if (getsEmailParticipante() != null) {
                sMensaje += "\n Email: " + getsEmailParticipante();
            }
        }
        return sMensaje;
    }
}
