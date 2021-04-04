package models.productos;

public interface IPackProducto {

    public Pack getoPack();
    public void setoPack(Pack oPack);
    public Producto getoProducto();
    public void setoProducto(Producto oProducto);

    public boolean checkPackProducto();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
