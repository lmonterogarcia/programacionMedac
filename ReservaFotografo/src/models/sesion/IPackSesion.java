package models.sesion;

import models.productos.Pack;

public interface IPackSesion {

    public Pack getoPack();
    public void setoPack(Pack oPack);
    public Sesion getoSesion();
    public void setoSesion(Sesion oSesion);

    public boolean checkPackSesion();
    public int hashCode();
    public boolean equals(Object obj);
}
