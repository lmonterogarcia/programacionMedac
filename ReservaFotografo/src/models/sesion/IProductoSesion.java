package models.sesion;

import models.productos.Producto;

public interface IProductoSesion {

    public Sesion getoSesion();
    public void setoSesion(Sesion oSesion);
    public Producto getoProducto();
    public void setoProducto(Producto oProducto);

    public boolean checkSesionProducto();
    public int hashCode();
    public boolean equals(Object obj);
}
