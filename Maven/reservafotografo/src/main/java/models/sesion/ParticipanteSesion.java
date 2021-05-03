package models.sesion;

import models.personas.Participante;

public class ParticipanteSesion implements IParticipanteSesion {

    // PK
    private Participante oParticipante;
    private Sesion oSesion;

    // ###Contructores###
    public ParticipanteSesion(Participante oParticipante, Sesion oSesion) {
        this.setoParticipante(oParticipante);
        this.setoSesion(oSesion);
    }
    // ###GET and SET###

    public Participante getoParticipante() {
        return oParticipante;
    }

    public void setoParticipante(Participante oParticipante) {
        if (oParticipante != null) {
            this.oParticipante = oParticipante;
        }
    }

    public Sesion getoSesion() {
        return oSesion;
    }

    public void setoSesion(Sesion oSesion) {
        if (oSesion != null) {
            this.oSesion = oSesion;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkParticipanteSesion() {
        boolean booExito = false;
        if (this.getoParticipante().checkContacto() && this.getoSesion().checkSesion()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oSesion == null) ? 0 : oSesion.hashCode());
        result = prime * result + ((oParticipante == null) ? 0 : oParticipante.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        ParticipanteSesion oParticipanteSesion = (ParticipanteSesion) obj;
        if (oParticipanteSesion.getoParticipante() != null && oParticipanteSesion.getoSesion() != null && this != null
                && oParticipanteSesion.getoParticipante().equals(this.getoParticipante())
                && oParticipanteSesion.getoSesion().equals(this.getoSesion())) {
            booExito = true;
        }
        return booExito;
    }
}
