package models.sesion;

import models.personas.Participante;

public interface IParticipanteSesion {

    public Participante getoParticipante();
    public void setoParticipante(Participante oParticipante);
    public Sesion getoSesion();
    public void setoSesion(Sesion oSesion);

    public boolean checkParticipanteSesion();
    public int hashCode();
    public boolean equals(Object obj);
}
