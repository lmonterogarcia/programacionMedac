package models.sesion;

public interface ITipoSesion {

    public String getsNombreTipoSesion();
    public void setsNombreTipoSesion(String sNombreTipoSesion);
    public short getShDuracionTipoSesion();
    public void setShDuracionTipoSesion(short shDuracionTipoSesion);

    public boolean checkTipoSesion();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
