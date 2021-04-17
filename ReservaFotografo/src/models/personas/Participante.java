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

    public Participante(int iIdContacto, String sDniContacto) {
        super(iIdContacto);
        super.setsDniContacto(sDniContacto);
    }

    public Participante(String sDniContacto, String sNombreContacto) {
        super(sNombreContacto);
        super.setsDniContacto(sDniContacto);
    }

    public Participante(String sDniContacto, String sNombreContacto, String sApellido1Contacto, String sApellido2Contacto,
            String sTelefonoContacto, LocalDate oFechaNacimientoContacto, String sEmailParticipante) {
        super(sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto,
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

    public boolean checkParticipante() {
        boolean booExito = false;
        if (getsDniContacto() != null  &&super.checkContacto() ) {
            booExito = true;
        }
		return booExito;
	}
	
	public boolean equals(Object obj) {
		boolean booExito = false;
        Participante oParticipante = (Participante) obj;
        if (super.equals(obj) && oParticipante.getsDniContacto() != null && this.getsDniContacto().equals(oParticipante.getsDniContacto())) {
            booExito = true;
        }
        return booExito;
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
