package models.sesion;

import models.productos.Producto;

public class ProductoSesion implements IProductoSesion{
    
    // PK
    private Sesion oSesion;
    private Producto oProducto;

    // ###Contructores###
    public ProductoSesion(Sesion oSesion, Producto oProducto) {
        this.setoSesion(oSesion);
        this.setoProducto(oProducto);
    }
    // ###GET and SET###

    public Sesion getoSesion() {
        return oSesion;
    }

    public void setoSesion(Sesion oSesion) {
        if (oSesion != null) {
            this.oSesion = oSesion;
        }
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        if (oProducto != null) {
            this.oProducto = oProducto;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkSesionProducto() {
        boolean booExito = false;
        if (this.getoSesion().checkSesion() && this.getoProducto().checkProducto()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oProducto == null) ? 0 : oProducto.hashCode());
        result = prime * result + ((oSesion == null) ? 0 : oSesion.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        ProductoSesion oSesionProducto = (ProductoSesion) obj;
        if (oSesionProducto.getoSesion() != null && oSesionProducto.getoProducto() != null
                && this.getoSesion().getiIdSesion() == oSesionProducto.getoSesion().getiIdSesion()
                && this.getoProducto().getiIdProducto() == oSesionProducto.getoProducto().getiIdProducto()) {
            booExito = true;
        }
        return booExito;
    }
}
