package models.productos;

public interface IProducto {

    public int getiIdProducto();
    public void setiIdProducto(int iIdProducto);
    public String getsNombreProducto();
    public void setsNombreProducto(String sNombreProducto);
    public float getfPrecioProducto();
    public void setfPrecioProducto(float fPrecioProducto);
    public float getfCosteProducto();
    public void setfCosteProducto(float fCosteProducto);
    public String getsProveedroProducto();
    public void setsProveedroProducto(String sProveedroProducto);
    public String getsDescripcionProducto();
    public void setsDescripcionProducto(String sDescripcionProducto);

    public boolean checkProducto();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
