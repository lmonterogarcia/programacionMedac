package models.sesion;

public interface IEstadoTipoSesion {

    public TipoSesion getoTipoSesion();
    public void setoTipoSesion(TipoSesion oTipoSesion);
    public Estado getoEstado();
    public void setoEstado(Estado oEstado);
    public short getShOrden();
    public void setShOrden(byte bOrden);

    public boolean checkEstadoTipoSesion();
    public int hashCode();
    public boolean equals(Object obj);
}
