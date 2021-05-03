package models.sesion;

import models.personas.Fotografo;

public interface IFotografoSesion {

    public Fotografo getoFotografo();
    public void setoFotografo(Fotografo oFotografo);
    public Sesion getoSesion();
    public void setoSesion(Sesion oSesion);

    public boolean checkFotografoSesion();
    public int hashCode();
    public boolean equals(Object obj);
}
